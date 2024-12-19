package com.example.mediaescolarmvc.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.example.mediaescolarmvc.dataModel.MediaEscolarDataModel;
import com.example.mediaescolarmvc.model.MediaEscolar;

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

public class AlterarAsyncTask extends AsyncTask<String, String, String> {

    ProgressDialog progressDialog;
    HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
    URL url = null; //URL para conexão
    Uri.Builder builder;//Objeto para passar parametros para o PHP

    Context context;

    public AlterarAsyncTask(MediaEscolar obj, Context context){
        //Instancia o URI
        this.builder = new Uri.Builder();

        //Instancia o Context
        this.context = context;

        //Adiciona um parâmetro no URI
        builder.appendQueryParameter("app", "MediaEscolar");

        //Passa os dados para o WebService como parâmetros
        builder.appendQueryParameter(MediaEscolarDataModel.getIdPK(), String.valueOf(obj.getIdPK()));
        builder.appendQueryParameter(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        builder.appendQueryParameter(MediaEscolarDataModel.getMateria(), obj.getMateria());
        builder.appendQueryParameter(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        builder.appendQueryParameter(MediaEscolarDataModel.getMediaFinal(), String.valueOf(obj.getMediaFinal()));
        builder.appendQueryParameter(MediaEscolarDataModel.getNotaTrabalho(), String.valueOf(obj.getNotaTrabalho()));
        builder.appendQueryParameter(MediaEscolarDataModel.getNotaProva(), String.valueOf(obj.getNotaProva()));
    }

    @Override
    protected void onPreExecute(){
        progressDialog = new ProgressDialog(context);

        try {
            progressDialog.setMessage("Salvando Dados, por favor aguarde...");
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

            url = new URL(UtilMediaEscolar.URL_WEB_SERVICE + "APIAlterarDados.php");

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
        if (progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onCancelled(){
        UtilMediaEscolar.showMessageToast(context,"Erro ao alterar dados...");
    }
}
