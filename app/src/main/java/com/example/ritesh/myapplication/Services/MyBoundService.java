package com.example.ritesh.myapplication.Services;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ritesh on 3/29/2017.
 */


public class MyBoundService extends Service {

    public Binder Mybinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return Mybinder;
    }

    public String getTime() {
        return new Date().toString();
    }

    public class MyBinder extends Binder {
        public MyBoundService getServiceInstance() {
            return MyBoundService.this;
        }
    }
}
