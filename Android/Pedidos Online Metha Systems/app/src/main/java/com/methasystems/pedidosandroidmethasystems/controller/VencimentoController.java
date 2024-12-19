package com.methasystems.pedidosandroidmethasystems.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.ProdutoVendaDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.VencimentoDataModel;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.Vencimento;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VencimentoController extends DataSource {

    ContentValues dados;

    public VencimentoController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(Vencimento obj){

        boolean sucesso = true;

        dados = new ContentValues();

        //dados.put(VencimentoDataModel.getCodigo(), obj.getCodigo());
        dados.put(VencimentoDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(VencimentoDataModel.getCodigoVenda(), obj.getCodigoVenda());
        dados.put(VencimentoDataModel.getNumVenda(), obj.getNumVenda());
        dados.put(VencimentoDataModel.getNumVencimento(), obj.getNumVencimento());
        dados.put(VencimentoDataModel.getValorParcela(), obj.getValorParcela());
        dados.put(VencimentoDataModel.getLoginEmpresa(), obj.getLoginEmpresa());

        //Transformar a data em uma string para poder inserir no BD
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(obj.getDataVencimento());
        dados.put(VencimentoDataModel.getDataVencimento(), date);

        dados.put(VencimentoDataModel.getGrupoEmpresa(), obj.getGrupoEmpresa());

        sucesso = insert(VencimentoDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(Vencimento obj){
        boolean sucesso = true;

        sucesso = deletar(VencimentoDataModel.getTABELA(), obj.getCodigo());

        return sucesso;
    }

    public boolean alterar(Vencimento obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(VencimentoDataModel.getCodigo(), obj.getCodigo());
        //dados.put(VencimentoDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(VencimentoDataModel.getCodigoVenda(), obj.getCodigoVenda());
        dados.put(VencimentoDataModel.getNumVenda(), obj.getNumVenda());
        dados.put(VencimentoDataModel.getNumVencimento(), obj.getNumVencimento());
        dados.put(VencimentoDataModel.getValorParcela(), obj.getValorParcela());
        dados.put(VencimentoDataModel.getLoginEmpresa(), obj.getLoginEmpresa());

        //Transformar a data em uma string para poder inserir no BD
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(obj.getDataVencimento());
        dados.put(VencimentoDataModel.getDataVencimento(), date);

        dados.put(VencimentoDataModel.getGrupoEmpresa(), obj.getGrupoEmpresa());

        sucesso = alterar(VencimentoDataModel.getTABELA(), dados);

        return sucesso;

    }
}
