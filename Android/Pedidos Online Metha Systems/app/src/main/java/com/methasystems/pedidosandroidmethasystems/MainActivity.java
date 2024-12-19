package com.methasystems.pedidosandroidmethasystems;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.methasystems.pedidosandroidmethasystems.util.UtilAplicativo;
import com.methasystems.pedidosandroidmethasystems.util.cliente.SincronizarCliente;
import com.methasystems.pedidosandroidmethasystems.util.modalidadePagamento.SincronizarModalidadePagamento;
import com.methasystems.pedidosandroidmethasystems.util.produto.SincronizarProduto;
import com.methasystems.pedidosandroidmethasystems.util.produtoVenda.SincronizarProdutoVenda;
import com.methasystems.pedidosandroidmethasystems.util.vencimento.SincronizarVencimento;
import com.methasystems.pedidosandroidmethasystems.util.venda.SincronizarVenda;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    private AppBarConfiguration mAppBarConfiguration;
    private Context context;
    RelativeLayout relativeLayout;
    private Handler handler = new Handler();
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        ProgressBar progressBar = findViewById(R.id.progress_bar_main);
        relativeLayout = findViewById(R.id.relative_app_main);

        fab.setOnClickListener(view -> {
            /*Snackbar.make(view, "Sincronizando Dados", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();*/

            AtualizarDados atualizarDados = new AtualizarDados();
            atualizarDados.start();

        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_vendas, R.id.nav_cliente, R.id.nav_produtos, R.id.nav_list_vendas)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void mostrarRelativeLayout() {
        relativeLayout.setVisibility(View.VISIBLE);
    }

    private void esconderRelativeLayout() {
        relativeLayout.setVisibility(View.GONE);
    }

    private class AtualizarDados extends Thread {

        public AtualizarDados() {

        }

        @Override
        public void run() {
            if (UtilAplicativo.isNetworkAvailable(context)){
                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            progressDialog = new ProgressDialog(context);

                            try {
                                progressDialog.setMessage("Atualizando Dados, por favor aguarde...");
                                progressDialog.setCancelable(false);
                                progressDialog.show();
                            } catch (Exception e) {
                                Log.e("PreExecute", "Exceção no PréExecute: " + e.getMessage());

                                //Cancela o Processo e avisa o usuário do erro
                                if (progressDialog != null && progressDialog.isShowing()) {
                                    progressDialog.dismiss();
                                }
                                UtilAplicativo.showMessageToast(context, "Erro ao atualizar dados...");
                                interrupt();
                            }
                        }
                    });

                    try {

                        SincronizarCliente sincronizarCliente = new SincronizarCliente(context, getMainLooper());
                        sincronizarCliente.start();
                        sincronizarCliente.join();

                        SincronizarProduto sincronizarProduto = new SincronizarProduto(context);
                        sincronizarProduto.start();
                        sincronizarProduto.join();

                        SincronizarModalidadePagamento sincronizarModalidadePagamento = new SincronizarModalidadePagamento(context);
                        sincronizarModalidadePagamento.start();
                        sincronizarModalidadePagamento.join();

                        SincronizarVenda sincronizarVenda = new SincronizarVenda(context);
                        sincronizarVenda.start();
                        sincronizarVenda.join();

                        SincronizarProdutoVenda sincronizarProdutoVenda = new SincronizarProdutoVenda(context);
                        sincronizarProdutoVenda.start();
                        sincronizarProdutoVenda.join();

                        SincronizarVencimento sincronizarVencimento = new SincronizarVencimento(context);
                        sincronizarVencimento.start();
                        sincronizarVencimento.join();

                    } catch (Exception e) {
                        Log.e("Sincronização de Dados", "Exceção no Execute: " + e.getMessage());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Cancela o Processo e avisa o usuário do erro
                                if (progressDialog != null && progressDialog.isShowing()) {
                                    progressDialog.dismiss();
                                }
                            }
                        });
                        interrupt();
                    }
                } catch (Exception e) {
                    Log.e("Atualizar Dados", "Exceção ao Atualizar Dados: " + e.getMessage());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //Cancela o Processo e avisa o usuário do erro
                            if (progressDialog != null && progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }

                        }
                    });
                    interrupt();
                } finally {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //Cancela o Processo e avisa o usuário do erro
                            if (progressDialog != null && progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }

                            final NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                            if  (navController.getCurrentDestination().getId() == R.id.nav_cliente) {
                                navController.navigate(R.id.nav_cliente);
                            } else if (navController.getCurrentDestination().getId() == R.id.nav_produtos){
                                navController.navigate(R.id.nav_produtos);
                            }

                        }
                    });

                }
            } else{
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        UtilAplicativo.showMessageToast(context, "É necessario estar conectado à internet para atualizar os dados");
                    }
                });
            }


        }
    }

}