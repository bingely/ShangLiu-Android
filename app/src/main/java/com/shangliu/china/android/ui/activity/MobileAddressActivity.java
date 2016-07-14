package com.shangliu.china.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shangliu.china.android.R;
import com.shangliu.china.android.ui.base.BaseActivity;
import com.shangliu.china.android.ui.widget.SideBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MobileAddressActivity extends BaseActivity {
    @Bind(R.id.tv_left)
    TextView mTvLeft;
    @Bind(R.id.tv_middle)
    TextView mTvMiddle;
    @Bind(R.id.tv_right)
    TextView mTvRight;
    @Bind(R.id.search_icon)
    ImageView mSearchIcon;
    @Bind(R.id.header_search_layout)
    RelativeLayout mHeaderSearchLayout;
    @Bind(R.id.lv_member)
    ListView mLvMember;
    @Bind(R.id.alphat_layout)
    SideBar mAlphatLayout;
    @Bind(R.id.tv_alphabet_ui_tableview)
    TextView mTvAlphabetUiTableview;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mobile_address;
    }

    @Override
    public void initView() {
        mTvMiddle.setText("手机通讯录");
        mTvMiddle.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
