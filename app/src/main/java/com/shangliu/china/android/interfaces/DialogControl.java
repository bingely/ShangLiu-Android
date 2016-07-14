package com.shangliu.china.android.interfaces;

import android.app.ProgressDialog;

/**
 * Created by Administrator on 2016/4/8.
 */
public interface DialogControl {

    public abstract void hideWaitDialog();

    public abstract ProgressDialog showWaitDialog();

    public abstract ProgressDialog showWaitDialog(int resid);

    public abstract ProgressDialog showWaitDialog(String text);
}
