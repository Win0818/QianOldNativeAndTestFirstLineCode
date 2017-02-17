package com.qianft.m.qian.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qianft.m.qian.R;

/**
 * Created by Administrator on 2016/12/29.
 */

public class TopBar extends RelativeLayout{

    private Button mLeftButton, mRightButton;
    private TextView mTitleView;
    private LayoutParams mLeftParams, mTitleParams, mRightParams;

    //左按钮的属性值
    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;
    //右按钮的属性值
    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;
    private float mRightTextSize;
    //标题的属性值
    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;


    private topBarClickListenter mListener;
    public TopBar(Context context) {
        super(context);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(0xFFFFFFFF);
        TypedArray ta  = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);

        mLeftText = ta.getString(R.styleable.TopBar_leftText);

        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = ta.getString(R.styleable.TopBar_rightText);
        mRightTextSize = ta.getDimension(
                R.styleable.TopBar_rightTextSize, 10);

        mTitleTextSize = ta.getDimension(
                R.styleable.TopBar_titleTextSize, 10);
        mTitleTextColor = ta.getColor(
                R.styleable.TopBar_titleTextColor, 0);
        mTitle = ta.getString(R.styleable.TopBar_title);

        //获取完TypedArray的值以后，一般要调用
        //recycle方法来避免重新创建的时候的错误
        ta.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        //为创建的组件元素赋值
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        //mLeftButton.setLayoutParams(LayoutParams.WRAP_CONTENT);
        mLeftButton.setText(mLeftText);

        mRightButton.setBackground(mRightBackground);
        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setText(mRightText);
        mRightButton.setTextSize(mRightTextSize);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);
        //为组件元素设置相应的布局元素
        mLeftParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParams);

        //按钮点击事件
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onRightClick();
            }
        });

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onLeftClick();
            }
        });

    }

    public void setOnTopbarClickListner(topBarClickListenter listner) {
        this.mListener = listner;
    }

    public void setButtonVisable(int id, boolean flag) {
        if (flag) {
            if (id == 0) {
                mLeftButton.setVisibility(View.VISIBLE);
            } else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        } else {
            if (id == 0) {
                mLeftButton.setVisibility(View.GONE);
            } else {
                mRightButton.setVisibility(View.GONE);
            }
        }
    }

    public interface topBarClickListenter {
        public void onLeftClick();
        public void onRightClick();
    }
}
