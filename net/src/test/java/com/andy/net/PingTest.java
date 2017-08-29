package com.andy.net;

import org.junit.Test;

import static org.junit.Assert.assertNotSame;

/**
 * {@link Ping} 的测试类
 * <p>
 * Created by andy on 17-8-29.
 */

public class PingTest {

    @Test
    public void ping() {
        String s = Ping.ping("127.0.1.1");
        System.out.println("结果：" + s);
        assertNotSame(null, s);

    }
}
