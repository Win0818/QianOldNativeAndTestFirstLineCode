package com.qianft.m.test_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    public MyBroadcastReceiver() {


    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "My Broadcast Receiver", Toast.LENGTH_SHORT).show();
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
