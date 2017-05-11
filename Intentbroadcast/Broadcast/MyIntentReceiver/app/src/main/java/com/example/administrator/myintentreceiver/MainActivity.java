package com.example.administrator.myintentreceiver;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bind = null;
    private Button unbind = null;
    private MsgReceiver msgReceiver = null;
    final private static String actionName = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = (Button)findViewById(R.id.bind);
        unbind = (Button)findViewById(R.id.unbind);

        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msgReceiver = new MsgReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(actionName);
                MainActivity.this.registerReceiver(msgReceiver,intentFilter);
            }
        });

        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.unregisterReceiver(msgReceiver);
            }
        });
    }
}
