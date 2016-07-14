package com.shangliu.china.android.model;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Customer {
    public int id;
    public String age;
    public String moblie;
    public String username;           // 如果是int 类型有错误 viewHolder.visit_time.setText(member.visit_time);
    public String sex;
    public String rank;
    public String visit_time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(String visit_time) {
        this.visit_time = visit_time;
    }


}
