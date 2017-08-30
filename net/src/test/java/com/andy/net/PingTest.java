package com.andy.net;

import com.andy.net.ping.Ping;
import com.andy.net.ping.PingManager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * {@link Ping} 的测试类
 * <p>
 * Created by andy on 17-8-29.
 */

public class PingTest {
    private PingManager mPingManager;

    @Before
    public void init() {
        mPingManager = PingManager.getInstance();
    }

    @Test
    public void ping() {
        String s = mPingManager.ping("127.0.1.1");
        System.out.println("=========================");
        System.out.println(s);
        assertNotSame(null, s);
    }

    @Test
    public void isConnect1() {
        boolean flag = mPingManager.isConnect("127.0.1.1");
        System.out.println("是否连通：" + flag);
        assertEquals(true, flag);
    }

    @Test
    public void isConnect2() {
        boolean flag = mPingManager.isConnect("192.168.11.135");
        System.out.println("是否连通：" + flag);
        assertEquals(false, flag);
    }
}
