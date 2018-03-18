package com.example.smartbutler.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.example.smartbutler.MainActivity;
import com.example.smartbutler.R;
import com.example.smartbutler.adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * @author 28556
 * @date 2018/3/17
 */

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    @BindView(R.id.vp_guide)
    ViewPager mVpGuide;
    @BindView(R.id.iv_point1)
    AppCompatImageView mIvPoint1;
    @BindView(R.id.iv_point2)
    AppCompatImageView mIvPoint2;
    @BindView(R.id.iv_point3)
    AppCompatImageView mIvPoint3;
    @BindView(R.id.iv_guide_jump_over)
    AppCompatImageView mIvJump;
    private List<View> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //设置默认图片
        setPointImg(true,mIvPoint1);
        setPointImg(false,mIvPoint2);
        setPointImg(false,mIvPoint3);
        View pager1 = View.inflate(this, R.layout.pager_item_one, null);
        View pager2 = View.inflate(this, R.layout.pager_item_two, null);
        View pager3 = View.inflate(this, R.layout.pager_item_three, null);
        mList.add(pager1);
        mList.add(pager2);
        mList.add(pager3);
        pager3.findViewById(R.id.btn_pager_start).setOnClickListener(this);
        //设置适配器
        mVpGuide.setAdapter(new GuideAdapter(mList));
        //监听ViewPager滑动
        mVpGuide.addOnPageChangeListener(this);
        mIvJump.setOnClickListener(this);
    }
    /**
     * 设置小原点的选中效果
     * @param isCheck1 是否选中
     * @param imageView 选中的小圆点图片
     */
    private void setPointImg(boolean isCheck1,AppCompatImageView imageView){
        if (isCheck1){
            imageView.setBackgroundResource(R.mipmap.point_on);
        }else {
            imageView.setBackgroundResource(R.mipmap.point_off);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * pager切换
     * @param position 切换页面位置
     */
    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                setPointImg(true,mIvPoint1);
                setPointImg(false,mIvPoint2);
                setPointImg(false,mIvPoint3);
                mIvJump.setVisibility(View.VISIBLE);
                break;
            case 1:
                setPointImg(false,mIvPoint1);
                setPointImg(true,mIvPoint2);
                setPointImg(false,mIvPoint3);
                mIvJump.setVisibility(View.VISIBLE);
                break;
            case 2:
                setPointImg(false,mIvPoint1);
                setPointImg(false,mIvPoint2);
                setPointImg(true,mIvPoint3);
                mIvJump.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pager_start:
            case R.id.iv_guide_jump_over:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            default:
                break;
        }
    }
}
