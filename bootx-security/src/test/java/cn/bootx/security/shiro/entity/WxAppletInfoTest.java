package cn.bootx.security.shiro.entity;

import cn.bootx.security.main.TestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class WxAppletInfoTest {

    @Test
    public void setAppid() {
        System.out.println(WxAppletInfo.getAppid());
    }

    @Test
    public void setSecret() {
        System.out.println(WxAppletInfo.getSecret());
    }
}