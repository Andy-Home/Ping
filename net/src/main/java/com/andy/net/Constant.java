package com.andy.net;

/**
 * 定义常量,以及常量初始化
 * <p>
 * Created by andy on 17-8-29.
 */

public class Constant {
    /**
     * 系统类型, 1为Windows,0为Linux
     */
    private int OS = -1;

    private static Constant mConstant = null;

    private Constant() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            OS = 1;
        } else {
            OS = 0;
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
}
