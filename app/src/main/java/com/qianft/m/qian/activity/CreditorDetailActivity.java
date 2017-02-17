package com.qianft.m.qian.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qianft.m.qian.R;
import com.qianft.m.qian.view.TopBar;

public class CreditorDetailActivity extends AppCompatActivity implements TopBar.topBarClickListenter{

    private TopBar mCreditorDetailTopBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditor_detail);
        mCreditorDetailTopBar = (TopBar) findViewById(R.id.creditor_detail_topbar);
        mCreditorDetailTopBar.setOnTopbarClickListner(this);
    }

    @Override
    public void onLeftClick() {
        this.finish();
    }

    @Override
    public void onRightClick() {

    }
}
