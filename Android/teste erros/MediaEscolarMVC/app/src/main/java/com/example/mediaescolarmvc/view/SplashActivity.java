package com.example.mediaescolarmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mediaescolarmvc.R;
import com.example.mediaescolarmvc.controller.AplicativoController;
import com.example.mediaescolarmvc.controller.MediaEscolarController;
import com.example.mediaescolarmvc.dataSource.DataSource;
import com.example.mediaescolarmvc.model.MediaEscolar;
import com.example.mediaescolarmvc.util.UtilMediaEscolar;


public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        DataSource ds = new DataSource(getApplicationContext());

        //Verificar se o Google Play Services está instalado


        if(AplicativoController.verificarGooglePlayServices(SplashActivity.this)){
            apresentarSplash();
        } else {
            UtilMediaEscolar.showMessageToast(getApplicationContext(), "Google Play Services não Configurado");
        }
    }

    private void apresentarSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                MediaEscolar obj = new MediaEscolar();

                obj.setMateria("Matemática");
                obj.setBimestre("1º Bimestre");
                obj.setNotaProva(10);
                obj.setNotaTrabalho(10);
                obj.setMediaFinal(10);
                obj.setSituacao("Reprovado");

                MediaEscolarController mediaEscolarController = new MediaEscolarController(getBaseContext());

                //mediaEscolarController.backupBancoDeDados();

                /*for (int i =0; i<5; i++){
                    mediaEscolarController.salvar(obj);
                }*/

                /*obj.setId(5);
                mediaEscolarController.alterar(obj);*/

                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(telaPrincipal);

                finish();

            }
        }, SPLASH_TIME_OUT);
    }


}
