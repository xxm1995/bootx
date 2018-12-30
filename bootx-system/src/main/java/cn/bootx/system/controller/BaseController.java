package cn.bootx.system.controller;

import cn.bootx.common.domain.UserDO;
import cn.bootx.security.shiro.utils.ShiroUtils;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}