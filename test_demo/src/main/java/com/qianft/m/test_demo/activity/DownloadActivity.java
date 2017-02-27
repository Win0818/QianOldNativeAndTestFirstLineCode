package com.qianft.m.test_demo.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qianft.m.test_demo.R;
import com.qianft.m.test_demo.service.DownloadService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DownloadActivity extends AppCompatActivity implements View.OnClickListener{

   // @BindView(R.id.start_download)
    Button startDownload;
   // @BindView(R.id.pause_download)
    Button pauseDownload;
   // @BindView(R.id.canceled_download)
    Button canceledDownload;
    private DownloadService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (DownloadService.DownloadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        //ButterKnife.bind(this);
        startDownload = (Button) findViewById(R.id.start_download);
        startDownload.setOnClickListener(this);
        pauseDownload = (Button) findViewById(R.id.pause_download);
        pauseDownload.setOnClickListener(this);
        canceledDownload = (Button) findViewById(R.id.canceled_download);
        canceledDownload.setOnClickListener(this);

        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
        bindService(intent, connection, BIND_AUTO_CREATE);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }


    }

    /*public void StartDownload(View view) {
        if (downloadBinder == null) {
            return;
        }
        downloadBinder.startDownload("http://m.qianft.com/app/GetAppAPK");
    }

    public void PausedDownload(View view) {
        if (downloadBinder == null) {
            return;
        }
        downloadBinder.pauseDownload();
    }

    public void CanceledDownload(View view) {
        if (downloadBinder == null) {
            return;
        }
        downloadBinder.canceledDownload();
    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    //@OnClick({R.id.start_download, R.id.pause_download, R.id.canceled_download})
    @Override
    public void onClick(View view) {
        if (downloadBinder == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.start_download:
                Log.d("DownloadActivity", "start_download.........");
               // downloadBinder.startDownload("https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe");
                downloadBinder.startDownload("http://m.qianft.com/App/GetAppApk");
                break;
            case R.id.pause_download:
                downloadBinder.pauseDownload();
                break;
            case R.id.canceled_download:
                downloadBinder.cancelDownload();
                break;
        }
    }
}
