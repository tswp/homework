package com.example.administrator.myhandlermessageprogress;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button btn = null;
    private ProgressBar bar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        bar = (ProgressBar)findViewById(R.id.progress_bar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.setVisibility(View.VISIBLE);
                handler.post(thread);
            }
        });
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bar.setProgress(msg.arg1);
            handler.post(thread);
        }
    };

    Runnable thread = new Runnable(){
        int i = 0;

        @Override
        public void run() {
            i = i + 10;
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            Message msg = handler.obtainMessage();
            msg.arg1 = i;
            handler.sendMessage(msg);
            if (i == 100){
                handler.removeCallbacks(thread);
            }
        }
    };
}
