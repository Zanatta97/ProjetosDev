package com.samuel.controledeentradaempresas.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.samuel.controledeentradaempresas.controller.ReservaController;
import com.samuel.controledeentradaempresas.dataModel.ReservaDataModel;
import com.samuel.controledeentradaempresas.model.Empresa;
import com.samuel.controledeentradaempresas.model.Reserva;

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

public class SincronizarReservasAntigasAsyncTask extends AsyncTask<String, String, String> {

    //Cria um dialogo com o progresso de uma tarefa
    // TODO: Trocar por uma progressBar por o Dialog foi aposentado
    private ProgressDialog progressDialog;
    private HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
    private URL url = null; //URL para conexão
    private Uri.Builder builder; //Objeto para passar parametros para o PHP
    private Context context;
    private Empresa empresa;
    private ReservaController reservaController;

    public SincronizarReservasAntigasAsyncTask(Context context, Empresa empresa) {

        //Instancia o URI
        this.builder = new Uri.Builder();
        this.context = context;
        this.empresa = empresa;
        reservaController = new ReservaController(context);

        //Adiciona um parâmetro no URI
        builder.appendQueryParameter("app", "ControleEntradas");
        builder.appendQueryParameter(ReservaDataModel.getIdEmpresa(), String.valueOf(empresa.getIdPk()));

    }


    @Override
    protected void onPreExecute() {
        /*progressDialog = new ProgressDialog(context);

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
        }*/

    }

    @Override
    protected String doInBackground(String... strings) {

        //TODO: Sempre fazer os processos dentro de Try/Catch

        //Monta a URL do script PHP
        try {

            url = new URL(UtilAplicativo.URL_WEB_SERVICE + "APISincronizarReservasCanceladas.php");

        } catch (MalformedURLException e) {
            Log.e("WebService", "MalformedURLException - " + e.getMessage());

            /*//Cancela o Processo e avisa o usuário do erro
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }*/
            cancel(true);

        } catch (Exception erro) {
            Log.e("WebService", "Exception - " + erro.getMessage());

            /*//Cancela o Processo e avisa o usuário do erro
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }*/
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

            /*//Cancela o Processo e avisa o usuário do erro
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }*/
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

            /*//Cancela o Processo e avisa o usuário do erro
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }*/
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

                    reservaController.salvar(obj);

                }

            } else {
                UtilAplicativo.showMessageToast(context, "Nenhum registro encontrado no momento...");
            }

        } catch (JSONException e) {

            Log.e("WebService", "JSONException - " + e.getMessage());

            /*//Cancela o Processo e avisa o usuário do erro
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }*/
            cancel(true);

        } finally {

            /*if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }*/
        }
    }
}