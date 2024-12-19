package com.example.controleentradacliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.controleentradacliente.dataSource.DataSource;
import com.example.controleentradacliente.util.UtilAplicativo;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;
    public static final int APP_PERMISSIONS_REQUEST_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        DataSource ds = new DataSource(getApplicationContext());

        //Verifica se o google play services está instalado
        /*if(AplicativoController.verificarGooglePlayServices(SplashActivity.this)){
            apresentarSplash();
        } else {
            UtilAplicativo.showMessageToast(getApplicationContext(), "Google Play Services não Configurado");
        }*/

        apresentarSplash();
    }

    private void apresentarSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                /*Empresa empresa = new Empresa();

                empresa.setEmail("sa.zanatta@hotmail.com");
                empresa.setSenha("r2d2c3po");
                empresa.setNome("Teste Samuel");
                empresa.setCnpj("07.397.635/0001-13");
                empresa.setEndereco("Rua João Pessoa");
                empresa.setNumero(1779);
                empresa.setComplemento("Apto. 404");
                empresa.setBairro("Centro");
                empresa.setCidade("Montenegro");
                empresa.setUf("RS");
                empresa.setCep("95780-000");
                empresa.setDescricao("Empresa para teste do app");

                EmpresaController empresaController = new EmpresaController(getBaseContext());

                try {

                    empresaController.salvar(empresa);

                } catch (Exception e){
                    Log.e("Erro ao Inserir no BD", e.getMessage());
                }*/
                final SharedPreferences sharedPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
                Boolean jaLogado = sharedPreferences.getBoolean("jaLogado", false);

                if (!jaLogado) {
                    Intent telaLogin = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(telaLogin);

                    finish();
                } else {

                    UtilAplicativo.emailCliente = sharedPreferences.getString("emailCliente", null);
                    Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(telaPrincipal);

                    finish();
                }

            }
        }, SPLASH_TIME_OUT);
    }
}
