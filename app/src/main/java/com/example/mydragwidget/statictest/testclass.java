package com.example.mydragwidget.statictest;

import android.os.Handler;
import android.util.Log;


/**
 * 这里面可以在类初始化
 */
public class testclass {
    public static Class<?> TYPE = RefClass.load(testclass.class, "android.app.ActivityThread");
    public static RefStaticMethod currentActivityThread;    // 这里直接反射了 android.app.ActivityThread 里面同名方法
//    public static RefMethod<Handler> getHandler;

    public int i;

    static {
//        TYPE = RefClass.load(testclass.class, "com.example.mydragwidget.statictest.testclass");
        Log.d("lizhihong", "TYPE = " + TYPE);
    }
}
