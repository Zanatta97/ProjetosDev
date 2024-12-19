package com.example.mediaescolarmvc.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mediaescolarmvc.R;
import com.example.mediaescolarmvc.controller.MediaEscolarController;
import com.example.mediaescolarmvc.model.MediaEscolar;
import com.example.mediaescolarmvc.util.AlterarAsyncTask;
import com.example.mediaescolarmvc.util.DeletarAsyncTask;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

//Herdar ArrayAdapter - Media Escolar
//Implementar OnClickListener
//Contexto
//Classe ViewHolder para os elementos ImageView e TextView
//Atributo para conhecer a posição no array - Animação
//Contrutor que receba o elemento dataSet
//onClick do elemento na lista
//Devolver via getView linha por linha para o ListView

public class ResultadoFinalListAdapter extends ArrayAdapter<MediaEscolar> implements View.OnClickListener {

    Context context;
    private int ultimaPosicao;

    //Cria um constutor global para os alerts
    AlertDialog.Builder builder;

    //Criar uma classe global para os alerts
    AlertDialog alert;

    ArrayList<MediaEscolar> dados;
    MediaEscolar mediaEscolar;
    MediaEscolarController controller;
    ViewHolder linha;

    //Cria um ViewHolder para poder instanciar os componentes da view
    private static class ViewHolder {
        TextView txtBimestre, txtMateria, txtResultado, txtMedia;
        ImageView imgLogo;
        ImageView imgConsultar;
        ImageView imgDeletar;
        ImageView imgSalvar;
        ImageView imgEditar;

    }

    //Cria a lista com os dados do Banco de dados
    public ResultadoFinalListAdapter(ArrayList<MediaEscolar> dataSet, Context context) {
        super(context, R.layout.listview_resultado_final, dataSet);

        this.dados = dataSet;

        this.context = context;
    }

