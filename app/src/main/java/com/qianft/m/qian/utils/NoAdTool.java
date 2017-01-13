package com.qianft.m.qian.utils;

import android.content.Context;
import android.content.res.Resources;

import com.qianft.m.qian.R;

/**
 * Created by Administrator on 2017/1/4.
 */

public class NoAdTool {
    public static boolean hasAd(Context context, String url) {
        Resources res = context.getResources();
        String[] adUrls = res.getStringArray(R.array.adBlockUrl);
        for (String adUrl : adUrls) {
            if (url.contains(adUrl)) {
                return true;
            }
        }
        return false;
    }
}
