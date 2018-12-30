package cn.bootx.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author xxm
 * @date 2018/12/30 12:08
 * @version V1.0
 */
@SpringBootApplication
public class Application {
 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
  System.out.println(
          "\n" +
                  "M\"\"M M\"\"\"\"\"\"\"\"M d88888P d8888b. d8888b. .d8888P \n" +
                  "M  M Mmmm  mmmM     d8'     `88     `88 88'     \n" +
                  "M  M MMMM  MMMM    d8'   aaad8' .aaadP' 88baaa. \n" +
                  "M  M MMMM  MMMM   d8'       `88 88'     88` `88 \n" +
                  "M  M MMMM  MMMM  d8'        .88 88.     8b. .d8 \n" +
                  "M  M MMMM  MMMM d8'     d88888P Y88888P `Y888P' \n" +
                  "MMMM MMMMMMMMMM    "
  );
 }
}
