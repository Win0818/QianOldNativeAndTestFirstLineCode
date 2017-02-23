package com.qianft.m.test_demo;

import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/2/17.
 */

public class HttpUtils {

    public String testhttpURLConnection(final String urlString) {

        StringBuilder response = null;
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader reader = null;
                StringBuilder response;
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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
                    //showResponse(response.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                }
            }
        }).start();
        return response.toString();
    }

    public static void parseXMLWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParse = factory.newPullParser();
            xmlPullParse.setInput(new StringReader(xmlData));
            int evenType = xmlPullParse.getEventType();
            String id = "";
            String name = "";
            String vession = "";
            while (evenType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParse.getName();
                switch (evenType) {
                    case XmlPullParser.START_TAG: {
                        if ("id".equals(nodeName)) {
                            id = xmlPullParse.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParse.nextText();
                        } else if ("version".equals(nodeName)) {
                            vession = xmlPullParse.nextText();
                        }
                    }
                    break;
                    case XmlPullParser.END_TAG: {
                        if ("app".equals(nodeName)) {
                            Log.d("Wing", "id is " + id);
                            Log.d("Wing", "name is " + name);
                            Log.d("Wing", "version is " + vession);
                        }
                    }
                    break;
                    default:
                        break;
                }
                evenType = xmlPullParse.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader =  factory.newSAXParser().getXMLReader();
            ContentHandler  handler = new ContentHandler();
            xmlReader.setContentHandler(handler);
            //开始解析
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void httpGet(final String address, final HttpCallbackListener httpCallbackListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    InputStream inputStream = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    if (httpCallbackListener != null) {
                        httpCallbackListener.onFinish(builder.toString());
                    }
                } catch (Exception e) {
                   if (httpCallbackListener != null) {
                       httpCallbackListener.onError(e);
                   }
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

    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);

    }
}
