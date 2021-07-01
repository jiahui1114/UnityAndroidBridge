package com.DefaultCompany.UnityBridgeSample;

import android.app.Application;
import android.util.Log;

/**
 * Create by Wang.Jiahui
 * description:
 * on 2021/3/9
 */
public class BaseApplcation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("wjh", "onCreate");
    }
}
