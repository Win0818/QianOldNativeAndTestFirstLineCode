package com.qianft.m.qian.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qianft.m.qian.fragment.MyRedpacketFragment;

/**
 * Created by Administrator on 2017/2/7.
 */

public class RedpacketPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = {"待使用红包", "已使用红包", "已过期红包"};
    private Context context;
    public RedpacketPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        return MyRedpacketFragment.newInstance("aa" + position, "bbb" + position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
