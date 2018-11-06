package com.example.jiacy.multithreadtest;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.os.Message;

import java.text.DecimalFormat;
import java.util.Random;

public class FetchThreadActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    HandlerThread fetchThread = new HandlerThread("fetching thread");
    Handler fetchHandler;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetch_thread);
        tv = (TextView) findViewById(R.id.texting);
        //  start thread
        fetchThread.start();
        //  通过fetchhandler发送的消息，会被fetchThread创建的Looper拉取到
        fetchHandler = new Handler(fetchThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                SystemClock.sleep(1000);
                double value = new Random().nextDouble() * 10;
                final String price = xiaoshuToString(value);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("美元汇率："+price);
                        Log.e(TAG,"美元汇率："+price);
                    }
                });
//                循环执行
                fetchHandler.sendEmptyMessage(1);
            }
        };
    }

    public static String xiaoshuToString(double f) {
        DecimalFormat df = new DecimalFormat("0.0");
        String priceF = df.format(f);
        return priceF;
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchHandler.sendEmptyMessage(1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        fetchThread.quit();
    }
}
