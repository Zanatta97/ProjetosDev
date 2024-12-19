package com.methasystems.pedidosandroidmethasystems.util.empresa;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.methasystems.pedidosandroidmethasystems.controller.EmpresaController;
import com.methasystems.pedidosandroidmethasystems.dataModel.EmpresaDataModel;
import com.methasystems.pedidosandroidmethasystems.model.Empresa;
//import com.methasystems.pedidosandroidmethasystems.model.Empresa;
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

public class SincronizarEmpresa extends Thread {

    private HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
    private URL url = null; //URL para conexão
    private Uri.Builder builder; //Objeto para passar parametros para o PHP
    private Context context;
    private Empresa empresa;
    private EmpresaController EmpresaController;
    String result;

    public SincronizarEmpresa(Context context) {

        //Instancia o URI
        this.builder = new Uri.Builder();
        this.context = context;
        this.empresa = empresa;
        EmpresaController = new EmpresaController(context);

        //Adiciona um parâmetro no URI
        builder.appendQueryParameter("app", "PedidosOnline");
        builder.appendQueryParameter(EmpresaDataModel.getCodigoPk(), UtilAplicativo.emailUsuario);

    }

    @Override
    public void run() {
        result = doInBackground();
        onPostExecute(result);
    }

    protected String doInBackground() {

        //TODO: Sempre fazer os processos dentro de Try/Catch

        //Monta a URL do script PHP
        try {

            url = new URL(UtilAplicativo.URL_WEB_SERVICE + "APISincronizarEmpresas.php");

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

            interrupt();
        } finally {
            connection.disconnect();
        }

        return null;
    }

    protected void onPostExecute(String result) {

        try {

            EmpresaController.deletarTabela(EmpresaDataModel.getTABELA());
            EmpresaController.criarTabela(EmpresaDataModel.criarTabela());

            JSONArray jsonArray = new JSONArray(result);


            if (jsonArray.length() != 0) {

                //Salvar os dados no banco de dados SQLite


                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    Empresa obj = new Empresa();

                    obj.setCodigoPk(jsonObject.getInt(EmpresaDataModel.getCodigo()));
                    obj.setNome(jsonObject.getString(EmpresaDataModel.getNome()));
                    obj.setFantasia(jsonObject.getString(EmpresaDataModel.getFantasia()));
                    obj.setEndereco(jsonObject.getString(EmpresaDataModel.getEndereco()));
                    obj.setNumero(jsonObject.getString(EmpresaDataModel.getNumero()));
                    obj.setComplemento(jsonObject.getString(EmpresaDataModel.getComplemento()));
                    obj.setBairro(jsonObject.getString(EmpresaDataModel.getBairro()));
                    obj.setCep(jsonObject.getString(EmpresaDataModel.getCep()));
                    obj.setCidade(jsonObject.getString(EmpresaDataModel.getCidade()));
                    obj.setUf(jsonObject.getString(EmpresaDataModel.getUf()));
                    obj.setCnpj(jsonObject.getString(EmpresaDataModel.getCnpj()));
                    obj.setInscricaoEstadual(jsonObject.getString(EmpresaDataModel.getInscricaoEstadual()));
                    obj.setCpf(jsonObject.getString(EmpresaDataModel.getCpf()));
                    obj.setEmail(jsonObject.getString(EmpresaDataModel.getEmail()));
                    obj.setTelefone(jsonObject.getString(EmpresaDataModel.getTelefone()));
                    obj.setCelular(jsonObject.getString(EmpresaDataModel.getCelular()));
                    obj.setUrlFtp(jsonObject.getString(EmpresaDataModel.getUrlFtp()));
                    obj.setPortaFtp(jsonObject.getInt(EmpresaDataModel.getPortaFtp()));
                    obj.setUsuarioFtp(jsonObject.getString(EmpresaDataModel.getUsuarioFtp()));
                    obj.setSenhaFtp(jsonObject.getString(EmpresaDataModel.getSenhaFtp()));
                    obj.setPastaRemssaFtp(jsonObject.getString(EmpresaDataModel.getPastaRemssaFtp()));
                    obj.setPastaPedidosFtp(jsonObject.getString(EmpresaDataModel.getPastaPedidosFtp()));

                    EmpresaController.salvar(obj);

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