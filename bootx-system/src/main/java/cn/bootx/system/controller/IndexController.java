package cn.bootx.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class IndexController extends BaseController {

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView(  );
    }
}
