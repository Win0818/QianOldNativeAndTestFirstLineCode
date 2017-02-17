package com.qianft.m.qian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.qianft.m.qian.R;
import com.qianft.m.qian.view.TopBar;

/**
 * Created by Administrator on 2017/2/4.
 */

public class FundMgmtActivity extends BaseActivity implements TopBar.topBarClickListenter, View.OnClickListener{

    private TopBar mFundMgmtTopBar;
    private TextView mFundRecordTv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fundmgmt);

        initView();

    }

    /**
     * 初始化界面
     */
    private void initView() {
        mFundMgmtTopBar = (TopBar) findViewById(R.id.fund_mgmt_topbar);
        mFundMgmtTopBar.setOnTopbarClickListner(this);
        mFundRecordTv = (TextView) findViewById(R.id.fund_record_tv);
        mFundRecordTv.setOnClickListener(this);

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
            case R.id.fund_record_tv:
                    startActivity(new Intent(this, FundRecordActivity.class));
                break;
            default:

        }
    }
}
