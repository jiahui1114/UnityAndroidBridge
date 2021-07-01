package com.DefaultCompany.UnityBridgeSample.permission;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.rokid.unitycallbridge.Command.CallbackBean;
import com.rokid.unitycallbridge.UnityCallBridge;
import com.rokid.unitycallbridge.annotation.AndroidParam;
import com.rokid.unitycallbridge.annotation.UnityMethod;
import com.rokid.unitycallbridge.annotation.UnityParam;
import com.rokid.unitycallbridge.annotation.UnityService;
import com.rokid.unitycallbridge.base.IUnityService;
import com.unity3d.player.UnityPlayerActivity;

@UnityService("Toast")
public class ToastActivity extends UnityPlayerActivity implements IUnityService {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UnityCallBridge.setTagLevel(true);
        registerUnityServices();
    }

    private void registerUnityServices() {
        UnityCallBridge.registerInstance(ToastActivity.this);
    }

    @UnityMethod("getActivity")
    public Context getActivityContext(){
        return this;
    }

    @UnityMethod("show")
    public void showToast(@UnityParam("text") String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @UnityMethod("showWithCallback")
    public void showToast(@UnityParam("text") String text, CallbackBean callback){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        callback.setParam("show Success");
        UnityCallBridge.notifyUnityCall(callback);
    }

    @UnityMethod("showWithAndroidParam")
    public void showToast(@AndroidParam("context") Context context, @UnityParam("text") String text){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}