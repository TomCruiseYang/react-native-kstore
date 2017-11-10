package com.zoom.react_ks;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import cn.kuaishang.kssdk.KSConfig;
import cn.kuaishang.kssdk.util.KSIntentBuilder;
import cn.kuaishang.listener.KsInitListener;

public class KuaiShangModule extends ReactContextBaseJavaModule {
    private ReactApplicationContext context;

    public KuaiShangModule(ReactApplicationContext reactContext) {
        super(reactContext);
        context = reactContext;
    }

    @Override
    public String getName() {
        return "ksStore";
    }

    public static void initKS(Activity activity){
        KSConfig.init(activity, "Z0mqAlxBbK60/IgY2l9UPw4zreIReatc", new KsInitListener(){
            @Override
            public void onSuccess() {
                //TODO 初始化成功
                Log.e("initKS::::>>>","success");
            }

            @Override
            public void onError(int code, String message) {
                //TODO 初始化失败
                Log.e("initKS::::>>>","fail");
            }
        });
    }
    
    @ReactMethod
    public void startKS(){
        Intent intent = new KSIntentBuilder(getCurrentActivity()).build();
        getCurrentActivity().startActivity(intent);
    }

    @ReactMethod
    public void closeKS(){
        KSConfig.closeDialog(getCurrentActivity());
    }

}
