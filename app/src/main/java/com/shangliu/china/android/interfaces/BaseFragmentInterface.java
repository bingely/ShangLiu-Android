package com.shangliu.china.android.interfaces;

import android.view.View;


/**
 * 基类fragment实现接口
 *
 */
public interface BaseFragmentInterface {
	
	public void initView(View view);   // 比BaseViewInterface多了这个参数
	
	public void initData();
}
