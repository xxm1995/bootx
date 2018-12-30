package cn.bootx.system.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("cn.bootx.**.dao")
@ComponentScan("cn.bootx")
public class Application {
}
