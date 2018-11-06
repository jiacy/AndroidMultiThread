package com.example.jiacy.multithreadtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class RunnableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.runnable);
        ticketThreadSell();
        ticketRunnableSell();
        Button threadsell_bt = (Button) findViewById(R.id.threadtest);
        Button runnablesell_bt = (Button) findViewById(R.id.runnabletest);

        threadsell_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketThreadSell();
            }
        });

        runnablesell_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketRunnableSell();
            }
        });
    }

    public void ticketThreadSell() {
        TicketThread t1 = new TicketThread("1号业务员");
        TicketThread t2 = new TicketThread("2号业务员");
        t1.start();
        t2.start();
    }

    public void ticketRunnableSell() {
        TicketRunnable runnable = new TicketRunnable();
        for( int i = 0; i< 10; i++) {
            Thread r = new Thread(runnable, Integer.toString(i) +"号业务员");
            r.start();
        }
//        Thread r1 = new Thread(runnable, "1号业务员");
//        Thread r2 = new Thread(runnable, "2号业务员");
//        r1.start();
//        r2.start();
    }

    public class TicketThread extends Thread {
        private int ticket = 5;
        private String name;

        public TicketThread(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 0; i<5; i++) {
                if (ticket > 0) {
                    Log.w("TCorp", name + "卖了一张票，编号为t" + (ticket--));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class TicketRunnable implements Runnable {
        private int ticket = 20;
        public void run() {
            for (int i = 0; i<20; i--) {
                if(ticket > 0) {
                    Log.w("RCorp", Thread.currentThread().getName() + "卖了一张票，编号为r" + (ticket--));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
