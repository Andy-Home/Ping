package com.andy.net;

/**
 * 定义常量,以及常量初始化
 * <p>
 * Created by andy on 17-8-29.
 */

public class Constant {
    private static Constant mConstant = null;
    /**
     * 系统类型, 1为Windows,0为Linux
     */
    private int OS = -1;
    /**
     * 数据流编码类型, 1为GBK,0为UTF-8
     * tip: 暂时默认Windows系统为GBK，Linux为UTF-8
     */
    private int STREAM_ENCODE = -1;

    private Constant() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            OS = 1;
            STREAM_ENCODE = 1;
        } else {
            OS = 0;
            STREAM_ENCODE = 0;
        }

    }

    public static Constant getInstance() {
        if (mConstant == null) {
            mConstant = new Constant();
        }
        return mConstant;
    }

    public boolean isLinux() {
        return OS == 0;
    }

    public String getStreamEncode() {
        if (STREAM_ENCODE == 0) {
            return "UTF-8";
        } else {
            return "GBK";
        }
    }
}
