package com.qianft.m.qian.activity;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qianft.m.qian.R;
import com.qianft.m.qian.adapter.AccCreditorPagerAdapter;
import com.qianft.m.qian.fragment.AccountCreditorFragment;
import com.qianft.m.qian.view.TopBar;

public class AccountCreditorActivity extends BaseActivity implements AccountCreditorFragment.OnFragmentInteractionListener
            ,TopBar.topBarClickListenter{

    private TabLayout mAccountCreditorTab;
    private ViewPager mAccountCreditorPager;
    private TopBar mAccountCreditorTopBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creditor);
        initView();
    }

    /**
     * 初始化界面
     */
    private void initView() {
        mAccountCreditorTopBar = (TopBar) findViewById(R.id.account_creditor_topbar);
        mAccountCreditorTopBar.setOnTopbarClickListner(this);
        mAccountCreditorTab = (TabLayout) findViewById(R.id.account_creditor_tab);
        mAccountCreditorPager = (ViewPager) findViewById(R.id.account_creditor_viewpager);
        mAccountCreditorPager.setAdapter(new AccCreditorPagerAdapter(this, getSupportFragmentManager()));
        mAccountCreditorTab.setupWithViewPager(mAccountCreditorPager);
        mAccountCreditorTab.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onLeftClick() {
        this.finish();;
    }

    @Override
    public void onRightClick() {

    }
}
