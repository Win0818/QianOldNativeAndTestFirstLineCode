package com.qianft.m.qian.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.qianft.m.qian.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/20.
 */

public class MoneyAdapter extends ArrayAdapter {
    private Context context;
    private List mDataList;
    private LayoutInflater mInflater;

    public MoneyAdapter(Context context, int resource, ArrayList<String> datalist) {
        super(context, resource);
        this.context = context;
        this.mDataList = datalist;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public int getPosition(Object item) {
        return super.getPosition(item);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.money_item, null);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    public class ViewHolder {
        public TextView mTextView;
    }
}
