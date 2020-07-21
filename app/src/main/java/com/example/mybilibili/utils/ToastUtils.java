package com.example.mybilibili.utils;

import android.app.Application;
import android.text.method.MultiTapKeyListener;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtils {
    private static Application mContext;
    private static Toast mToast;
    public static void init(Application context) {
        mContext = context;
    }
    public static void showToastShort(String message) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
        } else {
            mToast.cancel();
            mToast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
        }
//        mToast.setGravity(Gravity.CENTER,0,0);
        mToast.show();
    }
}
