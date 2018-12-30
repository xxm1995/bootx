package cn.bootx.system.service;

import cn.bootx.api.service.LoginService;
import cn.bootx.common.domain.UserDO;
import cn.bootx.system.dao.UserDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.catalina.User;

public class LoginServiceImpl extends ServiceImpl<UserDao, UserDO> implements LoginService<UserDO> {
    @Override
    public User loginByUseerName(String username, String password) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", password);
        return null;
    }
}
