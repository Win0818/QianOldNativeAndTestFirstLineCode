package com.qianft.m.qian.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qianft.m.qian.R;
import com.qianft.m.qian.view.TopBar;

public class AccumulatedIncomeActivity extends BaseActivity implements TopBar.topBarClickListenter{

    private TopBar mAccumulatedIncomeTopBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accumulated_income);
        initView();
    }

    private void initView() {
        mAccumulatedIncomeTopBar = (TopBar) findViewById(R.id.accumulated_income_topbar);
        mAccumulatedIncomeTopBar.setOnTopbarClickListner(this);
    }

    @Override
    public void onLeftClick() {
        this.finish();
    }

    @Override
    public void onRightClick() {

    }
}
