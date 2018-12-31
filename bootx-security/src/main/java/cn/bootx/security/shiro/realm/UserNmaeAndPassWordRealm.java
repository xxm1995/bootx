package cn.bootx.security.shiro.realm;

import cn.bootx.common.domain.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 账号密码验证
 * @author xxm
 * @date 2018/11/21 16:29
 * @version V1.0
 */
@Slf4j
public class UserNmaeAndPassWordRealm extends AuthorizingRealm {
	/**
	 * 判断此Realm是否支持此Token
	 *
	 * @param token tocken
	 * @return 是否支持
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
//		Long userId = ShiroUtils.getUserId();
//		MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);
//		Set<String> perms = menuService.listPerms(userId);
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.setStringPermissions(perms);
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		UserDO userDO = null;
		// 账号不存在
		if (userDO==null){
			throw new UnknownAccountException("未找到账号");
		}
		// 密码错误
		if (!password.equals(userDO.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}
		// 账号锁定
		if (userDO.getStatus() == 0) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}
		return new SimpleAuthenticationInfo(userDO, password, getName());
	}

	/**
	 * 该realm的名字
	 * @return name
	 */
	@Override
	public String getName() {
		return "UserRealm";
	}
}
