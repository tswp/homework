package com.example.administrator.myintentreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by Administrator on 2017/4/28.
 */

public class MsgReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] pduses = (Object[])bundle.get("pdus");
        SmsMessage[] smsMessages = new SmsMessage[pduses.length];

        for (int i = 0;i<smsMessages.length;i++){
            smsMessages[i] = SmsMessage.createFromPdu((byte[])pduses[i]);
            System.out.println(smsMessages[i].getDisplayMessageBody());
        }

    }
}
