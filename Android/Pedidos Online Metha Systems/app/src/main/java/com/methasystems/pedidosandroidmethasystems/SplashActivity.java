package com.methasystems.pedidosandroidmethasystems;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.methasystems.pedidosandroidmethasystems.controller.ClienteController;
import com.methasystems.pedidosandroidmethasystems.controller.EmpresaController;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.Cliente;
import com.methasystems.pedidosandroidmethasystems.model.Empresa;
import com.methasystems.pedidosandroidmethasystems.util.UtilAplicativo;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

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

                empresa.setCodigo(1);
                empresa.setCodigoPk(1);
                empresa.setNome("Metha Systems Consultoria Empresarial e Tecnologia da Informação");
                empresa.setFantasia("Metha Systems");
                empresa.setEndereco("Rua Dr Schmitz");
                empresa.setNumero("572");
                empresa.setBairro("Rui Barbosa");
                empresa.setCep("95780-000");
                empresa.setCidade("Montenegro");
                empresa.setUf("RS");
                empresa.setCnpj("07.397.635/0001-13");
                empresa.setInscricaoEstadual("078/0085795");
                empresa.setEmail("suporte@methasystems.com.br");
                empresa.setTelefone("36324061");
                empresa.setCelular("84630237");
                empresa.setUrlFtp("ftp.methasystems.com.br");
                empresa.setPortaFtp(21);
                empresa.setUsuarioFtp("master@methasystems.com.br");
                empresa.setSenhaFtp("Metha2018S1");
                empresa.setPastaRemssaFtp("Remessa");
                empresa.setPastaPedidosFtp("Pedidos");

                Cliente clienteTeste1 = new Cliente();
                Cliente clienteTeste2 = new Cliente();
                Cliente clienteTeste3 = new Cliente();

                clienteTeste1.setNome("A. DOS SANTOS BARBOSA");
                clienteTeste1.setCnpj("01.790.771/0001-92");
                clienteTeste1.setLoginEmpresa("suporte@methasystems.com.br");
                clienteTeste1.setCodGefims(586);
                clienteTeste1.setCodigoPk(10850);
                clienteTeste1.setGrupoEmpresa("07.397.635/0001-13");

                clienteTeste2.setNome("IRINEU JOAQUIN DA SILVA");
                clienteTeste2.setCpf("329.826.660-49");
                clienteTeste2.setLoginEmpresa("suporte@methasystems.com.br");
                clienteTeste2.setCodGefims(483);
                clienteTeste2.setCodigoPk(10863);
                clienteTeste2.setGrupoEmpresa("07.397.635/0001-13");

                clienteTeste3.setNome("ANGELICA QUADROS DE BORBA");
                clienteTeste3.setCnpj("09.527.150/0001-22");
                clienteTeste3.setLoginEmpresa("suporte@methasystems.com.br");
                clienteTeste3.setCodGefims(479);
                clienteTeste3.setCodigoPk(10851);
                clienteTeste3.setGrupoEmpresa("07.397.635/0001-13");

                EmpresaController empresaController = new EmpresaController(getBaseContext());
                ClienteController clienteController = new ClienteController(getBaseContext());

                try {
                    clienteController.salvar(clienteTeste1);
                    clienteController.salvar(clienteTeste2);
                    clienteController.salvar(clienteTeste3);
                    empresaController.salvar(empresa);

                } catch (Exception e){
                    Log.e("Erro ao Inserir no BD", e.getMessage());
                }*/


                final SharedPreferences sharedPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
                Boolean jaLogado = sharedPreferences.getBoolean("jaLogado", false);

                if (!jaLogado) {
                    /*Intent telaLogin = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(telaLogin);*/

                    //UtilAplicativo.emailUsuario = sharedPreferences.getString("emailEmpresa", null);
                    Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(telaPrincipal);

                    finish();
                } else {

                    UtilAplicativo.emailUsuario = sharedPreferences.getString("emailEmpresa", null);
                    Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(telaPrincipal);

                    finish();
                }

            }
        }, SPLASH_TIME_OUT);
    }
}