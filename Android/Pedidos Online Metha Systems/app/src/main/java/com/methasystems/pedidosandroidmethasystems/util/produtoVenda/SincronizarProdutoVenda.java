package com.methasystems.pedidosandroidmethasystems.util.produtoVenda;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.methasystems.pedidosandroidmethasystems.controller.ProdutoVendaController;
import com.methasystems.pedidosandroidmethasystems.dataModel.ProdutoVendaDataModel;
import com.methasystems.pedidosandroidmethasystems.model.ProdutoVenda;
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

public class SincronizarProdutoVenda extends Thread {

    private HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
    private URL url = null; //URL para conexão
    private Uri.Builder builder; //Objeto para passar parametros para o PHP
    private Context context;
    private Empresa empresa;
    private ProdutoVendaController ProdutoVendaController;
    String result;

    public SincronizarProdutoVenda(Context context) {

        //Instancia o URI
        this.builder = new Uri.Builder();
        this.context = context;
        this.empresa = empresa;
        ProdutoVendaController = new ProdutoVendaController(context);

        //Adiciona um parâmetro no URI
        builder.appendQueryParameter("app", "PedidosOnline");
        builder.appendQueryParameter(ProdutoVendaDataModel.getLoginEmpresa(), UtilAplicativo.emailUsuario);

    }

    @Override
    public void run() {
        result = doInBackground();
        onPostExecute(result);
    }

    protected String doInBackground() {

        //Monta a URL do script PHP
        try {

            url = new URL(UtilAplicativo.URL_WEB_SERVICE + "APISincronizarProdVendas.php");

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

            ProdutoVendaController.deletarTabela(ProdutoVendaDataModel.getTABELA());
            ProdutoVendaController.criarTabela(ProdutoVendaDataModel.criarTabela());

            JSONArray jsonArray = new JSONArray(result);


            if (jsonArray.length() != 0) {

                //Salvar os dados no banco de dados SQLite


                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    ProdutoVenda obj = new ProdutoVenda();

                    obj.setCodigoPk(jsonObject.getInt(ProdutoVendaDataModel.getCodigo()));
                    obj.setCliente(jsonObject.getInt(ProdutoVendaDataModel.getCliente()));
                    obj.setData(Date.valueOf(jsonObject.getString(ProdutoVendaDataModel.getData())));
                    obj.setCodigoProduto(jsonObject.getInt(ProdutoVendaDataModel.getCodigoProduto()));
                    obj.setQuantidade(Float.valueOf(jsonObject.getString(ProdutoVendaDataModel.getQuantidade())));
                    obj.setValorUnitario(Float.parseFloat(jsonObject.getString(ProdutoVendaDataModel.getValorUnitario())));
                    obj.setValorTotal(Float.parseFloat(jsonObject.getString(ProdutoVendaDataModel.getValorTotal())));
                    obj.setUnidade(jsonObject.getString(ProdutoVendaDataModel.getUnidade()));
                    obj.setItem(jsonObject.getInt(ProdutoVendaDataModel.getItem()));
                    obj.setNumPedido(jsonObject.getString(ProdutoVendaDataModel.getNumPedido()));
                    obj.setLoginEmpresa(jsonObject.getString(ProdutoVendaDataModel.getLoginEmpresa()));
                    obj.setNomeProduto(jsonObject.getString(ProdutoVendaDataModel.getNomeProduto()));
                    obj.setReferencia(jsonObject.getString(ProdutoVendaDataModel.getReferencia()));
                    obj.setCodigoVenda(jsonObject.getInt(ProdutoVendaDataModel.getCodigoVenda()));
                    obj.setGrupoEmpresa(jsonObject.getString(ProdutoVendaDataModel.getGrupoEmpresa()));

                    ProdutoVendaController.salvar(obj);

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