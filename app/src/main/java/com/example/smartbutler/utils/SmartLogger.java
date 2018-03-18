package com.example.smartbutler.utils;

import com.orhanobut.logger.Logger;

/**
 * Created by 28556 on 2018/3/17.
 */

public class SmartLogger {
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;

    //控制log等级
    private static int LEVEL = VERBOSE;

    public static void v(String tag, String message) {
        if (LEVEL <= VERBOSE) {
            Logger.t(tag).v(message);
        }
    }
    public static void d(String tag,Object message){
        if (LEVEL <= DEBUG){
            Logger.t(tag).d(message);
        }
    }
    public static void d(Object message){
        if (LEVEL <= DEBUG){
            Logger.d(message);
        }
    }
    public static void i(String tag,String message){
        if (LEVEL <= DEBUG){
            Logger.t(tag).i(message);
        }
    }
    public static void w(String tag,String message){
        if (LEVEL <= DEBUG){
            Logger.t(tag).w(message);
        }
    }
    public static void json(String tag,String message){
        if (LEVEL <= DEBUG){
            Logger.t(tag).json(message);
        }
    }
    public static void e(String tag,String message){
        if (LEVEL <= DEBUG){
            Logger.t(tag).e(message);
        }
    }

}
