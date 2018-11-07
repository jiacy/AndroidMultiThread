package com.example.jiacy.multithreadtest;

import android.app.Application;
import android.util.Log;

public class CustomApplication extends Application {

    private static final String VALUE = "Harvey";
    private String value;

    @Override
    public void onCreate() {
        super.onCreate();
        setValue(VALUE);
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
