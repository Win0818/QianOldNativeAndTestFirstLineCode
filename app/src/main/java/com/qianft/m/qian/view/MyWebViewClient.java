package com.qianft.m.qian.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.qianft.m.qian.callback.ProgressCallback;
import com.qianft.m.qian.dialog.GlobalProgressDialog;
import com.qianft.m.qian.utils.LogUtil;
import com.qianft.m.qian.utils.NoAdTool;

public class MyWebViewClient extends WebViewClient {

	private WebView webView;
	private ProgressCallback mProgressCallback;
	private GlobalProgressDialog mGlobalProgressDialog;
	private Context context;
	private static String homeurl = "http://m.qianft.com/";

	public MyWebViewClient (WebView webView, ProgressCallback progressCallback, Context context) {

		this.webView = webView;
		this.context = context;
		this.mProgressCallback = progressCallback;
	}

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		LogUtil.i("Wing", "MyWebViewClient..shouldOverrideUrlLoading..  url=" + url);
		view.loadUrl(url);
		return true;
	}

	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		super.onPageStarted(view, url, favicon);
		if (mProgressCallback != null) {
			mProgressCallback.onLoading();
		}
	}

	@Override
	public void onPageFinished(WebView view, String url) {
		super.onPageFinished(view, url);
		if (mProgressCallback != null) {
			mProgressCallback.onLoaded();
		}
		view.loadUrl("javascript:function setTop(){document.querySelector('#BAIDU_DUP_fp_wrapper').style.display=\"none\";}setTop();");
		view.loadUrl("javascript:window.jsObj.getSource('<head>'+" +
				"document.getElementsByTagName('html')[0].innerHTML+'</head>');");
	}

	@Override
	public void onReceivedError(WebView view, int errorCode,
								String description, String failingUrl) {
		if (view != null) {
			view.stopLoading();
			view.clearView();
		}
		if (mProgressCallback != null) {
			mProgressCallback.onError();
		}
		super.onReceivedError(view, errorCode, description, failingUrl);
		view.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
	}

	@Override
	public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
		url = url.toLowerCase();
		if(!url.contains(homeurl)){
			if (!NoAdTool.hasAd(context, url)) {
				LogUtil.d("Wing", "noAd url:  " + url);
				return super.shouldInterceptRequest(view, url);
			}else{
				LogUtil.d("Wing", "null url:  " + url);
				
				return new WebResourceResponse(null,null,null);
			}
		}else{
			return super.shouldInterceptRequest(view, url);

		}
	}
	@Override
	public void onLoadResource(WebView view, String url) {
		super.onLoadResource(view, url);
	}
}
