package com.example.ritesh.myapplication.Recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Ritesh on 3/27/2017.
 */

public class MyConnReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
            Toast.makeText(context, "Connectivity changed...", Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals("android.net.wifi.STATE_CHANGED"))
            Toast.makeText(context, "Wifi state changed", Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED"))
            Toast.makeText(context, "Wifi state changed 2", Toast.LENGTH_SHORT).show();
    }
}
