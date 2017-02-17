package com.qianft.m.qian.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qianft.m.qian.fragment.AccountCreditorFragment;

/**
 * Created by Administrator on 2017/2/9.
 */

public class AccCreditorPagerAdapter extends FragmentPagerAdapter{

    private Context context;
    private static final int PAGE_CCOUNT = 2;
    private String[] tabTitles =  {"持有中", "收益中"};
    public AccCreditorPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return AccountCreditorFragment.newInstance("aaaaaa", "bbbbbb");
    }

    @Override
    public int getCount() {
        return PAGE_CCOUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
