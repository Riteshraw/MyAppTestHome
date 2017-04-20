package com.example.ritesh.myapplication.Services;

import android.app.Service;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Ritesh on 4/7/2017.
 */
public class MyFCMListenerService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        remoteMessage.getData();
    }
}
