package com.qianft.m.test_demo.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qianft.m.test_demo.bean.App;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */

public class JsonUtils {

    public static void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");

                Log.d("Wing", "json id  is " + id);
                Log.d("Wing", "json name  is " + name);
                Log.d("Wing", "json version  is " + version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<App>appList = gson.fromJson(jsonData, new
                TypeToken<List<App>>(){}.getType());
        for (App app : appList) {
            Log.d("Wing", "Gson id  is " + app.getId());
            Log.d("Wing", "Gson name  is " + app.getName());
            Log.d("Wing", "Gson version  is " + app.getVersion());
        }
    }
}
