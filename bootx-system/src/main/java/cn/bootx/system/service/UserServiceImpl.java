package cn.bootx.system.service;

import cn.bootx.api.service.UserService;
import cn.bootx.common.domain.UserDO;
import cn.bootx.common.exception.UserRepeatException;
import cn.bootx.common.utils.MD5Utils;
import cn.bootx.system.dao.UserDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserDO> implements UserService<UserDO> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;
    @Override
    public boolean save(UserDO userDO) {
        String password = MD5Utils.encrypt( userDO.getUsername(), userDO.getPassword() );
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDO.getUsername());
        Integer integer = userDao.selectCount( queryWrapper );
        if (integer>0){
            logger.info( "插入账号重复" );
            throw new UserRepeatException("账号重复");
        }
        userDO.setPassword( password );
        return super.save( userDO );
    }
}
