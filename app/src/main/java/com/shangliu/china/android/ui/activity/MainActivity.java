package com.shangliu.china.android.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shangliu.china.android.R;
import com.shangliu.china.android.ui.base.BaseActivity;
import com.shangliu.china.android.ui.fragments.CustomerFragment;
import com.shangliu.china.android.ui.fragments.FindFragment;
import com.shangliu.china.android.ui.fragments.MainFragment;
import com.shangliu.china.android.ui.fragments.MeFragment;
import com.shangliu.china.android.util.UIUtils;

import butterknife.Bind;
import butterknife.OnClick;

// 整个系统的大容器，加载几个大Fragment
public class MainActivity extends BaseActivity {
    @Bind(R.id.ll_tab_home)
    LinearLayout mLlTabHome;
    @Bind(R.id.ll_tab_customer)
    LinearLayout mLlTabCustomer;
    @Bind(R.id.ll_tab_find)
    LinearLayout mLlTabFind;
    @Bind(R.id.ll_tab_me)
    LinearLayout mLlTabMe;
    @Bind(R.id.iv_home)
    ImageView mIvHome;
    @Bind(R.id.tv_home)
    TextView mTvHome;
    @Bind(R.id.iv_customer)
    ImageView mIvCustomer;
    @Bind(R.id.tv_customer)
    TextView mTvCustomer;
    @Bind(R.id.iv_find)
    ImageView mIvFind;
    @Bind(R.id.tv_find)
    TextView mTvFind;
    @Bind(R.id.iv_me)
    ImageView mIvMe;
    @Bind(R.id.tv_me)
    TextView mTvMe;
    private long exitTime = 0; // 两次按返回键退出用

    private MainFragment mainFragment;
    private CustomerFragment mCustomerFragment;
    private FindFragment findFragment;
    private MeFragment meFragmnet;

    FragmentTransaction mFragementTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_center;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
        setSelect(0);
    }


    @OnClick({R.id.ll_tab_home, R.id.ll_tab_customer, R.id.ll_tab_find, R.id.ll_tab_me})
    public void changeTab(View view) {
        switch (view.getId()) {
            case R.id.ll_tab_home:
                setSelect(0);
                break;
            case R.id.ll_tab_customer:
                setSelect(1);
                break;
            case R.id.ll_tab_find:
                setSelect(2);
                break;
            case R.id.ll_tab_me:
                setSelect(3);
                break;

        }
    }

    private void setSelect(int i) {
        mFragementTransaction = getSupportFragmentManager().beginTransaction();
        reSetTab();
        hideFragment();
        switch (i) {
            case 0:
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                    mFragementTransaction.add(R.id.fl_content, mainFragment);
                }
                mIvHome.setBackgroundResource(R.drawable.btn_home_pre);
                mTvHome.setTextColor(getResources().getColor(R.color.bottom_tv_selected));
                mFragementTransaction.show(mainFragment);
                break;
            case 1:
                if (mCustomerFragment == null) {
                    mCustomerFragment = new CustomerFragment();
                    mFragementTransaction.add(R.id.fl_content, mCustomerFragment);
                }
                mIvCustomer.setBackgroundResource(R.drawable.toolbar_btn_client_pre);
                mTvCustomer.setTextColor(getResources().getColor(R.color.bottom_tv_selected));
                mFragementTransaction.show(mCustomerFragment);
                break;
            case 2:
                if (findFragment == null) {
                    findFragment = new FindFragment();
                    mFragementTransaction.add(R.id.fl_content, findFragment);
                }
                mIvFind.setBackgroundResource(R.drawable.toolbar_btn_find_pre);
                mTvFind.setTextColor(getResources().getColor(R.color.bottom_tv_selected));
                mFragementTransaction.show(findFragment);
                break;
            case 3:
                if (meFragmnet == null) {
                    meFragmnet = new MeFragment();
                    mFragementTransaction.add(R.id.fl_content, meFragmnet);
                }
                mIvMe.setBackgroundResource(R.drawable.toolbal_btn_me_pre);
                mTvMe.setTextColor(getResources().getColor(R.color.bottom_tv_selected));
                mFragementTransaction.show(meFragmnet);
                break;
        }
        mFragementTransaction.commit();
    }

    private void reSetTab() {
        mIvHome.setBackgroundResource(R.drawable.btn_home_nor);
        //mTvHome.setTextColor(UIUtils.getColor(R.color.bottom_tv_unselected));
        mTvHome.setTextColor(getResources().getColor(R.color.bottom_tv_unselected));

        mIvCustomer.setBackgroundResource(R.drawable.toolbar_btn_client_nor);
        mTvCustomer.setTextColor(getResources().getColor(R.color.bottom_tv_unselected));

        mIvFind.setBackgroundResource(R.drawable.toolbar_btn_find_nor);
        mTvFind.setTextColor(getResources().getColor(R.color.bottom_tv_unselected));

        mIvMe.setBackgroundResource(R.drawable.toolbal_btn_me_nor);
        mTvMe.setTextColor(getResources().getColor(R.color.bottom_tv_unselected));
    }

    private void hideFragment() {
        if (mainFragment != null) {
            mFragementTransaction.hide(mainFragment);
        }
        if (mCustomerFragment != null) {
            mFragementTransaction.hide(mCustomerFragment);
        }
        if (findFragment != null) {
            mFragementTransaction.hide(findFragment);
        }

        if (meFragmnet != null) {
            mFragementTransaction.hide(meFragmnet);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                UIUtils.Toast("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);   // TODO
            }
        }
        //return super.onKeyDown(keyCode, event);
        return false;
    }
}