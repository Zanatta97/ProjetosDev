package com.example.appnotificacao;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {

    Button btnNotificar;

    SharedPreferences sharedPreferences;
    String tokenApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotificar = findViewById(R.id.btnNotificar);

        btnNotificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences = getSharedPreferences("PushPref", MODE_PRIVATE);

                String mensagem = "Seu merda";
                String titulo = "Vai se foder";

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    notificarUsuarioOreo(mensagem, titulo);
                    getTokenFCM();
                } else {
                    notificarUsuario(mensagem, titulo);
                    getTokenFCM();
                }
            }
        });
        //String mensagem = "Seu merda";
        //String titulo = "Vai se foder";

        //notificarUsuario(mensagem, titulo);
    }

    private void notificarUsuario(String mensagem, String titulo) {

        NotificationCompat.Builder notificacao =
                new NotificationCompat.Builder(getBaseContext());

        notificacao.setContentTitle(titulo);
        notificacao.setContentText(mensagem);
        notificacao.setPriority(Notification.PRIORITY_HIGH);
        notificacao.setChannelId("teste");


        notificacao.setLargeIcon(
                BitmapFactory.decodeResource(getBaseContext().getResources(),
                        R.mipmap.ic_launcher_foreground));

        notificacao.setSmallIcon(R.drawable.ic_stat_name);

        Intent intent =
                new Intent(getBaseContext(), TesteActivity.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(getBaseContext(), 100,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);

        notificacao.setAutoCancel(true);
        notificacao.setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager)
                        getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(9000, notificacao.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void notificarUsuarioOreo(String mensagem, String titulo) {

        String CHANNEL_ID = "my_channel_01";// The id of the channel.
        CharSequence name = "teste";// The user-visible name of the channel.
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

        NotificationCompat.Builder notificacao =
                new NotificationCompat.Builder(getBaseContext());

        notificacao.setContentTitle(titulo);
        notificacao.setContentText(mensagem);
        notificacao.setPriority(Notification.PRIORITY_HIGH);
        notificacao.setChannelId(CHANNEL_ID);


        notificacao.setLargeIcon(
                BitmapFactory.decodeResource(getBaseContext().getResources(),
                        R.mipmap.ic_launcher_foreground));

        notificacao.setSmallIcon(R.drawable.ic_stat_name);

        Intent intent =
                new Intent(getBaseContext(), TesteActivity.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(getBaseContext(), 100,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);

        notificacao.setAutoCancel(true);
        notificacao.setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager)
                        getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.createNotificationChannel(mChannel);

        notificationManager.notify(9000, notificacao.build());
    }

    private void getTokenFCM(){



        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(MainActivity.this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                tokenApp = instanceIdResult.getToken();
                salvarTokenFCM();
            }
        });

    }

    private void salvarTokenFCM(){

        SharedPreferences.Editor edit = sharedPreferences.edit();


        edit.putString("TokenApp", tokenApp);
        edit.apply();
    }

}
