package com.qianft.m.qian.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qianft.m.qian.R;
import com.qianft.m.qian.view.TopBar;

/**
 * Created by Administrator on 2017/2/6.
 */

public class AccountInfoActivity extends BaseActivity implements TopBar.topBarClickListenter{

    private TopBar mAccountInfoTopBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        initView();
    }

    /**
     * 初始化界面
     */
    private void initView() {
        mAccountInfoTopBar = (TopBar) findViewById(R.id.account_imfo_topbar);
        mAccountInfoTopBar.setOnTopbarClickListner(this);
    }

    @Override
    public void onLeftClick() {
        this.finish();
    }

    @Override
    public void onRightClick() {

    }
}
