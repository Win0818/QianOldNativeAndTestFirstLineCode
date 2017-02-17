package com.qianft.m.qian.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qianft.m.qian.R;
import com.qianft.m.qian.view.TopBar;

/**
 * Created by Administrator on 2017/2/4.
 */

public class AccountSecurityActivity extends BaseActivity implements TopBar.topBarClickListenter{

    private TopBar mSecureTopBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsecurity);
        mSecureTopBar = (TopBar) findViewById(R.id.account_secure_topbar);
        mSecureTopBar.setOnTopbarClickListner(this);
    }

    @Override
    public void onLeftClick() {
        this.finish();
    }

    @Override
    public void onRightClick() {

    }
}
