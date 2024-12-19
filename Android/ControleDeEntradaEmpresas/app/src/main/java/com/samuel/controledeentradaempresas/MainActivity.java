package com.samuel.controledeentradaempresas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.samuel.controledeentradaempresas.controller.EmpresaController;
import com.samuel.controledeentradaempresas.controller.ReservaController;
import com.samuel.controledeentradaempresas.dataModel.ReservaDataModel;
import com.samuel.controledeentradaempresas.model.Empresa;
import com.samuel.controledeentradaempresas.model.Reserva;
import com.samuel.controledeentradaempresas.ui.home.HomeFragment;
import com.samuel.controledeentradaempresas.util.SincronizarReservasAntigasAsyncTask;
import com.samuel.controledeentradaempresas.util.SincronizarReservasAsyncTask;
import com.samuel.controledeentradaempresas.util.UtilAplicativo;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private MenuItem item;
    private TextView txtCountReservas;

    public static FragmentManager fragmentManager;

    EmpresaController controller;
    ReservaController reservaController;

    Empresa empresa;

    String nomeProximo, qtdProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Sincronizando Dados", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                final SincronizarRezervas task = new SincronizarRezervas(navController);
                task.execute();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String count =  "Atualmente tem " + controller.getCountReservas() + " pessoas na fila";
                        //HomeFragment homeFragment = (HomeFragment)getSupportFragmentManager().findFragmentById(R.id.nav_home);

                        if (nomeProximo == null){
                            HomeFragment.updateTxtCountReservas(count);
                            HomeFragment.updateTxtProximaReserva("nenhuma reserva", "0");
                        } else {
                            HomeFragment.updateTxtCountReservas(count);
                            HomeFragment.updateTxtProximaReserva(nomeProximo, qtdProximo);
                        }

                    }
                }, 1000);
            }
        });

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_lista, R.id.nav_reserva,
                R.id.nav_cadastro, R.id.nav_antigas, R.id.nav_parametros, R.id.nav_dados)
                .setDrawerLayout(drawer)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //TODO: Segundo passo para implantar fragments.
        fragmentManager = getSupportFragmentManager();

        //TODO: Terceiro passo para implementar Fragments
        //fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                //it's possible to do more actions on several items, if there is a large amount of items I prefer switch(){case} instead of if()
                if (id == R.id.nav_home) {
                    //Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    getSupportActionBar().setTitle(empresa.getNome());
                } else if (id == R.id.nav_lista) {
                    //Toast.makeText(getApplicationContext(), "Reservas", Toast.LENGTH_SHORT).show();

                    final SincronizarRezervas task = new SincronizarRezervas(navController);
                    task.execute();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            navController.navigate(R.id.nav_lista);
                            //navController.getCurrentDestination();
                            //fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, new ListaFragment(), "listaFragment").commit();
                        }
                    }, 1000);

                } else if (id == R.id.nav_antigas) {
                    final SincronizarReservasAntigasAsyncTask task = new SincronizarReservasAntigasAsyncTask(getBaseContext(), empresa);
                    task.execute();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            navController.navigate(R.id.nav_antigas);
                            //navController.getCurrentDestination();
                            //fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, new ListaFragment(), "listaFragment").commit();
                        }
                    }, 1000);
                }
                //This is for maintaining the behavior of the Navigation view
                NavigationUI.onNavDestinationSelected(menuItem, navController);
                //This is for closing the drawer after acting on it
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        controller = new EmpresaController(getBaseContext());

        //Checa se o email da empresa ainda está cadastrado ou foi deletado por algum motivo
        //Ai te joga para a tela de login caso ele não encontre o email no arquivo do Shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
        String emailEmpresa = sharedPreferences.getString("emailEmpresa", null);

        if (emailEmpresa != null) {
            empresa = controller.getEmpresa(emailEmpresa);
            UtilAplicativo.emailEmpresa = emailEmpresa;

            //Define o titulo da barra de app como o nome da Empresa
            getSupportActionBar().setTitle(empresa.getNome());
        } else {

            //Limpa o shared preferences caso não exista email logado nele
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();

            Intent telaLogin = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(telaLogin);

            finish();
        }


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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_sair) {
            finish();
            return true;
        } else if (id == R.id.action_logoff) {

            //Instancia a Tela de Login para o usuário que pedir para deslogar do app
            Intent telaLogin = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(telaLogin);

            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    /*public void onNavigationItemSelected(MenuItem menuItem) {
        // Handle navigation view item clicks here.
        int id = menuItem.getItemId();

        //Obter ID para a opção selecionada no MENU DRAWER
        if (id == R.id.nav_lista) {

            finish();
        }
    }*/


    private class SincronizarRezervas extends AsyncTask<String, String, String> {

        //Cria um dialogo com o progresso de uma tarefa
        // TODO: Trocar por uma progressBar por o Dialog foi aposentado
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
        URL url = null; //URL para conexão
        Uri.Builder builder; //Objeto para passar parametros para o PHP

        public SincronizarRezervas(NavController navigationController) {

            nomeProximo = null;
            qtdProximo = null;
            NavController navController = navigationController;
            //navigationController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
            reservaController = new ReservaController(getBaseContext());
            //Instancia o URI
            this.builder = new Uri.Builder();

            //Adiciona um parâmetro no URI
            builder.appendQueryParameter("app", "ControleEntradas");
            builder.appendQueryParameter(ReservaDataModel.getIdEmpresa(), String.valueOf(empresa.getIdPk()));

        }


        @Override
        protected void onPreExecute() {

            try {
                progressDialog.setMessage("Sincronizando Dados, por favor aguarde...");
                progressDialog.setCancelable(false);
                progressDialog.show();

            } catch (Exception e) {
                Log.e("PreExecute", "Exceção no PréExecute" + e.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                cancel(true);
            }

        }

        @Override
        protected String doInBackground(String... strings) {

            //TODO: Sempre fazer os processos dentro de Try/Catch

            //Monta a URL do script PHP
            try {

                url = new URL(UtilAplicativo.URL_WEB_SERVICE + "APISincronizarReservas.php");

            } catch (MalformedURLException e) {
                Log.e("WebService", "MalformedURLException - " + e.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                cancel(true);

            } catch (Exception erro) {
                Log.e("WebService", "Exception - " + erro.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                cancel(true);
            }

            //Realiza a conexão HTTP
            try {

                connection = (HttpURLConnection) url.openConnection(); //Instancia o objeto e define a URL do web service
                connection.setConnectTimeout(UtilAplicativo.CONNECTION_TIMEOUT); //Define o tempo maximo de tentativa de conexão
                connection.setReadTimeout(UtilAplicativo.READ_TIMEOUT); //Define o tempo máximo de leitura de dados
                connection.setRequestMethod("POST"); //Define o método de entrada de dados no script php
                connection.setRequestProperty("charset", "utf-8");

                connection.setDoInput(true); //Define se vai haver entrada de dados
                connection.setDoOutput(true); //Define se vai haver retorno de dados

                // connection.connect();

                String query = builder.build().getEncodedQuery();

                OutputStream os = connection.getOutputStream();

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                writer.write(query);
                writer.flush();
                writer.close();
                os.close();

                connection.connect();

            } catch (IOException e) {
                Log.e("WebService", "IOException - " + e.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                cancel(true);
            }

            //Pega a resposta do script php
            try {

                int response_code = connection.getResponseCode(); //Pega a resposta do servidor
                //200 ok
                //403 forbidden
                //404 not found
                //500 internal error no server

                if (response_code == HttpURLConnection.HTTP_OK) {

                    /*TODO: ler a documentação sobre:
                                          InputStream
                                          OutputStream
                                          BufferedReader
                                          BufferedWriter
                                          URI
                                          HttpUrlConnection
                                          ProgressBar
                                          JSONArray
                                          Json*/

                    InputStream input = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                    StringBuilder result = new StringBuilder();
                    String line;

                    //Lê os resultados devolvidos pelo script e joga em uma string
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    return result.toString();

                } else {
                    return ("Erro na conexão");
                }
            } catch (IOException e) {
                Log.e("WebService", "IOException - " + e.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                cancel(true);
            } finally {
                connection.disconnect();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            try {

                reservaController.deletarTabela(ReservaDataModel.getTABELA());
                reservaController.criarTabela(ReservaDataModel.criarTabela());

                JSONArray jsonArray = new JSONArray(result);


                if (jsonArray.length() != 0) {

                    //Salvar os dados no banco de dados SQLite
                    reservaController.deletarTabela(ReservaDataModel.getTABELA());
                    reservaController.criarTabela(ReservaDataModel.criarTabela());

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        Reserva obj = new Reserva();

                        obj.setIdPk(jsonObject.getInt(ReservaDataModel.getId()));
                        obj.setIdCliente(jsonObject.getInt(ReservaDataModel.getIdCliente()));
                        obj.setNomeClliente(jsonObject.getString(ReservaDataModel.getNomeCliente()));
                        obj.setIdEmpresa(jsonObject.getInt(ReservaDataModel.getIdEmpresa()));
                        obj.setQtdPessoas(jsonObject.getInt(ReservaDataModel.getQtdPessoas()));
                        obj.setHoraReserva(Timestamp.valueOf(jsonObject.getString(ReservaDataModel.getHoraReserva())));
                        obj.setStatus(jsonObject.getString(ReservaDataModel.getStatus()));
                        obj.setTelefoneCliente(jsonObject.getString(ReservaDataModel.getTelefoneCliente()));

                        if (i == 0){
                            nomeProximo = jsonObject.getString(ReservaDataModel.getNomeCliente());
                            qtdProximo = jsonObject.getString(ReservaDataModel.getQtdPessoas());
                        }

                        reservaController.salvar(obj);

                    }

                } else {
                    reservaController.deletarTabela(ReservaDataModel.getTABELA());
                    reservaController.criarTabela(ReservaDataModel.criarTabela());
                    UtilAplicativo.showMessageToast(getBaseContext(), "Nenhum registro encontrado no momento...");
                }

            } catch (JSONException e) {

                Log.e("WebService", "JSONException - " + e.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                cancel(true);

            } finally {

                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }



                final NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);

                if (navController.getCurrentDestination().getId() == R.id.nav_lista){
                    navController.navigate(R.id.nav_lista);
                } else if (navController.getCurrentDestination().getId() == R.id.nav_antigas){
                    SincronizarReservasAntigasAsyncTask task = new SincronizarReservasAntigasAsyncTask(getApplicationContext(), empresa);
                    task.execute();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            navController.navigate(R.id.nav_antigas);
                        }
                    }, 1000);

                } else {
                    UtilAplicativo.showMessageToast(getBaseContext(), "Sincronização Realizada em Segundo Plano");
                }

                /*Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                Fragment fragmentLista = (ListaFragment)getSupportFragmentManager().findFragmentById(R.id.nav_lista);


                NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                navHostFragment.getChildFragmentManager().getFragments().get(0);


                String breakponit = "Só para ter um ponto de pausa";*/
               /* //Checa se a pessoa está com o fragment de resultados aberto e o atualiza caso ele esteja, caso ele não esteja

               NavHostFragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.);
                navHostFragment.getChildFragmentManager().getFragments().get(0);

                NavController navController = new NavController(getBaseContext());
                int idFragment = navController.getCurrentDestination().getId();

                //Cria a classe necessária para realizar o teste do fragment

                NavController navController = new NavController(getBaseContext());
                int idFragment = navController.getCurrentDestination().getId();
                ListaFragment test = (ListaFragment) getSupportFragmentManager().findFragmentByTag("listaReservas");
                //Se a pessoa ainda não abriu o fragment ele retorna nulo
                //Teste para saber se o fragment ja foi instanciado alguma vez

                if (test == null){
                    //Se não estiver, ele só avisa que a sincronização foi realizada em background
                    UtilAplicativo.showMessageToast(getBaseContext(), "Sincronização Realizada em Segundo Plano");
                } else {

                    //Testa se o fragment foi criado, e está visivel
                    if (test.isVisible() && test.isAdded() && test.getUserVisibleHint()) {
                        //Se estiver visivel ele atualiza a tela para o usuário
                        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, new ListaFragment(), "resultadoFinal").commit();
                        UtilAplicativo.showMessageToast(getBaseContext(), "Sincronização Realizada com Sucesso");
                    } else {
                        //Se não estiver, ele só avisa que a sincronização foi realizada em background
                        UtilAplicativo.showMessageToast(getBaseContext(), "Sincronização Realizada em Segundo Plano");
                    }

            }*/

        }

    }


    @Override
    protected void onCancelled() {
        UtilAplicativo.showMessageToast(getBaseContext(), "Erro ao sicronizar dados...");
    }

}

}