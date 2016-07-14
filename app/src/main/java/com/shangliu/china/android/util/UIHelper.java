package com.shangliu.china.android.util;

import android.content.Context;
import android.content.Intent;

import com.shangliu.china.android.ui.activity.MobileAddressActivity;


/**
 * 界面帮助类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月10日 下午3:33:36
 * 
 */
public class UIHelper {

    // 跳转到手机通讯录页面中
    public static void showMobilelistData(Context context) {
        Intent intent = new Intent(context, MobileAddressActivity.class);
        context.startActivity(intent);
    }


    // 界面跳转逻辑


    /**
     * 显示帖子详情
     * 
     * @param context
     * @param postId
     */
   /* public static void showPostDetail(Context context, int postId, int count) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("id", postId);
        intent.putExtra("comment_count", count);
        intent.putExtra(DetailActivity.BUNDLE_KEY_DISPLAY_TYPE,
                DetailActivity.DISPLAY_POST);
        context.startActivity(intent);
    }*/


}
