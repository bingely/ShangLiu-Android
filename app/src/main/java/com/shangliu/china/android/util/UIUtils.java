package com.shangliu.china.android.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.shangliu.china.android.ui.base.BaseApplication;


/**
 * Created by bingley on 2016/4/13.
 * 给我一个资源id我就负责加载出来
 * dp-px转换
 * 保证runnable对象的run方法是运行在主线程当中
 */
public class UIUtils {

    public static View getXmlView(int layoutId){
        return View.inflate(getContext(), layoutId, null);
    }

    public static int getColor(int colorId) {
        return getResources().getColor(colorId);
    }

    public static String[] getStringArr(int arrId) {
        return getResources().getStringArray(arrId);
    }

    // ^……


    /**
     * 1dp---1px;
     * 1dp---0.75px;
     * 1dp---0.5px;
     * ....
     *
     * @param dp
     * @return
     */
    public static int dp2px(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }

    ;

    public static int px2dp(int px) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);
    }


    /**
     * 保证runnable对象的run方法是运行在主线程当中
     *
     * @param runnable
     */
    public static void runOnUIThread(Runnable runnable) {
        if (isInMainThread()) {
            runnable.run();
        } else {
            getHandler().post(runnable);
        }
    }

    private static boolean isInMainThread() {
        //当前线程的id
        int tid = android.os.Process.myTid();
        if (tid == BaseApplication.mainThreadId) {
            return true;
        }
        return false;
    }

    // 避免重复的
    public static void Toast(String text) {
        if (getContext()==null||text == null){
            return;
        }
        Toast.makeText(getContext(), text,Toast.LENGTH_SHORT).show();
    }

    /**
     * 可以在子线程中弹出toast
     *
     */
    /*public static void showToastSafe(final Context context, final String text) {
        ThreadUtils.runInUIThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    public static Context getContext() {
        return BaseApplication.context();
    }

    private static Resources getResources(){
        return BaseApplication.resources();
    }

    public static Handler getHandler() {
        return BaseApplication.handler;
    }
}
