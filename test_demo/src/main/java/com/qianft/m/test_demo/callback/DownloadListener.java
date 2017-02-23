package com.qianft.m.test_demo.callback;

/**
 * Created by Administrator on 2017/2/22.
 */

public interface DownloadListener {

    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();
}
