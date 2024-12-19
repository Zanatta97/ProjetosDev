package com.methasystems.pedidosandroidmethasystems.util.cliente;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;
import com.methasystems.pedidosandroidmethasystems.R;
import com.methasystems.pedidosandroidmethasystems.controller.ClienteController;
import com.methasystems.pedidosandroidmethasystems.dataModel.ClienteDataModel;
import com.methasystems.pedidosandroidmethasystems.model.Empresa;
import com.methasystems.pedidosandroidmethasystems.model.Cliente;
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
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SincronizarCliente extends Thread {

    private HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
    private URL url = null; //URL para conexão
    private Uri.Builder builder; //Objeto para passar parametros para o PHP
    private Context context;
    private Empresa empresa;
    private ClienteController ClienteController;
    String result;
    private ProgressDialog progressDialog;
    Looper looper;

    public SincronizarCliente(Context context, Looper looper) {

        //Instancia o URI
        this.builder = new Uri.Builder();
        this.context = context;
        this.empresa = empresa;
        ClienteController = new ClienteController(context);
        this.looper = looper;

        //Adiciona um parâmetro no URI
        builder.appendQueryParameter("app", "PedidosOnline");
        builder.appendQueryParameter(ClienteDataModel.getLoginEmpresa(), UtilAplicativo.emailUsuario);

    }

    @Override
    public void run() {

        /*Handler handler = new Handler(looper);

        handler.post(new Runnable() {
            @Override
            public void run() {
                progressDialog = new ProgressDialog(context);

                try {
                    progressDialog.setMessage("Sincronizando Clientes, por favor aguarde...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    result = doInBackground();
                    onPostExecute(result);

                    //Cancela o Processo e avisa o usuário do erro
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    UtilAplicativo.showMessageToast(context, "Dados alterados");


                } catch (Exception e) {
                    Log.e("PreExecute", "Exceção no PréExecute" + e.getMessage());

                    //Cancela o Processo e avisa o usuário do erro
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    UtilAplicativo.showMessageToast(context, "Erro ao alterar dados..1.");
                    interrupt();
                }
            }
        });*/

        result = doInBackground();
        onPostExecute(result);

    }

    protected String doInBackground() {

        //Monta a URL do script PHP
        try {

            url = new URL(UtilAplicativo.URL_WEB_SERVICE + "APISincronizarClientes.php");

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

            ClienteController.deletarTabela(ClienteDataModel.getTABELA());
            ClienteController.criarTabela(ClienteDataModel.criarTabela());

            JSONArray jsonArray = new JSONArray(result);


            if (jsonArray.length() != 0) {

                //Salvar os dados no banco de dados SQLite


                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    Cliente obj = new Cliente();

                    obj.setCodigoPk(jsonObject.getInt(ClienteDataModel.getCodigo()));
                    obj.setNome(jsonObject.getString(ClienteDataModel.getNome()));
                    obj.setCnpj(jsonObject.getString(ClienteDataModel.getCnpj()));
                    obj.setInscricaoEstadual(jsonObject.getString(ClienteDataModel.getInscricaoEstadual()));
                    obj.setCpf(jsonObject.getString(ClienteDataModel.getCpf()));
                    obj.setLoginEmpresa(jsonObject.getString(ClienteDataModel.getLoginEmpresa()));
                    obj.setCodGefims(jsonObject.getInt(ClienteDataModel.getCodGefims()));
                    obj.setGrupoEmpresa(jsonObject.getString(ClienteDataModel.getGrupoEmpresa()));

                    ClienteController.salvar(obj);

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