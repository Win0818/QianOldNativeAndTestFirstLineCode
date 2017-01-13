package com.qianft.m.qian.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.qianft.m.qian.R;
import com.qianft.m.qian.callback.ProgressCallback;
import com.qianft.m.qian.common.Constant;
import com.qianft.m.qian.dialog.GlobalProgressDialog;
import com.qianft.m.qian.utils.LogUtil;
import com.qianft.m.qian.utils.Util;

public class MyWebView extends RelativeLayout {

	private GlobalProgressDialog mGlobalProgressDialog;
	private Context mContext;
	private WebView mWebView;
	private String url;
	private ImageButton mRefreshBtn;
	private LongClickCallBack mLongClickCallBack;
	private LinearLayout mNoNetworkLinearLayout;

	public MyWebView(Context context) {
		super(context);
		this.mContext = context;
		initView();
		initWebView();
	}

	public MyWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		initView();
		initWebView();
	}

	public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;
		initView();
		initWebView();
	}
	//初始化WebView界面
	private void initView()  {
		View view = LayoutInflater.from(mContext).inflate(R.layout.layout_mywebview, this);
		mWebView = (WebView) view.findViewById(R.id.mywebview);
		mNoNetworkLinearLayout = (LinearLayout) view.findViewById(R.id.no_network_webview);
		mRefreshBtn = (ImageButton) view.findViewById(R.id.refresh_btn_webview);
		if (!Util.isNetWorkConnected(mContext)) {
			mNoNetworkLinearLayout.setVisibility(View.VISIBLE);
		}
		mRefreshBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!Util.isNetWorkConnected(mContext)) {
					mNoNetworkLinearLayout.setVisibility(View.VISIBLE);
				} else {
					mNoNetworkLinearLayout.setVisibility(View.INVISIBLE);
					mWebView.loadUrl(Constant.Address);
				}
			}
		});
		mWebView.setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// 长按事件监听（注意：需要实现LongClickCallBack接口并传入对象）
				final WebView.HitTestResult htr = mWebView.getHitTestResult();//获取所点击的内容
				Log.d("Wing", "SRC_IMAGE_ANCHOR_TYPE onLongClickCallBack:   " + htr.getType());
				if (htr.getType() == WebView.HitTestResult.IMAGE_TYPE) {//判断被点击的类型为图片
					Log.d("Wing", "SRC_IMAGE_ANCHOR_TYPE onLongClickCallBack");
					mLongClickCallBack.onLongClickCallBack(htr.getExtra());
				}
				return false;
			}
		});
	}
	/**
	 * 设置长按监听
	 * @param longClickCallBack
     */
	public void setLongClickCallBack (LongClickCallBack longClickCallBack) {
		this.mLongClickCallBack = longClickCallBack;
	}

	public String getUrl() {
		return mWebView.getUrl();
	}

	public void setUrl(String url) {
		this.url = url;
	}

	//设置URL
	public void loadUrl(String url) {
		LogUtil.d("Wing", "MyWebView ------ loadUrl");
		mWebView.loadUrl(url);
	}

	@SuppressLint("JavascriptInterface")
	public void addJavascriptInterface(Object object, String name) {
		mWebView.addJavascriptInterface(object, name);
	}

	//生成WebViewClient
	protected MyWebViewClient generateMyWebViewClient() {
		MyWebViewClient  myWebViewClient = null;
		if (mWebView != null) {
			LogUtil.d("Wing", "generateMyWebViewClient ------>>>>>>>");
			myWebViewClient = new MyWebViewClient(mWebView, new MyWebViewProgress(), mContext);
		}
		return myWebViewClient;
	}

	//加载进度条监听
	private class MyWebViewProgress implements ProgressCallback {
		@Override
		public void onLoading() {
			startProgressDialog();
			LogUtil.d("Wing", "Progress onLoading");
		}
		@Override
		public void onLoaded() {
			stopProgressDialog();
			LogUtil.d("Wing", "Progress onLoaded thread  " + Thread.currentThread().getName());
		}
		@Override
		public void onError() {
			if (mNoNetworkLinearLayout != null) {
				mNoNetworkLinearLayout.setVisibility(View.VISIBLE);
			}
		}
	}

	//初始化webview
	private void initWebView() {
		WebSettings webSettings = mWebView.getSettings();
		//开启JavaScript
		webSettings.setJavaScriptEnabled(true);
		//设置字符编码
		webSettings.setDefaultTextEncodingName("utf-8");
		//调整到适合Webview大小
		webSettings.setLoadWithOverviewMode(true);
		// 设置可以访问文件
		//webSettings.setAllowFileAccess(true);
		//Sets whether the WebView should enable support for the "viewport" HTML
		webSettings.setUseWideViewPort(true);
		//webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
		//图片资源后加载
		//webSettings.setBlockNetworkImage(true);
		webSettings.setRenderPriority(RenderPriority.HIGH);
		//不保存密码
		webSettings.setSavePassword(false);
		//设置 缓存模式
		webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
		//开启 DOM storage API 功能
		webSettings.setDomStorageEnabled(true);
		if(Build.VERSION.SDK_INT >= 19) {
			webSettings.setLoadsImagesAutomatically(true);
		} else {
			webSettings.setLoadsImagesAutomatically(false);
		}
		mWebView.setWebViewClient(generateMyWebViewClient());
		mWebView.setWebChromeClient(new WebChromeClient(){
		});
	}

	/**
	 * 如果可以返回
	 * @return
     */
	public boolean canBack() {
		if (mWebView.canGoBack()) {
			//mWebView.loadUrl("javascript:window.history.back();");
			mWebView.goBack();
			return false;
		}
		return true;
	}

	//开始网页加载进度条
	private void startProgressDialog() {
		if (mGlobalProgressDialog == null) {
			mGlobalProgressDialog = GlobalProgressDialog.createDialog(mContext);
		}
		mGlobalProgressDialog.show();
	}
	// 停止网页加载进度条
	private void stopProgressDialog() {
		if (mGlobalProgressDialog != null) {
			if (mGlobalProgressDialog.isShowing()) {
				mGlobalProgressDialog.dismiss();
			}
			mGlobalProgressDialog = null;
		}
	}
	/**
	 * 长按事件回调接口，传递图片地址
	 */
	public interface LongClickCallBack{
		/**用于传递图片地址*/
		void onLongClickCallBack(String imgUrl);
	}
}
