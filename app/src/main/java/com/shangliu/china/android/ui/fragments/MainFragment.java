package com.shangliu.china.android.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shangliu.china.android.R;
import com.shangliu.china.android.ui.base.BaseFragment;

import butterknife.Bind;

/**
 * A fragment with a Google +1 button.
 */
public class MainFragment extends BaseFragment {
    @Bind(R.id.tv_middle)
    TextView tv_middle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewRoot = inflater.inflate(R.layout.fragment_main, container, false);
        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_middle.setText("首页");
        tv_middle.setVisibility(View.VISIBLE);
        initData();
        //DialogUtils.showWaitDialog();
    }

}
