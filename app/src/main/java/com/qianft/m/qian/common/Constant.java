package com.qianft.m.qian.common;

public class Constant {
	/**
	 * sharepreference名称
	 */
	public static final String NAVIGATION_SP_NAME = "qianft_sp";
	public static final String WECHAT_LOGIN_SP_NAME = "wechat_login_sp";
	
	public static final String UPDATE_DIALOG = "update_dialog";
	
	/**
	 * 分享朋友圈or好友
	 */
	public static final int SHARE_TO_FREIND = 0;
	public static final int SHARE_TO_FREIND_CIRCLE = 1;
	
	/**
	 * 
	 */
	public static final int RETURN_OPENID_ACCESSTOKEN = 0x00001001;
	public static final int RETURN_NICKNAME_UID = 0x00001002;
	/**
	 * 网页加载进度显示
	 */
	public static final int HTML_LOADING = 0x00001003;
	public static final int HTML_LOADED = 0x00001004;
	
	/**
	 * 版本更新
	 */
	public static final int UPDATE_DIALOG_HANDLER = 0x00001005;
	
	/**
	 * 
	 */
	public static final int NO_NETWORK_HANDLER = 0x00001006;
	/**
	 * 微信分享和登录
	 */
	public static final String APP_ID = "wxdb7f07f403846bc5";
	public static final String APP_SECRET = "bdb178785eb213a0729751fcd76afded";
	
	/**
	 * QQ分享id 和 secret
	 */
	public static final String QQ_APP_ID = "1105582062";
	public static final String QQ_APP_SECRET = "gyr8Wh1NkjKVGsvE";
	
	/**
	 * 微博分享id 和 secret
	 */
	public static final String Weibo_APP_ID = "3396468794";
	public static final String Weibo_APP_SECRET = "";
	
	/**
	 * 
	 */
	public static final String SERVER1 = "http://192.168.0.70:8088/";// 本地服务器
	public static final String SERVER = "http://m.qianft.com/";     //线上服务器
	public static final String URL_IMAGE = SERVER + "App/GetAppImg/0";  //"Assets/Imgs/Home/Welcome.png"; 
	public static final String Address = "http://m.qianft.com/";
	
	public static final String downloadNewApk = SERVER + "app/GetAppVersion/0";  //app版本信息
	
	public static final String mLatestVersionDownload = SERVER + "app/GetAppAPK";
	
	public static final String ERROR_MSG_POST_URL = SERVER + "App/SubmitAppLog";
	//http://m.qianft.com/app/GetAppAPK
	//public static final String
}
