package com.example.jiacy.multithreadtest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.view.MotionEvent;

public class ViewActivity extends AppCompatActivity {
    float x, y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_test);

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        Button bt1 = (Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("mandroid.cn", "button被点击");
            }
        });
        bt1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.i("mandroid.cn", "button被长按");
                return false;
            }
        });
        bt1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                x = motionEvent.getRawX();
                y = motionEvent.getRawY();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        Log.i("mandroid.cn", "button按下" + Float.toString(x) + "," + Float.toString(y));
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        Log.i("mandroid.cn", "button移动" + Float.toString(x) + "," + Float.toString(y));
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        Log.i("mandroid.cn", "button松开" + Float.toString(x) + "," + Float.toString(y));
                        break;
                    }
                }
                //返回true不响应click事件
                return false;
            }
        });
    }
}
