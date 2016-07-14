package com.shangliu.china.android.adapter;

import android.view.View;

import com.shangliu.china.android.R;
import com.shangliu.china.android.model.Customer;
import com.shangliu.china.android.ui.base.BaseHolder;
import com.shangliu.china.android.ui.base.MyBaseAdapter;
import com.shangliu.china.android.util.UIUtils;

import java.util.List;


/**
 * Created by Administrator on 2016/4/14.
 */
public class MemberListAdapterr extends MyBaseAdapter<Customer> {   //
    /*@Bind(R.id.iv)                     // ButterKnife 第一步
            ImageView iv;
    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.visit_time)
    TextView visit_time;
    @Bind(R.id.tv_moblie)
    TextView tv_moblie;
    @Bind(R.id.tv_sex)
    TextView tv_sex;*/
    public MemberListAdapterr(List<Customer> t) {
        super(t);
    }

    @Override
    protected BaseHolder getHolder() {
        return new MyHolder();        //
    }

    private class MyHolder extends BaseHolder<Customer> {
        @Override
        public View initView() {
            return View.inflate(UIUtils.getContext(), R.layout.fragment_customer,null);
        }

        @Override
        protected void refreshView() {
            /*Customer member = getData();
            tv.setText(member.username);*/
        }
    }
}
