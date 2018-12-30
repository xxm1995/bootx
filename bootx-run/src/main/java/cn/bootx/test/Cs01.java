package cn.bootx.test;

import cn.bootx.api.service.UserService;
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

        System.out.println(userService.list());
        return "666";
    }
}
