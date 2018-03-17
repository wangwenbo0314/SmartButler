package com.example.smartbutler.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * 项目名： SmartButler
 * 包  名： com.example.smartbutler.ui
 * 文件名： BaseActivity
 *
 * @author 王文博
 * @date   2018/3/15
 * 描  述： Activity基类
 */

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    /**
     * 主要做的事情：
     * 1.统一的属性
     * 2.统一的接口
     * 3.统一的方法
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //显示返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    /**
     * 菜单栏操作
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
