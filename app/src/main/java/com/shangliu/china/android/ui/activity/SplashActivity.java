package com.shangliu.china.android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.shangliu.china.android.R;
import com.shangliu.china.android.util.SPUtil;


public class SplashActivity extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler = new Handler();
        String password = SPUtil.getDefault(SplashActivity.this).getPwd();
        if (!TextUtils.isEmpty(password)) {
            mHandler.postDelayed(gotoMainAct, 0);   //不用每次都得看那个splash页面
        } else {
            mHandler.postDelayed(gotoLoginAct, 3000);
        }
    }

    Runnable gotoLoginAct = new Runnable() {

        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }
    };

    Runnable gotoMainAct = new Runnable() {

        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    };
}
