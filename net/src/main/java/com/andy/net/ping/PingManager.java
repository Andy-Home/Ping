package com.andy.net.ping;

/**
 * 关于Ping类的相关操作管理接口
 * <p>
 * Created by andy on 17-8-29.
 */

public class PingManager {

    private static PingManager mPingManager = null;
    private Ping mPing;

    private PingManager() {
    }

    public static PingManager getInstance() {
        if (mPingManager == null) {
            mPingManager = new PingManager();
        }
        return mPingManager;
    }

    public boolean isConnect(String ip) {
        String msg = Ping.ping(ip);
        return msg.equalsIgnoreCase("ttl");
    }

    public String ping(String ip) {
        return Ping.ping(ip);
    }
}
