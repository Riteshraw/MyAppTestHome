package com.example.ritesh.myapplication.Recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Ritesh on 3/27/2017.
 */

public class MyReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON"))
            Toast.makeText(context, "The was turned on...", Toast.LENGTH_LONG).show();
        else if (intent.getAction().equals("android.intent.action.SCREEN_OFF"))
            Toast.makeText(context, "The screen is turned off", Toast.LENGTH_SHORT).show();
    }

}
