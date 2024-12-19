package com.example.appnotificacao.push;

import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PushFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String s){
        super.onNewToken(s);
        Log.i("APP Push", "Novo Token" + s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }
}
