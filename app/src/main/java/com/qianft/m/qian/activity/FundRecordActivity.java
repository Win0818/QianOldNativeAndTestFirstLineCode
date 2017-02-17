package com.qianft.m.qian.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qianft.m.qian.R;

public class FundRecordActivity extends BaseActivity {

    private RecyclerView mFundRecordRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_record);
        initView();
    }

    /**
     *初始化
     */
    private void initView() {
        mFundRecordRecyclerView = (RecyclerView) findViewById(R.id.fund_record_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mFundRecordRecyclerView.setLayoutManager(layoutManager);
    }
}
