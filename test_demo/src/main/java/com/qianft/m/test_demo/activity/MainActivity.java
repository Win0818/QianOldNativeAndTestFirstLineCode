package com.qianft.m.test_demo.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.qianft.m.test_demo.bean.Book2;
import com.qianft.m.test_demo.MyDatabaseHelper;
import com.qianft.m.test_demo.R;
import com.qianft.m.test_demo.fragment.SecondFragment;
import com.qianft.m.test_demo.fragment.ThirdFragment;

import org.litepal.tablemanager.Connector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements ThirdFragment.OnFragmentInteractionListener{

    private MyDatabaseHelper dbHelper;
    private ImageView picture;
    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new SecondFragment());
        SecondFragment secondFragment =  (SecondFragment)getSupportFragmentManager().findFragmentById(R.id.right_fragment);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
    }

    public void fragmentButton(View view) {
        replaceFragment(ThirdFragment.newInstance("aaaa", "bbbbb"));
        Intent intent = new Intent("android.intent.action.MY_BROADCAST");
        sendBroadcast(intent);
        save();
    }
    public void CreateDatabase(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "First Code Android2");
        values.put("author", "guo ling");
        values.put("pages", "500");
        values.put("price", "65.00");
        db.insert("Book", null, values);
        values.clear();
        values.put("name", "First Code Android2");
        values.put("author", "guo ling");
        values.put("pages", "500");
        values.put("price", "65.00");
        db.insert("Book", null, values);
    }
    public void CreateDatabase2(View view) {
        Connector.getDatabase();
    }

    public void UpdateDatabase2(View view) {
        Book2 book2 = new Book2();
        book2.setAuthor("aaaaa");
        book2.setId(1);
        book2.setName("bbbbb");
        book2.setPages(600);
        book2.setPrice(20.0);
        book2.save();
        Toast.makeText(this, "insert success!", Toast.LENGTH_SHORT).show();
    }

    public void UpdateDatabase(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("price", "20.00");
        db.update("Book", values, "name = ?", new String[] {"First Code Android2"});
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void save() {
        String data = "Data to save";
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void makeCall(View view) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
               ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.CALL_PHONE}, 1);
        } else {
            call();
        }
    }

    public void SendNotification(View view) {
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("Content Title")
                .setContentText("Content Text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .build();
        notificationManager.notify(1, notification);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                break;
            default:
        }
    }
    private void call() {

    }

    public void openCamera(View view) {
        File outputImage = new File(getExternalCacheDir(), "output_Image.jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            imageUri = FileProvider.getUriForFile(this, "com.qianft.m.test_demo.fileprovider", outputImage);
        } else {
            imageUri = Uri.fromFile(outputImage);
        }

        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, 0);
    }
}
