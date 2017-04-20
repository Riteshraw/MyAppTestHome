package com.example.ritesh.myapplication.Recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.ritesh.myapplication.Services.MyService;

/**
 * Created by Ritesh on 3/28/2017.
 */

public class CustomReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("My_Action")) {
            Toast.makeText(context, "This is my intent action receiver...", Toast.LENGTH_SHORT).show();
            context.startService(new Intent(context, MyService.class));
        }
    }
}
