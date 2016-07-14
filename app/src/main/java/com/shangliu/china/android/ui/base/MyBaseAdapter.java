package com.shangliu.china.android.ui.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/4/14.
 */

// T 代表集合中的类型
// 面向Holder编程
public abstract class MyBaseAdapter<T> extends BaseAdapter{

    protected List<T> t;

    public MyBaseAdapter(List<T> t) {
        this.t = t;
    }

    @Override
    public int getCount() {
        return t==null?0:t.size();
    }

    @Override
    public Object getItem(int position) {
        return t.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder baseHolder = null;
        if (convertView == null){
            baseHolder = getHolder();
        }else{
            baseHolder = (BaseHolder) convertView.getTag();
        }
        return baseHolder.getRootView();
    }

    protected abstract BaseHolder getHolder();
}
