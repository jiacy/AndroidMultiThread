package com.example.jiacy.multithreadtest;

import android.app.Application;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;

public class CustomApplication extends Application {

    private static final String VALUE = "Harvey";
    private String value;

    @Override
    public void onCreate() {
        super.onCreate();
        setValue(VALUE);
        Fresco.initialize(this);
        Log.i("Application","enter onCreate");
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
