package cn.bootx.security.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import cn.bootx.security.shiro.filter.ShiroLoginFilter;
import cn.bootx.security.shiro.handler.BDSessionListener;
import cn.bootx.security.shiro.handler.BootxModularRealmAuthenticator;
import cn.bootx.security.shiro.realm.UserNmaeAndPassWordRealm;
import cn.bootx.security.shiro.realm.WeiXinRealm;
import cn.bootx.security.shiro.session.BootxSessionManager;
import net.sf.ehcache.CacheManager;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

/**   
* shiro 自动配置类
* @author xxm  
* @date 2018/12/30 16:56 
* @version V1.0   
*/
//配置中开启时生效
@ConditionalOnProperty(prefix = "bootx.security.shiro",name = "enable", havingValue = "true")
//未自己设置shiro配置bean时生效
@ConditionalOnMissingBean(ShiroDefaultConfig.class)
@Configuration
public class ShiroAutoConfig {
    @Value("${spring.redis.host:}")
    private String host;
    @Value("${spring.redis.password:}")
    private String password;
    @Value("${spring.redis.port:}")
    private int port;
    @Value("${spring.redis.timeout:}")
    private int timeout;
    @Value("${spring.cache.type:}")
    private String cacheType ;
    @Value("${server.session-timeout:}")
    private int tomcatTimeout;

    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * ShiroDialect，为了在thymeleaf里使用shiro的标签的bean
     * @return ShiroDialect
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    /**
     * 系统原shiro认证器
     * @return Realm
     */
    @Bean
    UserNmaeAndPassWordRealm userRealm() {
        return new UserNmaeAndPassWordRealm();
    }

    /**
     * 微信认证器
     * @return Realm
     */
    @Bean
    WeiXinRealm weiXinRealm(){
        return new WeiXinRealm();
    }


    /**
     * shiro拦截器, 设置拦截规则
     * @param securityManager  安全管理器
     * @return shiroFilterFactoryBean
     */
    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //自定义拦截过滤器
        Map<String,Filter> filterMap = new HashMap<>(  );
        filterMap.put( "shiroLoginFilter",shiroLoginFilter() );
        shiroFilterFactoryBean.setFilters( filterMap );
        //拦截规则
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/home/**", "anon");
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/wxLogin","anon");
        filterChainDefinitionMap.put("/wxpay/result","anon");
        filterChainDefinitionMap.put("/wxpcpay/result","anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/sys/user/binding", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/docs/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/upload/**", "anon");
        filterChainDefinitionMap.put("/files/**", "anon");
        filterChainDefinitionMap.put("/logoutx", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/blog", "anon");
        filterChainDefinitionMap.put("/blog/open/**", "anon");
        filterChainDefinitionMap.put("/index/**", "anon");

        /**
         * wx测试
         */
        filterChainDefinitionMap.put("/wxpay/**", "anon");
        filterChainDefinitionMap.put("/exam/**", "anon");
        filterChainDefinitionMap.put("/examRegistration/**", "anon");
        filterChainDefinitionMap.put("/**", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 自定义过滤器, 必须放到shiroFilterFactoryBean下面, 否则报错
     * @return ShiroLoginFilter
     */
    @Bean
    public ShiroLoginFilter shiroLoginFilter(){
        return new ShiroLoginFilter();
    }
    /**
     * shiro 安全管理器设置
     * @return SecurityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        List<Realm> realms = new ArrayList<>(  );
        realms.add( weiXinRealm() );
        realms.add( userRealm() );
        //设置securityManager 的 realm组.
        securityManager.setRealms( realms );
        //设置session管理器
        securityManager.setSessionManager(sessionManager());
        //自定义的模块化领域认证(cs)
        ModularRealmAuthenticator authenticator = new BootxModularRealmAuthenticator();
        /*
         * 设置 authenticator 的 realm 组
         * 注意,这的设置 realm 和前面 securityManager 设置realm没有关系
         * 两边都需要进行设置,这边的用于登录的校验, securityManager 中的暂时不确定
         */
        authenticator.setRealms( realms );
        securityManager.setAuthenticator( authenticator );
        // 自定义缓存实现 使用redis
//        if (Constant.CACHE_TYPE_REDIS.equals(cacheType)) {
////            securityManager.setCacheManager(rediscacheManager());
//        } else {
            securityManager.setCacheManager(ehCacheManager());
//        }
        return securityManager;
    }

    /**
     * shiro session管理器
     * 自定义了获取session的方式
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new BootxSessionManager();
        sessionManager.setGlobalSessionTimeout(tomcatTimeout * 1000);
//        sessionManager.setSessionDAO(sessionDAO());
        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
        listeners.add(new BDSessionListener());
        sessionManager.setSessionListeners(listeners);
        return sessionManager;
    }

    /**
     * 开启shiro aop注解支持。
     * 进行注解权限校验时需要使用代理方式;
     * 所以需要开启代码支持;
     *
     * @param securityManager  shiro 安全管理器
     * @return AuthorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 配置shiro redisManager
     *
     * @return
     */
//    @Bean
//    public RedisManager redisManager() {
//        RedisManager redisManager = new RedisManager();
//        redisManager.setHost(host);
//        redisManager.setPort(port);
//        redisManager.setExpire(1800);// 配置缓存过期时间
//        //redisManager.setTimeout(1800);
//        redisManager.setPassword(password);
//        return redisManager;
//    }

    /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
//    public RedisCacheManager rediscacheManager() {
//        RedisCacheManager redisCacheManager = new RedisCacheManager();
//        redisCacheManager.setRedisManager(redisManager());
//        return redisCacheManager;
//    }


    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     */
//    @Bean
//    public RedisSessionDAO redisSessionDAO() {
//        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
//        redisSessionDAO.setRedisManager(redisManager());
//        return redisSessionDAO;
//    }

//    @Bean
//    public SessionDAO sessionDAO() {
//        if (Constant.CACHE_TYPE_REDIS.equals(cacheType)) {
//            return redisSessionDAO();
//        } else {
//            return new MemorySessionDAO();
//        }
//    }



    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManager(cacheManager());
        return em;
    }

    @Bean("cacheManager2")
    CacheManager cacheManager(){
        return CacheManager.create();
    }


}
