package com.qianft.m.test_demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.qianft.m.test_demo.HttpCallbackListener;
import com.qianft.m.test_demo.utils.HttpUtils;
import com.qianft.m.test_demo.utils.JsonUtils;
import com.qianft.m.test_demo.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkTestActivity extends AppCompatActivity {

    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_test);
        text = (TextView) findViewById(R.id.text_response);
    }

    public void httpUrlConnectionBtn(View view ) {
        //testhttpURLConnection("https://www.baidu.com/");
        //testHttpWithOkHttp();
        sendRequest();
    }

    public void MyHttpMethod(View view ) {
        //testhttpURLConnection("https://www.baidu.com/");
        HttpUtils.httpGet("http://10.0.2.2/get_data.json", new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Log.d("Wing", "responseData: " + response);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
    public void sendRequest() {
        HttpUtils.sendOkHttpRequest("http://10.0.2.2/get_data.json", new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                Log.d("Wing", "responseData: " + responseData);
            }
        });
    }

    public void testhttpURLConnection(final String urlString) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader reader = null;
                HttpURLConnection connection = null;
                StringBuilder response;
                try {
                    URL url = new URL(urlString);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream inputStream = connection.getInputStream();
                    //对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    showResponse(response.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(response);
            }
        });
    }

    public void testHttpWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        //.url("http://10.0.2.2/get_data.xml")
                        .url("http://10.0.2.2/get_data.json")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Log.d("Wing", "responseData: " + responseData);
                    //showResponse(responseData);
                    //Log.d("Wing", "responseData: " + responseData);
                    //HttpUtils.parseXMLWithPull(responseData);
                    //HttpUtils.parseXMLWithSAX(responseData);
                    JsonUtils.parseJSONWithGSON(responseData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
