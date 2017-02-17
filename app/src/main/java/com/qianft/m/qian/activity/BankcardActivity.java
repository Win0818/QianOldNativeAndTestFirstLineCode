package com.qianft.m.qian.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qianft.m.qian.R;
import com.qianft.m.qian.view.TopBar;

/**
 * Created by Administrator on 2017/2/6.
 */
public class BankcardActivity extends BaseActivity implements TopBar.topBarClickListenter{

    private TopBar mBankcardTopBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankcard);
        initView();
    }

    private void initView() {
        mBankcardTopBar = (TopBar) findViewById(R.id.my_bankcard_topbar);
        mBankcardTopBar.setOnTopbarClickListner(this);
    }

    @Override
    public void onLeftClick() {
        this.finish();
    }

    @Override
    public void onRightClick() {

    }
}
