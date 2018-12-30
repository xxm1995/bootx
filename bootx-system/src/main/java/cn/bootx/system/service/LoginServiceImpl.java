package cn.bootx.system.service;

import cn.bootx.api.service.LoginService;
import cn.bootx.common.domain.UserDO;
import cn.bootx.common.exception.UserErrorException;
import cn.bootx.common.exception.UserNotFoundException;
import cn.bootx.common.utils.MD5Utils;
import cn.bootx.system.dao.UserDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录类操作接口
 * @author xxm
 * @date 2018/12/30 17:19
 * @version V1.0
 */
@Service
public class LoginServiceImpl extends ServiceImpl<UserDao, UserDO> implements LoginService<UserDO> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;

    @Override
    public UserDO loginByUseerName(String username, String password) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", password);
        UserDO user = userDao.selectOne(queryWrapper);
        if (user != null) {
            String s = MD5Utils.encrypt(user.getUsername(), user.getPassword());
            if (user.getPassword().equals(s)) {
                return user;
            }else{
                logger.error("密码错误");
                throw new UserErrorException( "密码错误" );
            }
        }else{
            logger.error("账号不存在");
            throw new UserNotFoundException( "账号不存在" );
        }
    }

    @Override
    public UserDO loginByUseerName(UserDO userDO) {
        return loginByUseerName(userDO.getUsername(),userDO.getPassword());
    }
}
