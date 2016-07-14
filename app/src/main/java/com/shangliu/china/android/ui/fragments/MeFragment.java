package com.shangliu.china.android.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shangliu.china.android.R;
import com.shangliu.china.android.ui.activity.LoginActivity;
import com.shangliu.china.android.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A fragment with a Google +1 button.
 */
public class MeFragment extends BaseFragment {
    @Bind(R.id.tv_middle)
    TextView tv_middle;
    @Bind(R.id.login_out)
    TextView mLoginOut;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewRoot = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, viewRoot);
        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_middle.setText("我");
        tv_middle.setVisibility(View.VISIBLE);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.login_out)
    public void login_out(){
        startActivity(new Intent(getActivity(), LoginActivity.class));
        getActivity().finish();
    }
}
