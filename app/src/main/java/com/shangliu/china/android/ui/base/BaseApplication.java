package com.shangliu.china.android.ui.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

public class BaseApplication extends Application {
    static Context _context;
    static Resources _resource;

    public static Handler handler = null;
    public static Thread mainThread = null;
    public static int mainThreadId = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();   // 初始化——context
        _resource = _context.getResources();

        handler = new Handler();
        mainThread = Thread.currentThread();
        mainThreadId = android.os.Process.myTid();
    }

    // 暴露context/resuource方法
    public static synchronized BaseApplication context() {
        return (BaseApplication) _context;          // 这样写有上面好处吗
    }

    public static Resources resources() {
        return _resource;
    }


}
