package com.methasystems.pedidosandroidmethasystems.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.ModalidadePagamentoDataModel;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.ModalidadePagamento;

public class ModalidadePagamentoController extends DataSource {

    ContentValues dados;

    public ModalidadePagamentoController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(ModalidadePagamento obj){

        boolean sucesso = true;

        dados = new ContentValues();

        //dados.put(ModalidadePagamentoDataModel.getCodigo(), obj.getCodigo());
        dados.put(ModalidadePagamentoDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(ModalidadePagamentoDataModel.getNome(), obj.getNome());


        sucesso = insert(ModalidadePagamentoDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(ModalidadePagamento obj){
        boolean sucesso = true;

        sucesso = deletar(ModalidadePagamentoDataModel.getTABELA(), obj.getCodigo());

        return sucesso;
    }

    public boolean alterar(ModalidadePagamento obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(ModalidadePagamentoDataModel.getCodigo(), obj.getCodigo());
        //dados.put(ModalidadePagamentoDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(ModalidadePagamentoDataModel.getNome(), obj.getNome());


        sucesso = alterar(ModalidadePagamentoDataModel.getTABELA(), dados);

        return sucesso;

    }
}
