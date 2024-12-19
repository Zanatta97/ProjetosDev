package com.example.mediaescolarmvc.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.example.mediaescolarmvc.dataModel.MediaEscolarDataModel;
import com.example.mediaescolarmvc.dataSource.DataSource;
import com.example.mediaescolarmvc.model.MediaEscolar;

import java.util.ArrayList;
import java.util.List;

public class MediaEscolarController extends DataSource {

    ContentValues dados;

    public MediaEscolarController(@Nullable Context context) {
        super(context);
    }

    //Calcula a média final
    public double calcularMedia(MediaEscolar obj){
        return (obj.getNotaProva() + obj.getNotaTrabalho()) / 2;
    }

    //Define a cor de acordo com a aprovação
    public String corResultadoFinal(double media){
        return media >= 7 ? "#006400" : "#FF0000";
    }

    //Define se aprovado ou não
    public String resultadoFinal(double media){
        return media >= 7 ? "Aprovado" : "Reprovado";
    }

    /**
     * Método que recebe um objeto e prepara para o DataSource salvar no banco de dados
     * @param obj da classe MédiaEscolar
     * @return verdadeiro se salvou com sucesso e falso se deu algum problema
     */

    //Faz o insert no banco de dados
    public boolean salvar(MediaEscolar obj){

        boolean sucesso = true;
        dados = new ContentValues();

        dados.put(MediaEscolarDataModel.getIdPK(), obj.getIdPK());
        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaTrabalho(), obj.getNotaTrabalho());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        sucesso = insert(MediaEscolarDataModel.getTABELA(), dados);

        return sucesso;
    }

    //Faz o Delete no banco de dados
    public boolean deletar(MediaEscolar obj){

        boolean sucesso = true;

        sucesso = deletar(MediaEscolarDataModel.getTABELA(), obj.getId());

        return sucesso;
    }

    //Faz o Update no banco de dados
    public boolean alterar(MediaEscolar obj){

        boolean sucesso = true;
        dados = new ContentValues();

        dados.put(MediaEscolarDataModel.getId(), obj.getId());
        //dados.put(MediaEscolarDataModel.getIdPK(), obj.getIdPK());
        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaTrabalho(), obj.getNotaTrabalho());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        sucesso = alterar(MediaEscolarDataModel.getTABELA(), dados);

        return sucesso;
    }

    //Cria uma lista de objetos com os itens do Banco de dados
    public List<MediaEscolar> listar(){

        return getAllMediaEscolar();
    }

    //Cria um ArrayList de objetos com os itens do banco de dados
    public ArrayList<MediaEscolar> getResultadoFinal(){
        return getAllResultadoFinal();
    }

    public boolean isNotaValida(Double nota) {
        return ((nota > 10) || (nota < 0));
    }
}
