package com.qianft.m.qian;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/12/13.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MICROSECONDS)
                .readTimeout(10000L, TimeUnit.MICROSECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
