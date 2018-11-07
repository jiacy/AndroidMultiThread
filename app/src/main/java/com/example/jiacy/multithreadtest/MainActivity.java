package com.example.jiacy.multithreadtest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private CustomApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        app = (CustomApplication)getApplication();
        app.setValue("HarveyTest");
        Log.i("MainAcitivity", "初始值=" + app.getValue());
        Button ayncbutton = (Button) findViewById(R.id.asynctest);
        Button handlerbutton = (Button) findViewById(R.id.handlerthread);
        Button fetchbutton = (Button) findViewById(R.id.fetch_thread);
        Button runnable = (Button) findViewById(R.id.runnable);
        Button viewtest = (Button) findViewById(R.id.viewtest);
        Button imageview = (Button) findViewById(R.id.imageview);

        ayncbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsyncTaskActivity.class);
                startActivity(intent);
            }
        });


        handlerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThreadHandlerActivity.class);
                startActivity(intent);
            }
        });

        fetchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FetchThreadActivity.class);
                startActivity(intent);
            }
        });

        runnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RunnableActivity.class);
                startActivity(intent);
            }
        });

        viewtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
                startActivity(intent);
            }
        });
    }



//    public class MyTask extends AsyncTask
}
