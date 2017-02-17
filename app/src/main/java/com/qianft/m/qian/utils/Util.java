package com.qianft.m.qian.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;


public class Util {
	private String TAG = "Wing";
	public static String WECHAT_CODE = null;
	/*private IWXAPI wxApi;*/
	public static String USER_ID = null;
	public static String COOKIES = null;
	public static String SERVER_URL = null;
	public static String Auth_Success_Url = null;
	
	/**
	 * Bitmap 到字节数组
	 * @param bmp
	 * @param needRecycle
	 * @return
	 */
	public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		bmp.compress(CompressFormat.PNG, 100, output);
		if (needRecycle) {
			bmp.recycle();
		}
		
		byte[] result = output.toByteArray();
		try {
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 下载图片到本地
	 * @param imageUrl
	 * @param savePath
	 * @param picFileName
	 */
	public static void downLoadPicture(final String imageUrl, final String savePath, final String picFileName) {
		
		new Thread() {
			@Override
			public void run() {
				if (Environment.getExternalStorageState().equals(
						Environment.MEDIA_MOUNTED)) {
					URL url ;
					try {
						url = new URL(imageUrl);
						Log.d("Wing", "=------picture---URL---"
								+ imageUrl);
						String rootPath = Environment.getExternalStorageDirectory().toString();
						File pathDir = new File(rootPath + savePath);
						if (!pathDir.exists()) {
							pathDir.mkdirs();
						}
						File outputImage = new File(pathDir,
								picFileName);
						try {
							if (outputImage.exists()) {
								outputImage.delete();
							}
							outputImage.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
						HttpURLConnection conn = (HttpURLConnection) url
								.openConnection();
						conn.setConnectTimeout(5000);
						// 获取到文件的大小
						InputStream is = conn.getInputStream();
						
						/*File updatefile = new File(
						Environment.getExternalStorageDirectory()+ "/" + savePath +"/"+ picFileName + ".jpg");
						if (updatefile.exists()) {
							updatefile.delete();
							updatefile.createNewFile();
						} else {
							updatefile.createNewFile();
						}*/
						FileOutputStream fos = new FileOutputStream(outputImage);

						BufferedInputStream bis = new BufferedInputStream(is);
						byte[] buffer = new byte[1024];
						int len;
						while ((len = bis.read(buffer)) != -1 ) {
							fos.write(buffer, 0, len);
						}
						fos.close();
						bis.close();
						is.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	/**
	 * 获取错误的信息
	 * @param arg1
	 * @return
	 */
	public static String getErrorInfo(Throwable arg1) {
		Writer writer = new StringWriter();
		PrintWriter pw = new PrintWriter(writer);
		arg1.printStackTrace(pw);
		Throwable cause = arg1.getCause();
		while (cause != null) {
			cause.printStackTrace(pw);
			cause = cause.getCause();
		}
		pw.close();
		String error= writer.toString();
		return error;
	}

	/**
	 * 检测网络是否可用
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetWorkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}
	
	/** 
	 * make true current connect service is wifi 
	 * @param context
	 * @return 
	 */  
	public static boolean isWifi(Context context) {
	    ConnectivityManager connectivityManager = (ConnectivityManager) context
	            .getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
	    if (activeNetInfo != null  
	            && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
	        return true;  
	    }  
	    return false;  
	}

	public static void startActivity(Context context, Class<?> cls) {
		try {
			Intent intent = new Intent(context, cls);
			context.startActivity(intent);
		} catch (Exception e) {
			LogUtil.d("Wing", "Activity Not Found!");
		}
	}
}
