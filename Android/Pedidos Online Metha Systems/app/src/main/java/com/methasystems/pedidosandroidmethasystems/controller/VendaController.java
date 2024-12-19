package com.methasystems.pedidosandroidmethasystems.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.VencimentoDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.VendaDataModel;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.Venda;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VendaController extends DataSource {

    ContentValues dados;

    public VendaController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(Venda obj){

        boolean sucesso = true;

        dados = new ContentValues();

        //dados.put(VendaDataModel.getCodigo(), obj.getCodigo());
        dados.put(VendaDataModel.getCodigoPk(), obj.getCodigoPk());

        //Transformar a data em uma string para poder inserir no BD
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(obj.getData());
        dados.put(VendaDataModel.getData(), date);

        dados.put(VendaDataModel.getCliente(), obj.getCliente());
        dados.put(VendaDataModel.getTotal(), obj.getTotal());
        dados.put(VendaDataModel.getModalidadePagamento(), obj.getModalidadePagamento());
        dados.put(VendaDataModel.getNumParcelas(), obj.getNumParcelas());
        dados.put(VendaDataModel.getLoginEmpresa(), obj.getLoginEmpresa());
        dados.put(VendaDataModel.getNumPedido(), obj.getNumPedido());
        dados.put(VendaDataModel.getNumPedido(), obj.getNumPedido());
        dados.put(VendaDataModel.getTransmitida(), obj.isTransmitida());

        sucesso = insert(VendaDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(Venda obj){
        boolean sucesso = true;

        sucesso = deletar(VendaDataModel.getTABELA(), obj.getCodigo());

        return sucesso;
    }

    public boolean alterar(Venda obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(VendaDataModel.getCodigo(), obj.getCodigo());
        //dados.put(VendaDataModel.getCodigoPk(), obj.getCodigoPk());

        //Transformar a data em uma string para poder inserir no BD
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(obj.getData());
        dados.put(VendaDataModel.getData(), date);

        dados.put(VendaDataModel.getCliente(), obj.getCliente());
        dados.put(VendaDataModel.getTotal(), obj.getTotal());
        dados.put(VendaDataModel.getModalidadePagamento(), obj.getModalidadePagamento());
        dados.put(VendaDataModel.getNumParcelas(), obj.getNumParcelas());
        dados.put(VendaDataModel.getLoginEmpresa(), obj.getLoginEmpresa());
        dados.put(VendaDataModel.getNumPedido(), obj.getNumPedido());
        dados.put(VendaDataModel.getNumPedido(), obj.getNumPedido());
        dados.put(VendaDataModel.getTransmitida(), obj.isTransmitida());

        sucesso = alterar(VendaDataModel.getTABELA(), dados);

        return sucesso;

    }
}
