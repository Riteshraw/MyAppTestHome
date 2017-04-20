package com.example.ritesh.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ritesh.myapplication.Recievers.MyReceiver;
import com.example.ritesh.myapplication.Services.MyBoundService;
import com.example.ritesh.myapplication.Services.MyService;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReciever;
    private IntentFilter intentFilter;
    private MyBoundService myBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReciever = new MyReceiver();

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.Intent.action.SCREEN_OFF");

        //sendBroadcast(new Intent().setAction("My_Action"));//custom broadcast

        //startService(new Intent(this, MyService.class));

        bindService(new Intent(this, MyBoundService.class), serviceConnection, Context.BIND_AUTO_CREATE);

        ((Button) findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView) findViewById(R.id.btn)).setText(myBoundService.getTime());
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReciever, intentFilter);
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReciever);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) service;
            myBoundService = myBinder.getServiceInstance();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}
