package com.example.ritesh.myapplication.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;
import android.os.Handler;

import java.util.Date;

/**
 * Created by Ritesh on 3/28/2017.
 */

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "" + new Date(), Toast.LENGTH_SHORT).show();
                                    handler.postDelayed(this,1000);
                                }
                            }, 1000
        );

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sendBroadcast(new Intent().setAction("My_Action"));
    }
}
