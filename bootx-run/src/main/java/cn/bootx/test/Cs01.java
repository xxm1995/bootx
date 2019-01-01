package cn.bootx.test;

import cn.bootx.api.service.UserService;
import cn.bootx.common.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Cs01 {

    @Autowired
    private UserService userService;

    @RequestMapping("/1")
    public String f1(){

        UserDO user = new UserDO();
//        user.setId( IDUtils.UUID() );
        user.setUsername( "admin" );
        user.setPassword( "admin" );

        System.out.println(userService.save(user));
        return "666";
    }
    @RequestMapping("/test")
    public String test(){

        return "ok";
    }
}
