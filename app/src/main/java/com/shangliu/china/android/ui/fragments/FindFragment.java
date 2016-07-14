package com.shangliu.china.android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shangliu.china.android.R;
import com.shangliu.china.android.ui.base.BaseFragment;
import com.shangliu.china.android.ui.widget.ComItemLayoutView;
import com.shangliu.china.android.util.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FindFragment extends BaseFragment {

    @Bind(R.id.tv_left)
    TextView mTvLeft;
    @Bind(R.id.tv_middle)
    TextView mTvMiddle;
    @Bind(R.id.tv_right)
    TextView mTvRight;
    @Bind(R.id.resource_pool)
    ComItemLayoutView mResourcePool;
    @Bind(R.id.me_follow)
    ComItemLayoutView mMeFollow;
    @Bind(R.id.recommend_clients)
    ComItemLayoutView mRecommendClients;
    @Bind(R.id.share_clients)
    ComItemLayoutView mShareClients;
    @Bind(R.id.card_scaning)
    ComItemLayoutView mCardScaning;
    @Bind(R.id.mobile_list)
    ComItemLayoutView mMobileList;
    @Bind(R.id.integral_mall)
    ComItemLayoutView mIntegralMall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewRoot = inflater.inflate(R.layout.fragment_find, container, false);
        ButterKnife.bind(this, viewRoot);
        return viewRoot;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvMiddle.setText("发现");
        mTvMiddle.setVisibility(View.VISIBLE);
        initData();
    }

    @OnClick(R.id.resource_pool)
    public void resource_pool(View view){
        showWaitDialog();
    }

    @OnClick(R.id.mobile_list)
    public void getMobilelistData(View view){
        UIHelper.showMobilelistData(getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
