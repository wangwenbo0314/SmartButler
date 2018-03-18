package com.example.smartbutler.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.example.smartbutler.MainActivity;
import com.example.smartbutler.R;
import com.example.smartbutler.utils.ShareUtils;
import com.example.smartbutler.utils.StaticClass;
import com.example.smartbutler.utils.UtilTools;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 28556
 * @date 2018/3/17
 */

public class SplashActivity extends AppCompatActivity {

    /**
     * 1.延时2000ms
     * 2.判断程序是否第一次运行
     * 3.自定义字体
     * 4.Activity全屏主题
     */
    @BindView(R.id.tv_splash)
    AppCompatTextView mTvSplash;
    private final SplashHandler handler = new SplashHandler(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //延时2000ms
        handler.postDelayed(() -> handler.sendEmptyMessage(StaticClass.HANDLER_SPLASH),2000);
//        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH, 2000);
        //设置字体
        UtilTools.setFont(this,mTvSplash);
    }

    private static class SplashHandler extends Handler {
        private final WeakReference<SplashActivity> mActivity;

        SplashHandler(SplashActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SplashActivity splashActivity = mActivity.get();
            if (splashActivity != null){
                switch (msg.what) {
                    case StaticClass.HANDLER_SPLASH:
                        //判断程序是否为第一次运行
                        if (splashActivity.isFirst()) {
                            splashActivity.startActivity(new Intent(splashActivity, GuideActivity.class));
                        } else {
                            splashActivity.startActivity(new Intent(splashActivity, GuideActivity.class));
                        }
                        splashActivity.finish();
                        break;
                    default:
                        break;
                }
            }
        }
    }
    /**
     * 判断程序是否为第一次运行
     *
     * @return 是否为第一次运行
     */
    private boolean isFirst() {
        boolean isFirst = ShareUtils.getBoolean(this, StaticClass.SHARE_IS_FIRST, true);
        if (isFirst) {
            ShareUtils.putBoolean(this, StaticClass.SHARE_IS_FIRST, false);
            return true;
        } else {
            return false;
        }
    }
    /**
     * 禁止返回键
     */
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
