package com.example.mydragwidget;

import android.app.Application;
import android.content.Context;

//import com.example.mydragwidget.statictest.ActivityThread;

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

//        ActivityThread.currentActivityThread.call();
    }
}
