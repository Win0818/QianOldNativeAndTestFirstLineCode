package com.qianft.m.qian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianft.m.qian.R;
import com.qianft.m.qian.view.BaseViewHolder;

/**
 * Created by Administrator on 2017/1/20.
 */

public class AccountGridAdapter extends BaseAdapter {
    private Context mContext;
    public String[] img_text = { "体验标", "天天赚", "债权宝", "累计收益", "资金管理", "账户安全",
            "账户信息", "银行卡", "我的红包", "我是理财师","理财顾问","我的加息券", "车险投保", "投保记录"};
    public int[] imgs = { R.mipmap.my_ico1, R.mipmap.my_ico2,
            R.mipmap.my_ico4, R.mipmap.my_ico5,
            R.mipmap.my_ico6, R.mipmap.my_ico7,
            R.mipmap.my_ico8, R.mipmap.my_ico9, R.mipmap.my_ico10,
            R.mipmap.my_ico11, R.mipmap.my_ico12, R.mipmap.my_ico15, R.mipmap.safecar,
            R.mipmap.safelist};
    public AccountGridAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return img_text.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.account_grid_item, parent, false);
        }
        TextView tv = BaseViewHolder.get(convertView, R.id.tv_item);
        ImageView iv = BaseViewHolder.get(convertView, R.id.iv_item);
        iv.setBackgroundResource(imgs[position]);
        tv.setText(img_text[position]);
        return convertView;
    }
}
