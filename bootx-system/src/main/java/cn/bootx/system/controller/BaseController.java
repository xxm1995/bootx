package cn.bootx.system.controller;

import cn.bootx.common.domain.UserDO;
import cn.bootx.security.utils.SecurityUtils;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	public UserDO getUser() {
		return SecurityUtils.getUser();
	}

	public String getUserId() {
		return getUser().getId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}