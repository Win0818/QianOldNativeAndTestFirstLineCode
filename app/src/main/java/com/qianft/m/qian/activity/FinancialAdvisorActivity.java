package com.qianft.m.qian.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.qianft.m.qian.R;
import com.qianft.m.qian.view.TopBar;

public class FinancialAdvisorActivity extends BaseActivity implements TopBar.topBarClickListenter, View.OnClickListener{

    private TopBar mFinancialAdvisorTopBar;
    private TextView mTelPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_advisor);
        initView();
    }

    /**
     * 初始化界面
     */
    private void initView() {
        mFinancialAdvisorTopBar = (TopBar) findViewById(R.id.financial_advisor_topbar);
        mFinancialAdvisorTopBar.setOnTopbarClickListner(this);
        mTelPhoneNumber = (TextView) findViewById(R.id.tel_number_tv);
        mTelPhoneNumber.setOnClickListener(this);
    }


    @Override
    public void onLeftClick() {
        this.finish();
    }

    @Override
    public void onRightClick() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tel_number_tv:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 0755-8663 9893"));
                startActivity(intent);
                break;
        }
    }
}
