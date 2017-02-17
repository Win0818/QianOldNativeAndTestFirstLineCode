package com.qianft.m.qian.activity;

import android.os.Bundle;

import com.qianft.m.qian.R;
import com.qianft.m.qian.view.TopBar;

public class FinancialPlannerActivity extends BaseActivity implements TopBar.topBarClickListenter{

    private TopBar mFinancialTopBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_planner);
        mFinancialTopBar = (TopBar) findViewById(R.id.financial_planner_topbar);
        mFinancialTopBar.setOnTopbarClickListner(this);

    }

    @Override
    public void onLeftClick() {
        this.finish();
    }

    @Override
    public void onRightClick() {

    }
}
