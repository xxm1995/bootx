package cn.bootx.system.service;

import cn.bootx.api.service.UserService;
import cn.bootx.common.domain.UserDO;
import cn.bootx.system.main.TestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void save() {
        System.out.println(userService);
    }
    @Test
    @Rollback
    public void saveUser() {
        UserDO user = new UserDO();
        user.setUsername( "xxm" );
        user.setPassword( "admin" );
        System.out.println(userService.save( user ));
    }
    @Test
    public void getAll() {
        System.out.println(userService.list());
    }
}