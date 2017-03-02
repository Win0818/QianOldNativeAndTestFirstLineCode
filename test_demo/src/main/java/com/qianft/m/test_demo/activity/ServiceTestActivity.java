package com.qianft.m.test_demo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.qianft.m.test_demo.service.MyService;
import com.qianft.m.test_demo.R;

public class ServiceTestActivity extends AppCompatActivity {

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
    }

    public void startService(View view) {
        startService(new Intent(this, MyService.class));
    }
    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }
    public void bindService(View view) {
        bindService(new Intent(this, MyService.class), connection, BIND_AUTO_CREATE);
    }
    public void unbindService(View view) {
        unbindService(connection);
    }
}
