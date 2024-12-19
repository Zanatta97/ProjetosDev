package com.example.aulaappsendsms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SmsManager smsManager;

    Button btnEnviar;
    EditText edTelefone;
    EditText edMensagem;

    String smsTelefone;
    String smsMensagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTelefone = findViewById(R.id.edTelefone);
        edMensagem = findViewById(R.id.edMensagem);

        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsTelefone = edTelefone.getText().toString();
                smsMensagem = edMensagem.getText().toString();

                try{
                    smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(smsTelefone, null, smsMensagem, null, null);

                    Toast.makeText(getApplicationContext(), "SMS Enviado com Sucesso", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "FALHA! SMS não enviado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
