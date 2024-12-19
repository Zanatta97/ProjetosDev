package com.methasystems.pedidosandroidmethasystems.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.UsuarioDataModel;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.Usuario;

public class UsuarioController extends DataSource {

    ContentValues dados;

    public UsuarioController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(Usuario obj){

        boolean sucesso = true;

        dados = new ContentValues();

        //dados.put(UsuarioDataModel.getCodigo(), obj.getCodigo());
        dados.put(UsuarioDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(UsuarioDataModel.getNome(), obj.getNome());
        dados.put(UsuarioDataModel.getLogin(), obj.getLogin());
        dados.put(UsuarioDataModel.getSenha(), obj.getSenha());
        dados.put(UsuarioDataModel.getNomeGrupo(), obj.getNomeGrupo());
        dados.put(UsuarioDataModel.getGrupo(), obj.getGrupo());
        dados.put(UsuarioDataModel.getObs(), obj.getObs());

        sucesso = insert(UsuarioDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(Usuario obj){
        boolean sucesso = true;

        sucesso = deletar(UsuarioDataModel.getTABELA(), obj.getCodigo());

        return sucesso;
    }

    public boolean alterar(Usuario obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(UsuarioDataModel.getCodigo(), obj.getCodigo());
        //dados.put(UsuarioDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(UsuarioDataModel.getNome(), obj.getNome());
        dados.put(UsuarioDataModel.getLogin(), obj.getLogin());
        dados.put(UsuarioDataModel.getSenha(), obj.getSenha());
        dados.put(UsuarioDataModel.getNomeGrupo(), obj.getNomeGrupo());
        dados.put(UsuarioDataModel.getGrupo(), obj.getGrupo());
        dados.put(UsuarioDataModel.getObs(), obj.getObs());

        sucesso = alterar(UsuarioDataModel.getTABELA(), dados);

        return sucesso;

    }
}
