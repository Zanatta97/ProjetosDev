package com.samuel.controledeentradaempresas.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.samuel.controledeentradaempresas.dataModel.ClienteDataModel;
import com.samuel.controledeentradaempresas.dataModel.EmpresaDataModel;
import com.samuel.controledeentradaempresas.model.Cliente;
import com.samuel.controledeentradaempresas.model.Empresa;

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

public class IncluirEmpresaAsyncTask extends AsyncTask<String, String, String> {

    ProgressDialog progressDialog;
    HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
    URL url = null; //URL para conexão
    Uri.Builder builder; //Objeto para passar parametros para o PHP

    Context context;

    public IncluirEmpresaAsyncTask(Empresa obj, Context context){

        //Instancia o URI
        this.builder = new Uri.Builder();

        //Instancia o Context
        this.context = context;

        //Adiciona um parâmetro no URI
        builder.appendQueryParameter("app", "ControleEntradas");

        //Passa os dados para o WebService como parâmetros
        //builder.appendQueryParameter(EmpresaDataModel.getIdPk(), String.valueOf(obj.getIdPk()));
        builder.appendQueryParameter(EmpresaDataModel.getNome(), obj.getNome());
        builder.appendQueryParameter(EmpresaDataModel.getCnpj(), obj.getCnpj());
        builder.appendQueryParameter(EmpresaDataModel.getEndereco(), obj.getEndereco());
        builder.appendQueryParameter(EmpresaDataModel.getNumero(), String.valueOf(obj.getNumero()));
        builder.appendQueryParameter(EmpresaDataModel.getComplemento(), obj.getComplemento());
        builder.appendQueryParameter(EmpresaDataModel.getBairro(), obj.getBairro());
        builder.appendQueryParameter(EmpresaDataModel.getCidade(), obj.getCidade());
        builder.appendQueryParameter(EmpresaDataModel.getUf(), obj.getUf());
        builder.appendQueryParameter(EmpresaDataModel.getCep(), obj.getCep());
        builder.appendQueryParameter(EmpresaDataModel.getDescricao(), obj.getDescricao());

        builder.appendQueryParameter(EmpresaDataModel.getHoraAberturaSegunda(), String.valueOf(obj.getHoraAberturaSegunda()));
        builder.appendQueryParameter(EmpresaDataModel.getHoraFechamentoSegunda(), String.valueOf(obj.getHoraFechamentoSegunda()));

        builder.appendQueryParameter(EmpresaDataModel.getHoraAberturaTerca(), String.valueOf(obj.getHoraAberturaTerca()));
        builder.appendQueryParameter(EmpresaDataModel.getHoraFechamentoTerca(), String.valueOf(obj.getHoraFechamentoTerca()));

        builder.appendQueryParameter(EmpresaDataModel.getHoraAberturaQuarta(), String.valueOf(obj.getHoraAberturaQuarta()));
        builder.appendQueryParameter(EmpresaDataModel.getHoraFechamentoQuarta(), String.valueOf(obj.getHoraFechamentoQuarta()));

        builder.appendQueryParameter(EmpresaDataModel.getHoraAberturaQuinta(), String.valueOf(obj.getHoraAberturaQuinta()));
        builder.appendQueryParameter(EmpresaDataModel.getHoraFechamentoQuinta(), String.valueOf(obj.getHoraFechamentoQuinta()));

        builder.appendQueryParameter(EmpresaDataModel.getHoraAberturaSexta(), String.valueOf(obj.getHoraAberturaSexta()));
        builder.appendQueryParameter(EmpresaDataModel.getHoraFechamentoSexta(), String.valueOf(obj.getHoraFechamentoSexta()));

        builder.appendQueryParameter(EmpresaDataModel.getHoraAberturaSabado(), String.valueOf(obj.getHoraAberturaSabado()));
        builder.appendQueryParameter(EmpresaDataModel.getHoraFechamentoSabado(), String.valueOf(obj.getHoraFechamentoSabado()));

        builder.appendQueryParameter(EmpresaDataModel.getHoraAberturaDomingo(), String.valueOf(obj.getHoraAberturaDomingo()));
        builder.appendQueryParameter(EmpresaDataModel.getHoraFechamentoDomingo(), String.valueOf(obj.getHoraFechamentoDomingo()));

        builder.appendQueryParameter(EmpresaDataModel.getTokenFirebase(), obj.getTokenFirebase());
        builder.appendQueryParameter(EmpresaDataModel.getEmail(), obj.getEmail());
        builder.appendQueryParameter(EmpresaDataModel.getSenha(), obj.getSenha());


    }

    @Override
    protected void onPreExecute() {

        progressDialog = new ProgressDialog(context);

        try {
            progressDialog.setMessage("Inserindo Dados, por favor aguarde...");
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

            url = new URL(UtilAplicativo.URL_WEB_SERVICE + "APIIncluirDadosEmpresa.php");

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
        UtilAplicativo.showMessageToast(context,"Erro ao incluir dados...");
    }
}
