package com.methasystems.pedidosandroidmethasystems.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.GrupoLoginDataModel;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.GrupoLogin;

public class GrupoLoginController  extends DataSource {

    ContentValues dados;

    public GrupoLoginController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(GrupoLogin obj){

        boolean sucesso = true;

        dados = new ContentValues();

        //dados.put(GrupoLoginDataModel.getCodigo(), obj.getCodigo());
        dados.put(GrupoLoginDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(GrupoLoginDataModel.getNome(), obj.getNome());
        dados.put(GrupoLoginDataModel.getIsAdmin(), obj.isAdmin());

        sucesso = insert(GrupoLoginDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(GrupoLogin obj){
        boolean sucesso = true;

        sucesso = deletar(GrupoLoginDataModel.getTABELA(), obj.getCodigo());

        return sucesso;
    }

    public boolean alterar(GrupoLogin obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(GrupoLoginDataModel.getCodigo(), obj.getCodigo());
        //dados.put(GrupoLoginDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(GrupoLoginDataModel.getNome(), obj.getNome());
        dados.put(GrupoLoginDataModel.getIsAdmin(), obj.isAdmin());

        sucesso = alterar(GrupoLoginDataModel.getTABELA(), dados);

        return sucesso;

    }
}
