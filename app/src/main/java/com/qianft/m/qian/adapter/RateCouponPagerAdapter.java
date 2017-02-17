package com.qianft.m.qian.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qianft.m.qian.fragment.MyRedpacketFragment;

/**
 * Created by Administrator on 2017/2/8.
 */

public class RateCouponPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = {"待使用", "已使用", "已过期"};
    private Context context;

    public RateCouponPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return MyRedpacketFragment.newInstance("aaa" , "aaaa");
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
