package com.qianft.m.qian.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qianft.m.qian.R;
import com.qianft.m.qian.view.MyWebView;

/**
 * Created by Administrator on 2017/2/3.
 */

public class WebActivity extends BaseActivity {

    private MyWebView mMyWebView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mMyWebView = (MyWebView) findViewById(R.id.mywebview);

    }
}
