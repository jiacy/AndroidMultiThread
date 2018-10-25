package com.example.jiacy.multithreadtest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncTaskActivity extends AppCompatActivity {
    Button button, cancel;
    TextView text;
    ProgressBar progressBar;
    String tag = "AsyncTaskTest";
    MyTask mTask;

    private class MyTask extends AsyncTask<String, Integer,String> {

        @Override
        protected void onPreExecute() {
            text.setText("加载中");
            Log.d(tag, "onPreExecute");
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                int count = 0;
                int length = 1;
                while(count < 99) {
                    count += length;
                    publishProgress(count);
                    Thread.sleep(1);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progresses) {
            progressBar.setProgress(progresses[0]);
            text.setText("loading..." + progresses[0] + "%");
        }

        @Override
        protected void onPostExecute(String result) {
            text.setText("加载完毕");
            button.setClickable(true);
        }


        @Override
        protected void onCancelled() {
            button.setClickable(true);
            text.setText("已取消");
            progressBar.setProgress(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            Log.d(tag, "sleep 1S");
//        }

        setContentView(R.layout.async_task);
        button = (Button) findViewById(R.id.button);
        cancel = (Button) findViewById(R.id.cancel);
        text = (TextView) findViewById(R.id.text);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setClickable(false);
                mTask = new MyTask();
                mTask.execute();
            }
        });

        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTask.cancel(true);
            }
        });
    }

//    public class MyTask extends AsyncTask
}
