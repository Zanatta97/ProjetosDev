package com.samuel.controledeentradaempresas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.samuel.controledeentradaempresas.controller.EmpresaController;
import com.samuel.controledeentradaempresas.dataModel.EmpresaDataModel;
import com.samuel.controledeentradaempresas.dataModel.ReservaDataModel;
import com.samuel.controledeentradaempresas.dataSource.DataSource;
import com.samuel.controledeentradaempresas.model.Empresa;
import com.samuel.controledeentradaempresas.util.GetEmpresaAsyncTask;
import com.samuel.controledeentradaempresas.util.UtilAplicativo;

public class LoginActivity extends AppCompatActivity {

    Empresa empresa;

    Button btnLogin;

    EditText edEmail;
    EditText edSenha;

    TextView txtErro;

    ImageView imgVerSenhaLogin;

    Boolean validacao;

    EmpresaController controller;

    Integer senhaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        edEmail = findViewById(R.id.edEmail);
        edSenha = findViewById(R.id.edSenha);
        txtErro = findViewById(R.id.txtErro);
        imgVerSenhaLogin = findViewById(R.id.imgVerSenhaLogin);

        edSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
        senhaLogin = 1;

        controller = new EmpresaController(getBaseContext());

        SharedPreferences sharedPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.commit();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtErro.setVisibility(View.INVISIBLE);

                //Valida os campos digitados
                //Checa se o campo email foi digitado
                if (edEmail.getText().toString().length()==0) {
                    edEmail.setError("Informe o Email");
                    edEmail.requestFocus();
                    validacao = false;
                    txtErro.setText("Favor Informar o Email");
                    txtErro.setVisibility(View.VISIBLE);
                    //Checa se a senha foi digitada
                } else if (edSenha.getText().toString().length()==0) {
                    edSenha.setError("Informe a Senha");
                    edSenha.requestFocus();
                    validacao = false;
                    txtErro.setText("Informe a Senha");
                    txtErro.setVisibility(View.VISIBLE);
                } else {

                    controller.deletarTabela(EmpresaDataModel.getTABELA());
                    controller.criarTabela(EmpresaDataModel.criarTabela());
                    GetEmpresaAsyncTask task = new GetEmpresaAsyncTask(getBaseContext(), edEmail.getText().toString());
                    task.execute();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Checa se o está cadastrado
                            if(controller.getEmpresa(edEmail.getText().toString()) == null){
                                edEmail.setError("");
                                edEmail.requestFocus();
                                validacao = false;
                                txtErro.setText("Email inválido ou não cadastrado");
                                txtErro.setVisibility(View.VISIBLE);
                            } else {

                                //Instancia a classe Empresa para guardar os dados
                                empresa = controller.getEmpresa(edEmail.getText().toString());

                                //Checa se a senha está igual a do cadastro
                                if (!edSenha.getText().toString().equals(empresa.getSenha())){
                                    edSenha.setError("Senha Incorreta");
                                    edSenha.requestFocus();
                                    validacao = false;
                                    txtErro.setText("Senha Incorreta");
                                    txtErro.setVisibility(View.VISIBLE);
                                } else {

                                    //Salva os dados da Empresa no Shared Preferences
                                    SharedPreferences sharedPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    editor.putBoolean("jaLogado", true);
                                    editor.putString("emailEmpresa", empresa.getEmail());
                                    UtilAplicativo.emailEmpresa = empresa.getEmail();
                                    editor.commit();

                                    //Inicia a tela principal
                                    Intent telaPrincipal = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(telaPrincipal);

                                    finish();
                                }
                            }
                        }
                    },1000);

                }
            }
        });

        imgVerSenhaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (senhaLogin == 1){
                    edSenha.setTransformationMethod(null);
                    senhaLogin = 0;
                } else {
                    edSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    senhaLogin = 1;
                }
            }
        });
    }
}
