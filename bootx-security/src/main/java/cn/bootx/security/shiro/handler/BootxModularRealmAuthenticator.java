package cn.bootx.security.shiro.handler;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
 /**   
  *  自定义 ModularRealmAuthenticator
  *  重写doMultiRealmAuthentication方法
  *  拥有多个realm时,抛出第一个遇到的异常
  * @author xxm
  * @date 2018/11/27 15:44 
  * @version V1.0   
  */
public class BootxModularRealmAuthenticator extends ModularRealmAuthenticator {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

     /**
      * ,抛出realm中第一个遇到的异常
      * @param realms 领域认证器
      * @param token 认证凭证
      * @return aggregate
      */
    @Override
    protected AuthenticationInfo doMultiRealmAuthentication(Collection<Realm> realms, AuthenticationToken token) {
        AuthenticationStrategy strategy = getAuthenticationStrategy();
        AuthenticationInfo aggregate = strategy.beforeAllAttempts(realms, token);
        if (log.isTraceEnabled()) {
            log.trace("Iterating through {} realms for PAM authentication", realms.size());
        }
        for (Realm realm : realms) {
            aggregate = strategy.beforeAttempt(realm, token, aggregate);
            if (realm.supports(token)) {
                log.trace("Attempting to authenticate token [{}] using realm [{}]", token, realm);
                AuthenticationInfo info = null;
                //有异常从此处抛出
                info = realm.getAuthenticationInfo(token);
                aggregate = strategy.afterAttempt(realm, token, info, aggregate, null);
            } else {
                log.debug("Realm [{}] does not support token {}.  Skipping realm.", realm, token);
            }
        }
        aggregate = strategy.afterAllAttempts(token, aggregate);
        return aggregate;
    }
}
