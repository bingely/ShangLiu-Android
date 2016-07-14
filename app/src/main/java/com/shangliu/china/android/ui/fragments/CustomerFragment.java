package com.shangliu.china.android.ui.fragments;


import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.shangliu.china.android.R;
import com.shangliu.china.android.adapter.CustomerListAdapter;
import com.shangliu.china.android.api.SeacustApi;
import com.shangliu.china.android.broadcast.MybroadcastReceiver;
import com.shangliu.china.android.model.Customer;
import com.shangliu.china.android.ui.base.BaseFragment;
import com.shangliu.china.android.util.NetUtil;
import com.shangliu.china.android.util.UIUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.kymjs.rxvolley.client.HttpCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerFragment extends BaseFragment implements AbsListView.OnScrollListener, MybroadcastReceiver.EvenHandler {    // 要使用v4包下的Fragment

    @Bind(R.id.lv)
    ListView lv;
    @Bind(R.id.tv_middle)
    TextView tv_middle;
    @Bind(R.id.net_status_bar_top)
    View mNetErrorView;       // 网络状态
    @Bind(R.id.swipe_refresh_widget)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private List<Customer> mCustomerList;
    private CustomerListAdapter mAdapter;


    private int mCurrentIndex = 1;
    private int mPageCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewRoot = inflater.inflate(R.layout.fragment_customer, container, false);
        return viewRoot;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }


    // TODO 分页加载操作逻辑


    public void initData() {
        tv_middle.setText("我的客户");
        tv_middle.setVisibility(View.VISIBLE);
        mCustomerList = new ArrayList<Customer>();
        mAdapter = new CustomerListAdapter(getActivity(), mCustomerList);
        lv.setAdapter(mAdapter);
        // 请求数据(如果有网络，加载网络，否则加载数据库中的数据）
        requestCurrentMemberList();
    }

    private void requestCurrentMemberList() {
        // 请求数据
        // json解析
        HttpCallback custmerHandler = new HttpCallback() {
            @Override
            public void onSuccess(Map<String, String> headers, byte[] t) {
                super.onSuccess(headers, t);
                JsonParser parser = new JsonParser();
                JsonArray jsonArrayStr = parser.parse(new String(t)).getAsJsonArray();
                Gson gson = new Gson();
                List<Customer> list = gson.fromJson(jsonArrayStr, new TypeToken<List<Customer>>() {
                }.getType());
                mCustomerList.addAll(list);
                mAdapter.setList(mCustomerList);      // 记得刷新adapter
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int errorNo, String strMsg) {
                super.onFailure(errorNo, strMsg);
            }
        };
        SeacustApi.getCustmerData(custmerHandler);

    }

    @OnClick(R.id.net_status_bar_top)
    public void net_status_bar_top() {
        //判断手机系统的版本  即API大于10 就是3.0或以上版本
        Intent intent;
        if (android.os.Build.VERSION.SDK_INT > 10) {
            intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
        } else {
            intent = new Intent();
            ComponentName component = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
            intent.setComponent(component);
            intent.setAction("android.intent.action.VIEW");
        }

        getActivity().startActivity(intent);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // UIUtils.Toast("正在加载中……",false);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //UIUtils.Toast("正在加载中……",false);
        UIUtils.Toast("正在加载中……");
    }

    @Override
    public void onNetChange() {
        if (NetUtil.getNetworkState(getActivity()) == NetUtil.NETWORN_NONE) {
            mNetErrorView.setVisibility(View.VISIBLE);
        } else {
            mNetErrorView.setVisibility(View.GONE);

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MybroadcastReceiver.mEvenHandlers.add(this);
        if (NetUtil.getNetworkState(getActivity()) == NetUtil.NETWORN_NONE)
            mNetErrorView.setVisibility(View.VISIBLE);
        else
            mNetErrorView.setVisibility(View.GONE);
    }

    @Override
    public void onPause() {
        super.onPause();
        MybroadcastReceiver.mEvenHandlers.remove(this);
    }

}
