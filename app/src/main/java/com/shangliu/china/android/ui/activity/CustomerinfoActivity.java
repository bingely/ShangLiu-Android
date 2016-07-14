package com.shangliu.china.android.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shangliu.china.android.R;
import com.shangliu.china.android.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/4/11.
 */
public class CustomerinfoActivity extends BaseActivity {
    @Bind(R.id.iv_left)
    ImageView mIvLeft;
    @Bind(R.id.tv_middle)
    TextView mTvMiddle;
    @Bind(R.id.info_username)
    TextView mInfoUsername;
    @Bind(R.id.info_sex)
    ImageView mInfoSex;
    @Bind(R.id.info_mobile)
    TextView mInfoMobile;
    @Bind(R.id.info_validity_time)
    TextView mInfoValidityTime;
    @Bind(R.id.ll_tab_personal_edit)
    LinearLayout mLlTabPersonalEdit;
    @Bind(R.id.ll_tab_extension)
    LinearLayout mLlTabExtension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_customerinfo;
    }

    @Override
    public void initView() {
        mIvLeft.setVisibility(View.VISIBLE);
        mTvMiddle.setVisibility(View.VISIBLE);
        mTvMiddle.setText("客户信息");
    }

    @Override
    public void initData() {
        Bundle bundle = this.getIntent().getExtras();
        String username = bundle.getString("info_username");
        String sex = bundle.getString("info_sex");
        mInfoUsername.setText(username);
        if (sex.equals("1") ) {
            mInfoSex.setBackgroundResource(R.drawable.personal_btn_boy_nor);
        } else if (sex.equals("0")) {
            mInfoSex.setBackgroundResource(R.drawable.personal_btn_girl_nor);
        }
        mInfoValidityTime.setText(bundle.getString("info_invlide_time"));
    }

    @OnClick(R.id.iv_left)
    public void closeActivty(){
        finish();
    }
}
