package com.shangliu.china.android.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.shangliu.china.android.model.ViewPageInfo;
import com.shangliu.china.android.ui.widget.PagerSlidingTabStrip;

import java.util.ArrayList;


/**
 * Created by bingley on 2016/4/18.
 */
public class ViewPageFragmentAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private final PagerSlidingTabStrip mPagerSlidingTabStrip;    // TODO 如果不加final会是上面样子？
    private final ViewPager mViewPager;
    private final ArrayList<ViewPageInfo> mTabs = new ArrayList<ViewPageInfo>();

    public ViewPageFragmentAdapter(FragmentManager fm, PagerSlidingTabStrip pageStrip, ViewPager pager) {
        super(fm);
        mContext = pager.getContext();
        this.mPagerSlidingTabStrip = pageStrip;
        this.mViewPager = pager;
        mViewPager.setAdapter(this);
        mPagerSlidingTabStrip.setViewPager(mViewPager);
    }

    @Override
    public Fragment getItem(int position) {
        ViewPageInfo info = mTabs.get(position);
        return Fragment.instantiate(mContext, info.clss.getName(), info.args);
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }
}
