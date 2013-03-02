package com.example.italialinuxexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		Object[] pdus = (Object[])bundle.get("pdus");
		SmsMessage[] messages = new SmsMessage[pdus.length];
		for(int i = 0; i < pdus.length; i++){
			messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
		}
		for(SmsMessage message: messages){
		    String messagestr = message.getMessageBody();
		    String sender = message.getOriginatingAddress();
		    Toast.makeText(context, sender + ": " + messagestr, Toast.LENGTH_SHORT).show();
		}
	}

}
