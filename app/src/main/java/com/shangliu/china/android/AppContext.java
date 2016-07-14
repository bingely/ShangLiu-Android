package com.shangliu.china.android;

import com.shangliu.china.android.ui.base.BaseApplication;
import com.shangliu.china.android.util.TLog;
import com.kymjs.okhttp.OkHttpStack;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.http.RequestQueue;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

/**
 * 全局应用程序类：用于保存和调用全局应用配置及访问网络数据
 *
 */
public class AppContext extends BaseApplication {

    private static AppContext appContext;

    private int loginUid; // 登录用户的id

    private boolean login = false; // 登录状态

    @Override
    public void onCreate() {
        super.onCreate();
        // 注册App异常崩溃处理器
        //CustomActivityOnCrash.install(this);
        File cacheFolder = getCacheDir();
        RxVolley.setRequestQueue(RequestQueue.newRequestQueue(cacheFolder, new
                OkHttpStack(new OkHttpClient())));
        init();
        appContext = this;
    }

    private void init() {
        // 初始化网络请求
        /*AsyncHttpClient client = new AsyncHttpClient();
        PersistentCookieStore myCookieStore = new PersistentCookieStore(this);
        client.setCookieStore(myCookieStore);
        ApiHttpClient.setHttpClient(client);
        ApiHttpClient.setCookie(ApiHttpClient.getCookie(this));*/

        // Log控制器
        TLog.DEBUG = BuildConfig.DEBUG;

        // Bitmap缓存地址
    }

    private void initLogin() {

    }

    /**
     * 获得当前app运行的AppContext
     *
     * @return
     */
    public static AppContext getInstance() {
        return appContext;
    }


}
