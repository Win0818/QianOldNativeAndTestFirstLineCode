package com.qianft.m.qian.activity;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qianft.m.qian.R;
import com.qianft.m.qian.adapter.RateCouponPagerAdapter;
import com.qianft.m.qian.fragment.MyRedpacketFragment;
import com.qianft.m.qian.view.TopBar;

public class MyRateCouponActivity extends BaseActivity implements TopBar.topBarClickListenter, MyRedpacketFragment.OnFragmentInteractionListener{


    private TopBar mRateCouponTopBar;
    private TabLayout mRateCouponTabs;
    private ViewPager mRateCouponPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rate_coupon);
        initView();
    }
    private void initView() {
        mRateCouponTopBar = (TopBar) findViewById(R.id.my_ratecoupon_topbar);
        mRateCouponTopBar.setOnTopbarClickListner(this);
        mRateCouponTabs = (TabLayout) findViewById(R.id.my_ratecoupon_tabs);
        mRateCouponPager = (ViewPager) findViewById(R.id.ratecoupon_viewpager);
        mRateCouponPager.setAdapter(new RateCouponPagerAdapter(getSupportFragmentManager(), this));
        mRateCouponTabs.setupWithViewPager(mRateCouponPager);
        mRateCouponTabs.setTabMode(TabLayout.MODE_FIXED);
    }
    @Override
    public void onLeftClick() {
        this.finish();
    }
    @Override
    public void onRightClick() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
