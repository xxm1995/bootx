package cn.bootx.security.shiro.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class WxSessionDOTest {

    @Test
    public void getOpenid() {
        System.out.println((new WxSessionDO()).getOpenid());
    }
}