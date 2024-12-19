package com.methasystems.pedidosandroidmethasystems.util.empresa;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.methasystems.pedidosandroidmethasystems.dataModel.EmpresaDataModel;
import com.methasystems.pedidosandroidmethasystems.model.Empresa;
import com.methasystems.pedidosandroidmethasystems.util.UtilAplicativo;

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

public class AlterarEmpresa extends Thread {

    HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
    URL url = null; //URL para conexão
    Uri.Builder builder;//Objeto para passar parametros para o PHP
    String result;

    Context context;

    public AlterarEmpresa(Empresa obj, Context context){
        //Instancia o URI
        this.builder = new Uri.Builder();

        //Instancia o Context
        this.context = context;

        //Adiciona um parâmetro no URI
        builder.appendQueryParameter("app", "PedidosOnline");

        //Passa os dados para o WebService como
        builder.appendQueryParameter(EmpresaDataModel.getCodigoPk(), String.valueOf(obj.getCodigoPk()));
        builder.appendQueryParameter(EmpresaDataModel.getNome(), obj.getNome());
        builder.appendQueryParameter(EmpresaDataModel.getFantasia(), obj.getFantasia());
        builder.appendQueryParameter(EmpresaDataModel.getEndereco(), obj.getEndereco());
        builder.appendQueryParameter(EmpresaDataModel.getNumero(), obj.getNumero());
        builder.appendQueryParameter(EmpresaDataModel.getComplemento(), obj.getComplemento());
        builder.appendQueryParameter(EmpresaDataModel.getBairro(), obj.getBairro());
        builder.appendQueryParameter(EmpresaDataModel.getCep(), obj.getCep());
        builder.appendQueryParameter(EmpresaDataModel.getCidade(), obj.getCidade());
        builder.appendQueryParameter(EmpresaDataModel.getUf(), obj.getUf());
        builder.appendQueryParameter(EmpresaDataModel.getCnpj(), obj.getCnpj());
        builder.appendQueryParameter(EmpresaDataModel.getInscricaoEstadual(), obj.getInscricaoEstadual());
        builder.appendQueryParameter(EmpresaDataModel.getCpf(), obj.getCpf());
        builder.appendQueryParameter(EmpresaDataModel.getEmail(), obj.getEmail());
        builder.appendQueryParameter(EmpresaDataModel.getTelefone(), obj.getTelefone());
        builder.appendQueryParameter(EmpresaDataModel.getCelular(), obj.getCelular());
        builder.appendQueryParameter(EmpresaDataModel.getUrlFtp(), obj.getUrlFtp());
        builder.appendQueryParameter(EmpresaDataModel.getPortaFtp(), String.valueOf(obj.getPortaFtp()));
        builder.appendQueryParameter(EmpresaDataModel.getSenhaFtp(), obj.getSenhaFtp());
        builder.appendQueryParameter(EmpresaDataModel.getPastaRemssaFtp(), obj.getPastaRemssaFtp());
        builder.appendQueryParameter(EmpresaDataModel.getPastaPedidosFtp(), obj.getPastaPedidosFtp());

    }

    @Override
    public void run() {
        result = doInBackground();
    }

    protected String doInBackground() {

        //Monta a URL do script PHP
        try{

            url = new URL(UtilAplicativo.URL_WEB_SERVICE + "APIAlterarDadosEmpresa.php");

        } catch (MalformedURLException e){
            Log.e("WebService", "MalformedURLException - " + e.getMessage());

            interrupt();

        } catch (Exception erro){
            Log.e("WebService", "Exception - " + erro.getMessage());

            interrupt();
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

            interrupt();
        }

        //Pega a resposta do script php
        try{

            int response_code = connection.getResponseCode(); //Pega a resposta do servidor
            //200 ok
            //403 forbidden
            //404 not found
            //500 internal error no server

            if (response_code == HttpURLConnection.HTTP_OK) {

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

            interrupt();
        } finally {
            connection.disconnect();
        }

        return null;
    }

}
