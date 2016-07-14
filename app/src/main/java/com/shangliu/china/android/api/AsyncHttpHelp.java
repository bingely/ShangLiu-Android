package com.shangliu.china.android.api;

import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;

/**
 * Created by bingley on 2016/4/28.
 */
public class AsyncHttpHelp {

    public static void get(String url, HttpCallback handler) {
        RxVolley.get(url, handler);
    }

    public static void get(String url, HttpParams params, HttpCallback handler) {
        new RxVolley.Builder().url(url).params(params).cacheTime(15).callback(handler).doTask();
    }

    public static void post(String url, HttpParams params, HttpCallback handler) {
        RxVolley.post(url, params, handler);
    }
}
