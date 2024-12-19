package com.samuel.controledeentradaempresas.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import androidx.fragment.app.FragmentManager;

import com.samuel.controledeentradaempresas.controller.EmpresaController;
import com.samuel.controledeentradaempresas.dataModel.EmpresaDataModel;
import com.samuel.controledeentradaempresas.model.Empresa;

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
import java.sql.Time;

public class GetEmpresaAsyncTask extends AsyncTask<String, String, String> {

    ProgressDialog progressDialog;
    HttpURLConnection connection; //Realiza a conexão com protocolo HTTP e devolve todos os códigos padrão(404 e etc)
    URL url = null; //URL para conexão
    Uri.Builder builder;//Objeto para passar parametros para o PHP
    EmpresaController controller;

    FragmentManager fragmentManager;

    Context context;

    public GetEmpresaAsyncTask(Context context, String emailEmpresa){

        //Instancia o URI
        this.builder = new Uri.Builder();

        //Instancia o Context
        this.context = context;

        controller = new EmpresaController(context);

        //Adiciona um parâmetro no URI
        builder.appendQueryParameter("app", "ControleEntradas");
        builder.appendQueryParameter(EmpresaDataModel.getEmail(), emailEmpresa);

    }

    @Override
    protected void onPreExecute(){

        /*progressDialog = new ProgressDialog(context);

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
        }*/

    }

    @Override
    protected String doInBackground(String... strings) {

        //TODO: Sempre fazer os processos dentro de Try/Catch

        //Monta a URL do script PHP
        try{

            url = new URL(UtilAplicativo.URL_WEB_SERVICE + "APIGetEmpresa.php");

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

        try {

            JSONArray jsonArray = new JSONArray(result);

            if (jsonArray.length() != 0){

                //Salvar os dados no banco de dados SQLite

                controller.deletarTabela(EmpresaDataModel.getTABELA());
                controller.criarTabela(EmpresaDataModel.criarTabela());

                for (int i=0; i < jsonArray.length(); i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    Empresa obj = new Empresa();

                    obj.setIdPk(jsonObject.getInt(EmpresaDataModel.getId()));
                    obj.setNome(jsonObject.getString(EmpresaDataModel.getNome()));
                    obj.setCnpj(jsonObject.getString(EmpresaDataModel.getCnpj()));
                    obj.setEndereco(jsonObject.getString(EmpresaDataModel.getEndereco()));
                    obj.setNumero(jsonObject.getInt(EmpresaDataModel.getNumero()));
                    obj.setComplemento(jsonObject.getString(EmpresaDataModel.getComplemento()));
                    obj.setBairro(jsonObject.getString(EmpresaDataModel.getBairro()));
                    obj.setCidade(jsonObject.getString(EmpresaDataModel.getCidade()));
                    obj.setUf(jsonObject.getString(EmpresaDataModel.getUf()));
                    obj.setCep(jsonObject.getString(EmpresaDataModel.getCep()));
                    obj.setDescricao(jsonObject.getString(EmpresaDataModel.getDescricao()));

                    obj.setHoraAberturaSegunda(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraAberturaSegunda())));
                    obj.setHoraFechamentoSegunda(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraFechamentoSegunda())));

                    obj.setHoraAberturaTerca(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraAberturaTerca())));
                    obj.setHoraFechamentoTerca(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraFechamentoTerca())));

                    obj.setHoraFechamentoQuarta(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraFechamentoQuarta())));

                    obj.setHoraFechamentoQuinta(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraFechamentoQuinta())));
                    obj.setHoraFechamentoQuinta(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraFechamentoQuinta())));

                    obj.setHoraAberturaSexta(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraAberturaSexta())));
                    obj.setHoraFechamentoSexta(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraFechamentoSexta())));

                    obj.setHoraAberturaSabado(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraAberturaSabado())));
                    obj.setHoraFechamentoSabado(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraFechamentoSabado())));

                    obj.setHoraAberturaDomingo(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraAberturaDomingo())));
                    obj.setHoraFechamentoDomingo(Time.valueOf(jsonObject.getString(EmpresaDataModel.getHoraFechamentoDomingo())));

                    obj.setTokenFirebase(jsonObject.getString(EmpresaDataModel.getHoraFechamentoTerca()));
                    obj.setEmail(jsonObject.getString(EmpresaDataModel.getEmail()));
                    obj.setSenha(jsonObject.getString(EmpresaDataModel.getSenha()));

                    controller.salvar(obj);

                }

            } else {
                UtilAplicativo.showMessageToast(context, "Nenhum registro encontrado no momento...");
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
            //ResultadoFinalFragment test = (ResultadoFinalFragment) fragmentManager.findFragmentByTag("resultadoFinal");

            //Se a pessoa ainda não abriu o fragment ele retorna nulo
            //Teste para saber se o fragment ja foi instanciado alguma vez
            /*if (test == null){
                //Se não estiver, ele só avisa que a sincronização foi realizada em background
                UtilMediaEscolar.showMessageToast(context, "Sincronização Realizada em Segundo Plano");
            } else {

                //Testa se o fragment foi criado, e está visivel
                if (test.isVisible() && test.isAdded() && test.getUserVisibleHint()) {
                    //Se estiver visivel ele atualiza a tela para o usuário
                    fragmentManager.beginTransaction().replace(R.id.content_fragment, new ResultadoFinalFragment(), "resultadoFinal").commit();
                } else {
                    //Se não estiver, ele só avisa que a sincronização foi realizada em background
                    UtilMediaEscolar.showMessageToast(context, "Sincronização Realizada em Segundo Plano");
                }

            }*/

        }

    }

    @Override
    protected void onCancelled(){
        UtilAplicativo.showMessageToast(context,"Erro ao sicronizar dados...");
    }

}