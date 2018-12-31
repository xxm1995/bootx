package cn.bootx.common.utils;

import cn.bootx.common.main.TestApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class EncryptUtilsTest {
    @Test
    public void encrypt1() {
        Assert.assertNotNull(EncryptUtils.encrypt( "bootx" ));
        System.out.println(EncryptUtils.encrypt( "bootx" ));
    }

    @Test
    public void encrypt2() {
        Assert.assertNotNull( EncryptUtils.encrypt( "bootx" ,"bootdo") );
        System.out.println(EncryptUtils.encrypt( "bootx" ,"bootdo"));

    }

    @Test
    public void getSALT() {
        Assert.assertNotNull( EncryptUtils.getSALT() );
        System.out.println(EncryptUtils.getSALT());
    }

    @Test
    public void getAlgorithName() {
        Assert.assertNotNull( EncryptUtils.getAlgorithName() );
        System.out.println(EncryptUtils.getAlgorithName());
    }

    @Test
    public void getHashIterations() {
        int hashIterations = EncryptUtils.getHashIterations();
        Assert.assertNotEquals( hashIterations,0);
        System.out.println(hashIterations);
    }
}