package com.shangliu.china.android.api;

import com.kymjs.rxvolley.client.HttpCallback;

/**
 * Created by bingley on 2016/4/29.
 */
public class SeacustApi {
    public final static String customer_url = "http://10.1.15.66/js/user.js";

    // 请求客户数据
    public static void getCustmerData(HttpCallback handler) {
        AsyncHttpHelp.get(customer_url,handler);
    }
}
