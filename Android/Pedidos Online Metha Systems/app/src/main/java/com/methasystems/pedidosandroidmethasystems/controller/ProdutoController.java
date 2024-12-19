package com.methasystems.pedidosandroidmethasystems.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.ProdutoDataModel;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.Produto;

public class ProdutoController extends DataSource {

    ContentValues dados;

    public ProdutoController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(Produto obj){

        boolean sucesso = true;

        dados = new ContentValues();

        //dados.put(ProdutoDataModel.getCodigo(), obj.getCodigo());
        dados.put(ProdutoDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(ProdutoDataModel.getNome(), obj.getNome());
        dados.put(ProdutoDataModel.getValor(), obj.getValor());
        dados.put(ProdutoDataModel.getEstoque(), obj.getEstoque());
        dados.put(ProdutoDataModel.getUnidade(), obj.getUnidade());
        dados.put(ProdutoDataModel.getReferencia(), obj.getReferencia());
        dados.put(ProdutoDataModel.getCodEmpresa(), obj.getCodEmpresa());
        dados.put(ProdutoDataModel.getLoginEmpresa(), obj.getLoginEmpresa());
        dados.put(ProdutoDataModel.getCodGefims(), obj.getCodGefims());
        dados.put(ProdutoDataModel.getGrupoEmpresa(), obj.getGrupoEmpresa());

        sucesso = insert(ProdutoDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(Produto obj){
        boolean sucesso = true;

        sucesso = deletar(ProdutoDataModel.getTABELA(), obj.getCodigo());

        return sucesso;
    }

    public boolean alterar(Produto obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(ProdutoDataModel.getCodigo(), obj.getCodigo());
        //dados.put(ProdutoDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(ProdutoDataModel.getNome(), obj.getNome());
        dados.put(ProdutoDataModel.getValor(), obj.getValor());
        dados.put(ProdutoDataModel.getEstoque(), obj.getEstoque());
        dados.put(ProdutoDataModel.getUnidade(), obj.getUnidade());
        dados.put(ProdutoDataModel.getReferencia(), obj.getReferencia());
        dados.put(ProdutoDataModel.getCodEmpresa(), obj.getCodEmpresa());
        dados.put(ProdutoDataModel.getLoginEmpresa(), obj.getLoginEmpresa());
        dados.put(ProdutoDataModel.getCodGefims(), obj.getCodGefims());
        dados.put(ProdutoDataModel.getGrupoEmpresa(), obj.getGrupoEmpresa());

        sucesso = alterar(ProdutoDataModel.getTABELA(), dados);

        return sucesso;

    }
}
