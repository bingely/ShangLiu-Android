package com.shangliu.china.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shangliu.china.android.R;
import com.shangliu.china.android.model.Customer;
import com.shangliu.china.android.ui.activity.CustomerinfoActivity;
import com.shangliu.china.android.util.UIUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/4/8.
 * TODO 写一个万能的Adapter类
 */
public class CustomerListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Customer> mCustomers;


    public CustomerListAdapter(Context context, List<Customer> customers) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mCustomers = customers;
    }

    public void setList(List<Customer> customers) {
        this.mCustomers = customers;
    }

    @Override
    public int getCount() {
        return mCustomers.size();
    }

    @Override
    public Object getItem(int position) {
        return mCustomers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        final Customer member = mCustomers.get(position);
        if (convertView == null) {
            convertView = View.inflate(UIUtils.getContext(), R.layout.adapter_customer, null);
            viewHolder = new ViewHolder(convertView);   //  ButterKnife 第三部
            // 客户姓名
            viewHolder.mTvCustomerName.setText(member.username);
            // 客户性别
            if (member.sex.equals("1")) {
                viewHolder.mIvCustomerSex.setBackgroundResource(R.drawable.list_icon_boy);
            } else if (member.sex.equals("0")) {
                viewHolder.mIvCustomerSex.setBackgroundResource(R.drawable.list_icon_girl);
            }
            // 客户等级
            if (member.rank.equals("A")) {
                viewHolder.mIvCustomerRank.setBackgroundResource(R.drawable.list_icon_a);
            } else if (member.rank.equals("B")) {
                viewHolder.mIvCustomerRank.setBackgroundResource(R.drawable.list_icon_b);
            } else if (member.rank.equals("C")) {
                viewHolder.mIvCustomerRank.setBackgroundResource(R.drawable.list_icon_c);
            }
            // 跟进时间
            viewHolder.mTvFollowTime.setText(" " + member.visit_time);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, CustomerinfoActivity.class);
                    intent.putExtra("info_username", member.username);
                    intent.putExtra("info_sex", member.sex);
                    intent.putExtra("info_invlide_time", member.visit_time);
                    mContext.startActivity(intent);
                }
            });

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class ViewHolder {
        // ButterKnife 第一步
        @Bind(R.id.tv_customer_name)
        TextView mTvCustomerName;
        @Bind(R.id.tv_customer_sex)
        ImageView mIvCustomerSex;
        @Bind(R.id.tv_customer_rank)
        ImageView mIvCustomerRank;
        @Bind(R.id.tv_ramain_time)
        TextView mTvRamainTime;
        @Bind(R.id.tv_followTime)
        TextView mTvFollowTime;
        @Bind(R.id.iv_call)
        ImageView mIvCall;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);        // ButterKnife 第二部
        }
    }
}
