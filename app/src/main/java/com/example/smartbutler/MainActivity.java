package com.example.smartbutler;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.smartbutler.fragment.ButlerFragment;
import com.example.smartbutler.fragment.GirlFragment;
import com.example.smartbutler.fragment.UserFragment;
import com.example.smartbutler.fragment.WechatFragment;
import com.example.smartbutler.ui.SettingActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 王文博
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tl_main_title)
    TabLayout mTabLayout;
    @BindView(R.id.vp_main_pager)
    ViewPager mViewPager;
    @BindView(R.id.fab_main_setting)
    FloatingActionButton mFabSetting;
    private List<String> mTitle;
    private List<Fragment> mFragment;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //去掉阴影
        getSupportActionBar().setElevation(0);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        //默认隐藏悬浮图标
        mFabSetting.setVisibility(View.GONE);
        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());
        //mViewPager滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mFabSetting.setVisibility(View.GONE);
                } else {
                    mFabSetting.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的item
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            //返回item的个数
            @Override
            public int getCount() {
                return mFragment.size();
            }

            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });
        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
        mFabSetting.setOnClickListener(v ->
            startActivity(new Intent(this, SettingActivity.class)));
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mTitle = new ArrayList<>();
        mTitle.add("服务管家");
        mTitle.add("微信精选");
        mTitle.add("美女社区");
        mTitle.add("个人中心");
        mFragment = new ArrayList<>();
        mFragment.add(new ButlerFragment());
        mFragment.add(new WechatFragment());
        mFragment.add(new GirlFragment());
        mFragment.add(new UserFragment());
    }
}
