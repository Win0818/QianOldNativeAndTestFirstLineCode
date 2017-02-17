package com.qianft.m.qian.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qianft.m.qian.R;
import com.qianft.m.qian.fragment.AccountFragment;
import com.qianft.m.qian.fragment.HomeFragment;
import com.qianft.m.qian.fragment.MoneyFragment;
import com.qianft.m.qian.fragment.MoreFragment;
import com.qianft.m.qian.utils.FragmentSwitchTool;

public class MainActivity extends BaseActivity implements HomeFragment.OnFragmentInteractionListener,
        MoneyFragment.OnFragmentInteractionListener,AccountFragment.OnFragmentInteractionListener,
        MoreFragment.OnFragmentInteractionListener{

    private FragmentSwitchTool tool;
    private LinearLayout llHome, llMoney, llAccount, llMore;
    private ImageView ivHome, ivMoney, ivAccount, ivMore;
    private TextView tvHome, tvMoney, tvAccount, tvMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        tool = new FragmentSwitchTool(getSupportFragmentManager(), R.id.flContainer);
        tool.setClickableViews(llHome, llMoney, llAccount, llMore);
        tool.addSelectedViews(new View[]{ivHome, tvHome}).addSelectedViews(new View[]{ivMoney, tvMoney})
                .addSelectedViews(new View[]{ivAccount, tvAccount}).addSelectedViews(new View[]{ivMore, tvMore});
        tool.setFragments(HomeFragment.class, MoneyFragment.class, AccountFragment.class, MoreFragment.class);
        tool.changeTag(llHome);
    }
    private void initView() {
        //mHomeMyWebView.setUrl("http://m.qianft.com/");
        llHome = (LinearLayout) findViewById(R.id.llHome);
        llMoney = (LinearLayout) findViewById(R.id.llMoney);
        llAccount = (LinearLayout) findViewById(R.id.llAccount);
        llMore = (LinearLayout) findViewById(R.id.llMore);

        ivHome = (ImageView) findViewById(R.id.ivHome);
        ivMoney = (ImageView) findViewById(R.id.ivMoney);
        ivAccount = (ImageView) findViewById(R.id.ivAccount);
        ivMore = (ImageView) findViewById(R.id.ivMore);

        tvHome = (TextView) findViewById(R.id.tvHome);
        tvMoney = (TextView) findViewById(R.id.tvMoney);
        tvAccount = (TextView) findViewById(R.id.tvAccount);
        tvMore = (TextView) findViewById(R.id.tvMore);
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}