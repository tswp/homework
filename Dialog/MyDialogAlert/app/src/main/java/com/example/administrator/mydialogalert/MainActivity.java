package com.example.administrator.mydialogalert;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(android.R.drawable.btn_dialog);
        dialog.setTitle("提示");
        dialog.setMessage("欢迎使用本程序");
        dialog.setPositiveButton("OK",null);
        dialog.setNegativeButton("Cancel",null);
        dialog.create();
        dialog.show();
    }
}
