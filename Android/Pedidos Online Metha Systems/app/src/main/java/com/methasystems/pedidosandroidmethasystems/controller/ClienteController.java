package com.methasystems.pedidosandroidmethasystems.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.ClienteDataModel;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.Cliente;

public class ClienteController extends DataSource {

    ContentValues dados;

    public ClienteController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(Cliente obj){

        boolean sucesso = true;

        dados = new ContentValues();

        //dados.put(ClienteDataModel.getCodigo(), obj.getCodigo());
        dados.put(ClienteDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(ClienteDataModel.getNome(), obj.getNome());
        dados.put(ClienteDataModel.getCnpj(), obj.getCnpj());
        dados.put(ClienteDataModel.getInscricaoEstadual(), obj.getInscricaoEstadual());
        dados.put(ClienteDataModel.getCpf(), obj.getCpf());
        dados.put(ClienteDataModel.getLoginEmpresa(), obj.getLoginEmpresa());
        dados.put(ClienteDataModel.getCodGefims(), obj.getCodGefims());
        dados.put(ClienteDataModel.getGrupoEmpresa(), obj.getGrupoEmpresa());

        sucesso = insert(ClienteDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(Cliente obj){
        boolean sucesso = true;

        sucesso = deletar(ClienteDataModel.getTABELA(), obj.getCodigo());

        return sucesso;
    }

    public boolean alterar(Cliente obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(ClienteDataModel.getCodigo(), obj.getCodigo());
        //dados.put(ClienteDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(ClienteDataModel.getNome(), obj.getNome());
        dados.put(ClienteDataModel.getCnpj(), obj.getCnpj());
        dados.put(ClienteDataModel.getInscricaoEstadual(), obj.getInscricaoEstadual());
        dados.put(ClienteDataModel.getCpf(), obj.getCpf());
        dados.put(ClienteDataModel.getLoginEmpresa(), obj.getLoginEmpresa());
        dados.put(ClienteDataModel.getCodGefims(), obj.getCodGefims());
        dados.put(ClienteDataModel.getGrupoEmpresa(), obj.getGrupoEmpresa());

        sucesso = alterar(ClienteDataModel.getTABELA(), dados);

        return sucesso;

    }
}
