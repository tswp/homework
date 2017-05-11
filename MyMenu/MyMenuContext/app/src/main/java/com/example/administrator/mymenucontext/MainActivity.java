package com.example.administrator.mymenucontext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG =  "ZDF";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = new TextView(this);
        tv.setText("上下文菜单的载体");
        registerForContextMenu(tv); // 注册上下文菜单
        setContentView(tv); // 设置菜单视图

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Log.d(LOG_TAG,"Item 新建"); // 响应新建
                break;
            case 2:
                Log.d(LOG_TAG,"Item 打开"); // 响应打开
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(0,1,1,R.string.new_file);
        menu.add(0,2,2,R.string.open_file);

        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
