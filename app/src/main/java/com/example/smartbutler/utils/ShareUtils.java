package com.example.smartbutler.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 28556 on 2018/3/17.
 */

public class ShareUtils {
    private static final String NAME = "config";

    /**
     * 设置字符串存储
     *
     * @param mContext
     * @param key      键
     * @param value    值
     */
    public static void putString(Context mContext, String key, String value) {
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }

    /**
     * 获取字符串值
     *
     * @param mContext
     * @param key      键
     * @param defValue 默认值
     */
    public static String getString(Context mContext, String key, String defValue) {
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    /**
     * @param mContext
     * @param key      键
     * @param value    值
     */
    public static void putInt(Context mContext, String key, int value) {
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).apply();
    }

    /**
     * @param mContext
     * @param key      键
     * @param defValue 默认值
     */
    public static int getInt(Context mContext, String key, int defValue) {
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    /**
     * @param mContext
     * @param key      键
     * @param value    值
     */
    public static void putBoolean(Context mContext, String key, boolean value) {
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

    /**
     * @param mContext
     * @param key      键
     * @param defValue 默认值
     */
    public static boolean getBoolean(Context mContext, String key, boolean defValue) {
        SharedPreferences sp = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    /**
     * 删除单个数据
     * @param mContext
     * @param key
     */
    public static void deleteShare(Context mContext, String key) {
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().remove(key).apply();
    }

    /**
     * 删除全部数据
     * @param mContext
     */
    public static void deleteAll(Context mContext){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().clear();
    }
}
