package com.qianft.m.qian.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.qianft.m.qian.R;
import com.qianft.m.qian.adapter.RedpacketPagerAdapter;
import com.qianft.m.qian.fragment.MyRedpacketFragment;
import com.qianft.m.qian.view.TopBar;

public class MyRedpacketActivity extends BaseActivity implements MyRedpacketFragment.OnFragmentInteractionListener,
        TopBar.topBarClickListenter{

    private TabLayout mRedpacketTab;
    private ViewPager mRedpacketViewPager;
    private TopBar mRedpacketTopBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_redpacket);
        initView();
    }

    private void initView() {
        mRedpacketTopBar = (TopBar) findViewById(R.id.my_redpacket_topbar);
        mRedpacketTopBar.setOnTopbarClickListner(this);
        mRedpacketTab = (TabLayout) findViewById(R.id.my_redpacket_tabs);
        mRedpacketViewPager = (ViewPager) findViewById(R.id.redpacket_viewpager);
        mRedpacketViewPager.setAdapter(new RedpacketPagerAdapter(getSupportFragmentManager(), this));
        mRedpacketTab.setupWithViewPager(mRedpacketViewPager);
        mRedpacketTab.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onLeftClick() {
        this.finish();
    }

    @Override
    public void onRightClick() {

    }
}
