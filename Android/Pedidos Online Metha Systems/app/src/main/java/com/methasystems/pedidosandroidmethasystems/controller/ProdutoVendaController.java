package com.methasystems.pedidosandroidmethasystems.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.ProdutoVendaDataModel;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.ProdutoVenda;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoVendaController extends DataSource {

    ContentValues dados;

    public ProdutoVendaController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(ProdutoVenda obj){

        boolean sucesso = true;

        dados = new ContentValues();

        //dados.put(ProdutoVendaDataModel.getCodigo(), obj.getCodigo());
        dados.put(ProdutoVendaDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(ProdutoVendaDataModel.getCliente(), obj.getCliente());

        //Transformar a data em uma string para poder inserir no BD
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(obj.getData());
        dados.put(ProdutoVendaDataModel.getData(), date);

        dados.put(ProdutoVendaDataModel.getCodigoProduto(), obj.getCodigoProduto());
        dados.put(ProdutoVendaDataModel.getQuantidade(), obj.getQuantidade());
        dados.put(ProdutoVendaDataModel.getValorUnitario(), obj.getValorUnitario());
        dados.put(ProdutoVendaDataModel.getValorTotal(), obj.getValorTotal());
        dados.put(ProdutoVendaDataModel.getUnidade(), obj.getUnidade());
        dados.put(ProdutoVendaDataModel.getItem(), obj.getItem());
        dados.put(ProdutoVendaDataModel.getNumPedido(), obj.getNumPedido());
        dados.put(ProdutoVendaDataModel.getLoginEmpresa(), obj.getLoginEmpresa());
        dados.put(ProdutoVendaDataModel.getNomeProduto(), obj.getNomeProduto());
        dados.put(ProdutoVendaDataModel.getReferencia(), obj.getReferencia());
        dados.put(ProdutoVendaDataModel.getCodigoVenda(), obj.getCodigoVenda());
        dados.put(ProdutoVendaDataModel.getGrupoEmpresa(), obj.getGrupoEmpresa());

        sucesso = insert(ProdutoVendaDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(ProdutoVenda obj){
        boolean sucesso = true;

        sucesso = deletar(ProdutoVendaDataModel.getTABELA(), obj.getCodigo());

        return sucesso;
    }

    public boolean alterar(ProdutoVenda obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(ProdutoVendaDataModel.getCodigo(), obj.getCodigo());
        //dados.put(ProdutoVendaDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(ProdutoVendaDataModel.getCliente(), obj.getCliente());

        //Transformar a data em uma string para poder inserir no BD
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(obj.getData());
        dados.put(ProdutoVendaDataModel.getData(), date);

        dados.put(ProdutoVendaDataModel.getQuantidade(), obj.getQuantidade());
        dados.put(ProdutoVendaDataModel.getValorUnitario(), obj.getValorUnitario());
        dados.put(ProdutoVendaDataModel.getValorTotal(), obj.getValorTotal());
        dados.put(ProdutoVendaDataModel.getUnidade(), obj.getUnidade());
        dados.put(ProdutoVendaDataModel.getItem(), obj.getItem());
        dados.put(ProdutoVendaDataModel.getNumPedido(), obj.getNumPedido());
        dados.put(ProdutoVendaDataModel.getLoginEmpresa(), obj.getLoginEmpresa());
        dados.put(ProdutoVendaDataModel.getNomeProduto(), obj.getNomeProduto());
        dados.put(ProdutoVendaDataModel.getReferencia(), obj.getReferencia());
        dados.put(ProdutoVendaDataModel.getCodigoVenda(), obj.getCodigoVenda());
        dados.put(ProdutoVendaDataModel.getGrupoEmpresa(), obj.getGrupoEmpresa());

        sucesso = alterar(ProdutoVendaDataModel.getTABELA(), dados);

        return sucesso;

    }
}
