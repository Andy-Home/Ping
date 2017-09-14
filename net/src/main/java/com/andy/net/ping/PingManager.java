package com.andy.net.ping;

import android.util.Log;

/**
 * 关于Ping类的相关操作管理接口
 * <p>
 * Created by andy on 17-8-29.
 */

public class PingManager {
    private static final String TAG = "PingManager";
    private static PingManager mPingManager = null;

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
        if (msg == null) {
            return false;
        }
        msg = msg.toLowerCase();
        if (msg.contains("ttl")) {
            return true;
        } else if (msg.contains("destination host unreachable")) {
            Log.e(TAG, "Destination Host Unreachable");
        } else if (msg.contains("request timed out")) {
            Log.e(TAG, "Request timed out");
        } else if (msg.contains("bad ip address")) {
            Log.e(TAG, "Bad IP address");
        } else if (msg.contains("source quench received")) {
            Log.e(TAG, "Source quench received");
        } else if (msg.contains("unknown host")) {
            Log.e(TAG, "Unknown host");
        } else if (msg.contains("no answer")) {
            Log.e(TAG, "No answer");
        } else if (msg.contains("no rout to host")) {
            Log.e(TAG, "no rout to host");
        } else if (msg.contains("transmit failed, error code")) {
            Log.e(TAG, "transmit failed，error code");
        } else if (msg.contains("unknown host name")) {
            Log.e(TAG, "unknown host name");
        }
        return false;
    }

    public String ping(String ip) {
        return Ping.ping(ip);
    }
}
