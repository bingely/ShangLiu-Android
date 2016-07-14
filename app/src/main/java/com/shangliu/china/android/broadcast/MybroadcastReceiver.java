package com.shangliu.china.android.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class MybroadcastReceiver extends BroadcastReceiver {

    public static List<EvenHandler> mEvenHandlers = new ArrayList<EvenHandler>();

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        String action = intent.getAction();
        if (TextUtils.equals(action, ConnectivityManager.CONNECTIVITY_ACTION)) {
            if (mEvenHandlers.size() > 0) {
                for (EvenHandler evenHandler : mEvenHandlers) {
                    evenHandler.onNetChange();
                }
            }

        }
    }

    public static abstract interface EvenHandler {
        public abstract void onNetChange();
    }
}
