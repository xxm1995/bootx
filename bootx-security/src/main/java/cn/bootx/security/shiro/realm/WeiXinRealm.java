package cn.bootx.security.shiro.realm;

import cn.bootx.common.domain.UserDO;
import cn.bootx.security.shiro.entity.WxToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
@Slf4j
public class WeiXinRealm extends AuthorizingRealm {
    /**
     * 判断此Realm是否支持此Token
     *
     * @param token tocken
     * @return 是否支持 WxToken
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof WxToken;
    }
    /**
     * 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 身份认证
     * @param token token
     * @return SimpleAuthenticationInfo
     * @throws AuthenticationException ex
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws RuntimeException {
        WxToken wxToken = (WxToken) token;
        UserDO user = null;
        user = null;
        // 账号不存在
        if (user == null){
            throw new UnknownAccountException("未找到账号");
        }
        // 账号锁定
        // TODO 数据库没有默认值，获取到类型integer 为 null
        if (user.getStatus() == 0||user.getStatus()==null) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        return new SimpleAuthenticationInfo( user, wxToken.getCredentials(), getName() );
    }


    @Override
    public String getName() {
        return "WxRealm";
    }
}
