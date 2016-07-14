package com.shangliu.china.android.ui.base;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/4/13.
 */
// 这里的T代表一个数据集合
public abstract class BaseHolder<T> {
    private  View rootView;

    private T mData;

    public BaseHolder() {
        this.rootView = initView();
        this.rootView.setTag(this);
        ButterKnife.bind(BaseHolder.this,rootView);
    }

    public View getRootView() {
        return rootView;
    }

    public void setData(T data) {
        mData = data;
        refreshView();
    }

    public T getData() {
        return mData;
    }

    protected abstract void refreshView();  // 加载布局
    public abstract View initView();       // 得到集合对象（数据源），然后填充数据
}
