package com.example.appsendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edEmail, edAssunto, edMensagem;
    Button btnEnviar;
    String email, assunto, mensagem;
    Intent intent;
    boolean validaEmail, validaMensagem;

   /* private static boolean isValidEmail(String checaEmail) {
        return TextUtils.isEmpty(checaEmail) && android.util.Patterns.EMAIL_ADDRESS.matcher(checaEmail).matches();
    }*/

    public boolean checkForEmail(EditText edit) {
        String email = edit.getText().toString();
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() == true) {
            return true;
        }

        return false;
    }

    public void processaDados() {
            validaEmail = false;
            validaMensagem = false;

            //Verifica se o email foi preenchido
            if (edEmail.getText().toString().length()>0) {
                //Se foi preenchido verifica se é válido
                if (checkForEmail(edEmail) == true) {
                    email = edEmail.getText().toString();
                    validaEmail = true;

                    //Se for válido verifica os outros campos

                    //Verifica o campo assunto e coloca "Sem assunto" caso vazio
                    if ( edAssunto.getText().toString().length()>0) {
                        assunto = edAssunto.getText().toString();
                    }else {
                        assunto = "Sem assunto";
                    }

                    //Verifica o campo mensagem que não pode ser vazio
                    if (edMensagem.getText().toString().length()>0) {
                        mensagem = edMensagem.getText().toString();
                        validaMensagem = true;
                    }else{
                        edMensagem.setError("Mensagem não pode ser vazia");
                        edMensagem.requestFocus();
                        validaMensagem = false;
                    }

                }else{
                    edEmail.setError("E-mail Inválido");
                    edEmail.requestFocus();
                    validaEmail = false;
                }
            }else{
                edEmail.setError("Favor Informar o E-mail do Destinatário");
                edEmail.requestFocus();
                validaEmail = false;
            }
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = findViewById(R.id.editEmail);
        edAssunto = findViewById(R.id.editAssunto);
        edMensagem = findViewById(R.id.editMensagem);

        btnEnviar = findViewById(R.id.btnEnviar);




        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processaDados();
                //Toast.makeText(getApplicationContext(), "Email: " + email + "\nAssunto: " + assunto + "\nMensagem:"
                // + mensagem, Toast.LENGTH_LONG).show();]

                if (validaMensagem) {
                    intent = new Intent(Intent.ACTION_SEND);

                    intent.putExtra(Intent.EXTRA_EMAIL,
                            new String[] {email} );
                    intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
                    intent.putExtra(Intent.EXTRA_TEXT, mensagem);

                    intent.setType("message/rfc822");

                    startActivity(Intent.createChooser(intent, "Selecione um aplicativo"));
                }

            }
        });

        }
    }
