package com.shangliu.china.android.ui.base;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shangliu.china.android.R;
import com.shangliu.china.android.adapter.ViewPageFragmentAdapter;
import com.shangliu.china.android.ui.widget.EmptyLayout;
import com.shangliu.china.android.ui.widget.PagerSlidingTabStrip;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by bingley on 2016/4/18.
 */
public class BaseViewPagerFragment extends BaseFragment {

    @Bind(R.id.pager_tabstrip)
    PagerSlidingTabStrip mPagerTabstrip;
    @Bind(R.id.pager)
    ViewPager mPager;
    @Bind(R.id.error_layout)
    EmptyLayout mErrorLayout;
    private ViewPageFragmentAdapter mTabsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_viewpage_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabsAdapter = new ViewPageFragmentAdapter(getChildFragmentManager(),
                mPagerTabstrip, mPager);
        setScreenPageLimit();         // 设置viewpager左右两边保留的页面的个数（就是左右两边会预加载的页面）
        onSetupTabAdapter(mTabsAdapter);  // 通过ViewPagerFrangmentAdapter设置Tab选项及内容

    }

    protected void onSetupTabAdapter(ViewPageFragmentAdapter tabsAdapter) {
    }

    protected void setScreenPageLimit() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
