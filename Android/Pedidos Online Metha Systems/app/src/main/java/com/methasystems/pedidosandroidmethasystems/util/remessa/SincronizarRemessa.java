package com.methasystems.pedidosandroidmethasystems.util.remessa;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.methasystems.pedidosandroidmethasystems.controller.RemessaController;
import com.methasystems.pedidosandroidmethasystems.dataModel.RemessaDataModel;
import com.methasystems.pedidosandroidmethasystems.model.Remessa;
import com.methasystems.pedidosandroidmethasystems.model.Empresa;
import com.methasystems.pedidosandroidmethasystems.util.UtilAplicativo;

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
import java.sql.Date;

public class SincronizarRemessa extends Thread {

    private HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
    private URL url = null; //URL para conexão
    private Uri.Builder builder; //Objeto para passar parametros para o PHP
    private Context context;
    private Empresa empresa;
    private RemessaController RemessaController;
    String result;

    public SincronizarRemessa(Context context) {

        //Instancia o URI
        this.builder = new Uri.Builder();
        this.context = context;
        this.empresa = empresa;
        RemessaController = new RemessaController(context);

        //Adiciona um parâmetro no URI
        builder.appendQueryParameter("app", "PedidosOnline");
        builder.appendQueryParameter(RemessaDataModel.getCodigoPk(), UtilAplicativo.emailUsuario);

    }

    @Override
    public void run() {
        result = doInBackground();
        onPostExecute(result);
    }

    protected String doInBackground() {

        //Monta a URL do script PHP
        try {

            url = new URL(UtilAplicativo.URL_WEB_SERVICE + "APISincronizarRemessas.php");

        } catch (MalformedURLException e) {
            Log.e("WebService", "MalformedURLException - " + e.getMessage());

            interrupt();

        } catch (Exception erro) {
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

        } catch (IOException e) {
            Log.e("WebService", "IOException - " + e.getMessage());

            interrupt();
        }

        //Pega a resposta do script php
        try {

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
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                return result.toString();

            } else {
                return ("Erro na conexão");
            }
        } catch (IOException e) {
            Log.e("WebService", "IOException - " + e.getMessage());

            interrupt();
        } finally {
            connection.disconnect();
        }

        return null;
    }

    protected void onPostExecute(String result) {

        try {

            RemessaController.deletarTabela(RemessaDataModel.getTABELA());
            RemessaController.criarTabela(RemessaDataModel.criarTabela());

            JSONArray jsonArray = new JSONArray(result);


            if (jsonArray.length() != 0) {

                //Salvar os dados no banco de dados SQLite


                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    Remessa obj = new Remessa();

                    obj.setCodigoPk(jsonObject.getInt(RemessaDataModel.getCodigo()));
                    obj.setCnpj(jsonObject.getString(RemessaDataModel.getCnpj()));
                    obj.setNroRemessa(jsonObject.getInt(RemessaDataModel.getNroRemessa()));
                    obj.setDataRemessa(Date.valueOf(jsonObject.getString(RemessaDataModel.getDataRemessa())));
                    obj.setLoginEmpresa(jsonObject.getString(RemessaDataModel.getLoginEmpresa()));
                    obj.setGrupoEmpresa(jsonObject.getString(RemessaDataModel.getGrupoEmpresa()));

                    RemessaController.salvar(obj);

                }

            } else {
                interrupt();
            }

        } catch (JSONException e) {

            Log.e("WebService", "JSONException - " + e.getMessage());

            interrupt();

        }
    }
}