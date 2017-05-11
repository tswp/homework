package com.example.administrator.mydialogprogress;

import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn = null;
    private ProgressBar progressBar_normal = null;
    private ProgressBar progressBar_horizontal = null;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        progressBar_normal = (ProgressBar)findViewById(R.id.bar_normal);
        progressBar_horizontal = (ProgressBar)findViewById(R.id.bar_horizontal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0){
                    progressBar_horizontal.setVisibility(View.VISIBLE);
                    progressBar_normal.setVisibility(View.VISIBLE);
                }else if(i < progressBar_horizontal.getMax()){
                    progressBar_horizontal.setProgress(i);
                    progressBar_horizontal.setSecondaryProgress(i + 10);
                }else{
                    progressBar_horizontal.setVisibility(View.GONE);
                    progressBar_normal.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this,"加载已完成",Toast.LENGTH_SHORT).show();
                }
                i = i + 10;
            }
        });
    }
}
