package com.example.mediaescolarmvc.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.mediaescolarmvc.R;
import com.example.mediaescolarmvc.controller.MediaEscolarController;
import com.example.mediaescolarmvc.dataModel.MediaEscolarDataModel;
import com.example.mediaescolarmvc.fragments.BimestreAFragment;
import com.example.mediaescolarmvc.fragments.BimestreBFragment;
import com.example.mediaescolarmvc.fragments.BimestreCFragment;
import com.example.mediaescolarmvc.fragments.BimestreDFragment;
import com.example.mediaescolarmvc.fragments.ModeloFragment;
import com.example.mediaescolarmvc.fragments.ResultadoFinalFragment;
import com.example.mediaescolarmvc.model.MediaEscolar;
import com.example.mediaescolarmvc.util.UtilMediaEscolar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;

    MediaEscolarController controller;
    Context context;

    Menu menu;
    MenuItem nav_lancamento;
    MenuItem nav_resultado;
    boolean sincSucesso = false;


    //TODO: Primeiro passo para implantar fragments.
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = getBaseContext();
        controller = new MediaEscolarController(context);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                /*Snackbar.make(view, "Sincronização do sistema...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                //TODO: Criar classe SincronizarSistema AsyncTask no final do código dessa classe

                final SincronizarSistema task = new SincronizarSistema();
                task.execute();

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Manipular objetos de Menu
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //TODO: Segundo passo para implantar fragments.
        fragmentManager = getSupportFragmentManager();

        //TODO: Terceiro passo para implementar Fragments
        fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //Obter ID para a opção selecionada no MENU DRAWER
        if (id == R.id.nav_bimestre_a) {

            setTitle("1º Bimestre");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreAFragment()).commit();

        } else if (id == R.id.nav_bimestre_b) {

            setTitle("2º Bimestre");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreBFragment()).commit();

        } else if (id == R.id.nav_bimestre_c) {

            setTitle("3º Bimestre");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreCFragment()).commit();

        } else if (id == R.id.nav_bimestre_d) {

            setTitle("4º Bimestre");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreDFragment()).commit();

        } else if (id == R.id.nav_resultado) {

            setTitle("Resultado Final");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ResultadoFinalFragment(), "resultadoFinal").commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private class SincronizarSistema extends AsyncTask<String, String, String> {

        //Cria um dialogo com o progresso de uma tarefa
        // TODO: Trocar por uma progressBar por o Dialog foi aposentado
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
        URL url = null; //URL para conexão
        Uri.Builder builder; //Objeto para passar parametros para o PHP

        public SincronizarSistema(){

            //Instancia o URI
            this.builder = new Uri.Builder();

            //Adiciona um parâmetro no URI
            builder.appendQueryParameter("app", "MediaEscolar");

        }

        @Override
        protected void onPreExecute(){

            try {
                progressDialog.setMessage("Sincronizando Dados, por favor aguarde...");
                progressDialog.setCancelable(false);
                progressDialog.show();

            }catch (Exception e){
                Log.e("PreExecute", "Exceção no PréExecute" + e.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                cancel(true);
            }

        }

        @Override
        protected String doInBackground(String... strings) {

            //TODO: Sempre fazer os processos dentro de Try/Catch

            //Monta a URL do script PHP
            try{

                url = new URL(UtilMediaEscolar.URL_WEB_SERVICE + "APISincronizarSistema.php");

            } catch (MalformedURLException e){
                Log.e("WebService", "MalformedURLException - " + e.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                cancel(true);

            } catch (Exception erro){
                Log.e("WebService", "Exception - " + erro.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                cancel(true);
            }

            //Realiza a conexão HTTP
            try {

                connection = (HttpURLConnection) url.openConnection(); //Instancia o objeto e define a URL do web service
                connection.setConnectTimeout(UtilMediaEscolar.CONNECTION_TIMEOUT); //Define o tempo maximo de tentativa de conexão
                connection.setReadTimeout(UtilMediaEscolar.READ_TIMEOUT); //Define o tempo máximo de leitura de dados
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

            }catch (IOException e){
                Log.e("WebService", "IOException - " + e.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                cancel(true);
            }

            //Pega a resposta do script php
            try{

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
                    while ((line = reader.readLine()) != null){
                        result.append(line);
                    }

                    return result.toString();

                } else {
                    return ("Erro na conexão");
                }
            }catch (IOException e){
                Log.e("WebService", "IOException - " + e.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                cancel(true);
            } finally {
                connection.disconnect();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result){

            try {

                JSONArray jsonArray = new JSONArray(result);

                if (jsonArray.length() != 0){

                    //Salvar os dados no banco de dados SQLite

                    controller.deletarTabela(MediaEscolarDataModel.getTABELA());
                    controller.criarTabela(MediaEscolarDataModel.criarTabela());

                    for (int i=0; i < jsonArray.length(); i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        MediaEscolar obj = new MediaEscolar();

                        obj.setIdPK(jsonObject.getInt(MediaEscolarDataModel.getId()));
                        obj.setMateria(jsonObject.getString(MediaEscolarDataModel.getMateria()));
                        obj.setBimestre(jsonObject.getString(MediaEscolarDataModel.getBimestre()));
                        obj.setNotaProva(jsonObject.getDouble(MediaEscolarDataModel.getNotaProva()));
                        obj.setNotaTrabalho(jsonObject.getDouble(MediaEscolarDataModel.getNotaTrabalho()));
                        obj.setMediaFinal(jsonObject.getDouble(MediaEscolarDataModel.getMediaFinal()));
                        obj.setSituacao(jsonObject.getString(MediaEscolarDataModel.getSituacao()));

                        controller.salvar(obj);

                    }

                } else {
                    UtilMediaEscolar.showMessageToast(context, "Nenhum registro encontrado no momento...");
                }

            } catch (JSONException e){

                Log.e("WebService", "JSONException - " + e.getMessage());

                //Cancela o Processo e avisa o usuário do erro
                if (progressDialog != null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                cancel(true);

            } finally {

                if (progressDialog != null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }

                //Checa se a pessoa está com o fragment de resultados aberto e o atualiza caso ele esteja, caso ele não esteja

                //Cria a classe necessária para realizar o teste do fragment
                ResultadoFinalFragment test = (ResultadoFinalFragment) getSupportFragmentManager().findFragmentByTag("resultadoFinal");

                //Se a pessoa ainda não abriu o fragment ele retorna nulo
                //Teste para saber se o fragment ja foi instanciado alguma vez
                if (test == null){
                    //Se não estiver, ele só avisa que a sincronização foi realizada em background
                    UtilMediaEscolar.showMessageToast(context, "Sincronização Realizada em Segundo Plano");
                } else {

                    //Testa se o fragment foi criado, e está visivel
                    if (test.isVisible() && test.isAdded() && test.getUserVisibleHint()) {
                        //Se estiver visivel ele atualiza a tela para o usuário
                        fragmentManager.beginTransaction().replace(R.id.content_fragment, new ResultadoFinalFragment(), "resultadoFinal").commit();
                        UtilMediaEscolar.showMessageToast(context, "Sincronização Realizada com Sucesso");
                    } else {
                        //Se não estiver, ele só avisa que a sincronização foi realizada em background
                        UtilMediaEscolar.showMessageToast(context, "Sincronização Realizada em Segundo Plano");
                    }

                }

            }

        }

        @Override
        protected void onCancelled(){
            UtilMediaEscolar.showMessageToast(context,"Erro ao sicronizar dados...");
        }

    }

}

