package com.example.smartbutler.application;

import android.app.Application;

import com.example.smartbutler.utils.StaticClass;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * 项目名： SmartButler
 * 包  名： com.example.smartbutler.application
 * 文件名： BaseApplication
 *
 * @author 王文博
 * @date 2018/3/15
 * 描  述： Application
 */
public class BaseApplication extends Application {
    /**
     * 创建
     */
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Bugly
        CrashReport.initCrashReport(getApplicationContext(), StaticClass.BUGLY_APP_ID, true);
    }
}
