package com.example.administrator.mynewdialer1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit = null;
    private Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText)findViewById(R.id.edit);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = edit.getText().toString();
                if (PhoneNumberUtils.isGlobalPhoneNumber(call)){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://"+call));
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,R.string.msg,Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