    //Atualiza os dados da lista
    public void atualizarLista(ArrayList<MediaEscolar> dadosNovos) {
        this.dados.clear();
        this.dados.addAll(dadosNovos);

        notifyDataSetChanged();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public void onClick(View view) {
        int posicao = (Integer) view.getTag();

        Object object = getItem(posicao);

        mediaEscolar = (MediaEscolar) object;

        controller = new MediaEscolarController(getContext());

        switch (view.getId()) {
            case R.id.imgLogo:

                //Apresentar os dados detalhados

                Snackbar.make(view, "Nota da Prova: " + mediaEscolar.getNotaProva() + "\nNota do Trabalho:" + mediaEscolar.getNotaTrabalho(), Snackbar.LENGTH_LONG)
                        .setAction("No Action", null).show();

                //dados = controller.getAllResultadoFinal();
                //atualizarLista(dados);

                break;

            //Define o que ocorre no clique no botão Consultar
            case R.id.imgConsultar:

                //Cria um AlertDialog para exibir os dados do item selecionado
                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("CONSULTA");
                builder.setMessage("Matéria: " + mediaEscolar.getMateria() + "\nBimestre: " + mediaEscolar.getBimestre() +
                        "\n\nNota da Prova: " + mediaEscolar.getNotaProva() + "\nNota do Trabalho: " + mediaEscolar.getNotaTrabalho() +
                        "\n\nMédia Final: " + mediaEscolar.getMediaFinal() + "\nSituação: " + mediaEscolar.getSituacao());
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("VOLTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alert = builder.create();
                alert.show();

                break;

            //Define o que ocorre no clique no botão Salvar
            case R.id.imgSalvar:

                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("ALERTA");
                builder.setMessage("Deseja realmente SALVAR este registro?");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        controller.alterar(mediaEscolar);
                        atualizarLista(controller.getAllResultadoFinal());

                    }
                });
                builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alert = builder.create();
                alert.show();

                break;

            //Define o que ocorre no clique no botão Deletar
            case R.id.imgDeletar:

                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("ALERTA");
                builder.setMessage("Deseja realmente DELETAR este registro?");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        try {
                            //Deleta o dado no Banco de Dados
                            controller.deletar(mediaEscolar);
                            linha.imgDeletar.setEnabled(false);

                            DeletarAsyncTask task = new DeletarAsyncTask(mediaEscolar, context);
                            task.execute();

                        } catch (Exception e){
                            Log.e("Adapter", "Erro: " + e.getMessage());
                        }
                        //Atualiza a lista exibida na tela
                        atualizarLista(controller.getAllResultadoFinal());
                    }
                });
                builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alert = builder.create();
                alert.show();


                break;

            //Define o que ocorre no clique no botão Editar
            case R.id.imgEditar:

                //Instancia uma view para o alertView
                View alertView = view.inflate(getContext(), R.layout.alert_dialog_editar_listview, null);

                //Objeto para ser usado dentro do método
                final MediaEscolar mediaEscolar1 = mediaEscolar;

                final EditText editMateria = alertView.findViewById(R.id.editMateria);
                final EditText editNotaProva = alertView.findViewById(R.id.editNotaProva);
                final EditText editNotaTrabalho = alertView.findViewById(R.id.editNotaTrabalho);

                //Define os valores iniciais dos editTexts para os valores do item selecionado
                editMateria.setText(mediaEscolar1.getMateria());
                editNotaProva.setText(String.valueOf(mediaEscolar1.getNotaProva()));
                editNotaTrabalho.setText(String.valueOf(mediaEscolar1.getNotaTrabalho()));

                //Cria o Alert
                AlertDialog.Builder alertBox = new AlertDialog.Builder(alertView.getRootView().getContext());
                alertBox.setMessage(mediaEscolar1.getBimestre());
                alertBox.setTitle("EDITANDO");

                //Define a view para o Alert
                alertBox.setView(alertView);

                alertBox.setNeutralButton("SALVAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Passa os dados dos editTexts para o objeto
                        mediaEscolar1.setMateria(editMateria.getText().toString());
                        mediaEscolar1.setNotaTrabalho(Double.parseDouble(editNotaTrabalho.getText().toString()));
                        mediaEscolar1.setNotaProva(Double.parseDouble(editNotaProva.getText().toString()));

                        //Calcula a média final nova
                        Double mediaFinal = controller.calcularMedia(mediaEscolar1);

                        //Passa a média final nova para o objeto e define a situação
                        mediaEscolar1.setMediaFinal(mediaFinal);
                        mediaEscolar1.setSituacao(controller.resultadoFinal(mediaFinal));


                        try {
                            //Faz o update no BD com o objeto
                            controller.alterar(mediaEscolar1);

                            AlterarAsyncTask task = new AlterarAsyncTask(mediaEscolar1, context);
                            task.execute();

                        } catch (Exception e) {
                            Log.e("Adapter", "Erro: " + e.getMessage());
                        }

                        //Atualiza a lista na tela
                        atualizarLista(controller.getAllResultadoFinal());


                    }
                });

                alertBox.show();

                break;
        }
    }


    //Cria o layout para cada item da lista
    @NonNull
    @Override
    public View getView(int position, View dataSet, @NonNull ViewGroup parent) {

        mediaEscolar = getItem(position);

        controller = new MediaEscolarController(getContext());

        //ViewHolder linha;

        if (dataSet == null) {
            linha = new ViewHolder();
            LayoutInflater layoutResultadoFinalList = LayoutInflater.from(getContext());

            dataSet = layoutResultadoFinalList.inflate(R.layout.listview_resultado_final, parent, false);

            linha.txtBimestre = dataSet.findViewById(R.id.txtBimestre);
            linha.txtMateria = dataSet.findViewById(R.id.txtMateria);
            linha.txtResultado = dataSet.findViewById(R.id.txtResultado);
            linha.txtMedia = dataSet.findViewById(R.id.txtMedia);
            linha.imgLogo = dataSet.findViewById(R.id.imgLogo);
            linha.imgConsultar = dataSet.findViewById(R.id.imgConsultar);
            linha.imgDeletar = dataSet.findViewById(R.id.imgDeletar);
            linha.imgSalvar = dataSet.findViewById(R.id.imgSalvar);
            linha.imgEditar = dataSet.findViewById(R.id.imgEditar);

            dataSet.setTag(linha);

        } else {
            linha = (ViewHolder) dataSet.getTag();
        }

        linha.txtResultado.setText(mediaEscolar.getSituacao());
        linha.txtMateria.setText(mediaEscolar.getMateria());
        linha.txtBimestre.setText(mediaEscolar.getBimestre());
        linha.txtMedia.setText(String.valueOf(mediaEscolar.getMediaFinal()));

        //Define a cor do Label da média na view
        String cor = controller.corResultadoFinal(mediaEscolar.getMediaFinal());
        linha.txtMedia.setTextColor(Color.parseColor(cor));

        linha.imgLogo.setOnClickListener(this);
        linha.imgLogo.setTag(position);

        linha.imgSalvar.setOnClickListener(this);
        linha.imgSalvar.setTag(position);

        linha.imgConsultar.setOnClickListener(this);
        linha.imgConsultar.setTag(position);

        linha.imgEditar.setOnClickListener(this);
        linha.imgEditar.setTag(position);

        linha.imgDeletar.setOnClickListener(this);
        linha.imgDeletar.setTag(position);

        return dataSet;
    }
}
