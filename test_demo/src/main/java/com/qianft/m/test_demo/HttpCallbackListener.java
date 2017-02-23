package com.qianft.m.test_demo;

/**
 * Created by Administrator on 2017/2/21.
 */

public interface HttpCallbackListener {
     void onFinish(String response);
     void onError(Exception e);

}
