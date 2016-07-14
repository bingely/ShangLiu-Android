package com.shangliu.china.android.ui.dialog;

import android.app.ProgressDialog;
import android.content.Context;

import com.shangliu.china.android.R;


/**
 * Created by Administrator on 2016/4/15.
 */
public class DialogUtils {
    private static boolean _isVisible;
    private static ProgressDialog _waitDialog;
    static Context mContext;
    public DialogUtils(Context context) {
        mContext = context;
    }

    public static ProgressDialog showWaitDialog() {
        return showWaitDialog(R.string.loading);
    }

    public static ProgressDialog showWaitDialog(int resid) {
        return showWaitDialog(mContext.getString(resid));
    }

    public static ProgressDialog showWaitDialog(String message) {
        if (_isVisible) {
            if (_waitDialog == null) {
                _waitDialog = DialogHelp.getWaitDialog(mContext, message);
            }
            if (_waitDialog != null) {
                _waitDialog.setMessage(message);
                _waitDialog.show();
            }
            return _waitDialog;
        }
        return null;
    }

    public static void hideWaitDialog() {
        if (_isVisible && _waitDialog != null) {
            try {
                _waitDialog.dismiss();
                _waitDialog = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
