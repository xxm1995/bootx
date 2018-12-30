package cn.bootx.system.service;

import cn.bootx.api.service.UserService;
import cn.bootx.common.domain.UserDO;
import cn.bootx.system.dao.UserDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserDO> implements UserService<UserDO> {

}
