package com.andy.net.ping;

import android.util.Log;

import com.andy.net.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ping 命令测试
 * <p>
 * Created by andy on 17-8-29.
 */

public class Ping {
    private static final String TAG = "Ping";
    private static Runtime mRuntime = Runtime.getRuntime();

    public static String ping(String ip) {
        String result = null;
        try {
            Process p;
            if (Constant.getInstance().isLinux()) {
                p = mRuntime.exec("ping -c 4 " + ip);
            } else {
                p = mRuntime.exec("cmd /c ping " + ip);
            }
            result = streamToString(p);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "指令错误");
        }
        return result;
    }

    /**
     * 数据流转化为{@link String}
     */
    private static String streamToString(Process p) {
        InputStreamReader from = null;
        BufferedReader in = null;
        StringBuilder strBuffer = new StringBuilder();
        try {
            from = new InputStreamReader(p.getInputStream(), Constant.getInstance().getStreamEncode());  //Android默认的字符编码格式为UTF-8
            in = new BufferedReader(from);
            String temp;

            while ((temp = (in.readLine())) != null) {
                strBuffer.append(temp + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "数据流操作错误");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (from != null) {
                    from.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG, "数据流操作错误");
            }
        }
        return strBuffer.toString();
    }
}
