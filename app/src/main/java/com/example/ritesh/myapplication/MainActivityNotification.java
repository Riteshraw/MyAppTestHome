package com.example.ritesh.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notification);
        Intent intent = new Intent(this, MainActivity.class);
        final PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        ((Button) findViewById(R.id.btn_notfication)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 1;

                Notification notification = new Notification.Builder(MainActivityNotification.this)
                        .setContentTitle("My title for notification")
//                        .setContentText("Hi this is the text for the notifcation,Hi this is the text for the notifcation,Hi this is the text for the notifcation")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(false)
                        .setPriority(Notification.PRIORITY_HIGH)
                        .addAction(R.mipmap.ic_launcher, "Function", pIntent)
                        .setStyle(new Notification.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)))
                        .build();

                notification.flags = Notification.FLAG_NO_CLEAR;

                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(i++, notification);

            }
        });
    }
}
