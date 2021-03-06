package cn.bootx.run;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * @author xxm
 * @date 2018/12/30 12:08
 * @version V1.0
 */
@SpringBootApplication
@MapperScan("cn.bootx.**.dao")
@ComponentScan("cn.bootx")
public class Application {
 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
  System.out.println(
          "  ____   ____   ____ _________   __\n" +
                  " |  _ \\ / __ \\ / __ \\__   __\\ \\ / /\n" +
                  " | |_) | |  | | |  | | | |   \\ V / \n" +
                  " |  _ <| |  | | |  | | | |    > <  \n" +
                  " | |_) | |__| | |__| | | |   / . \\ \n" +
                  " |____/ \\____/ \\____/  |_|  /_/ \\_\\"
  );
 }
}
