package com.methasystems.pedidosandroidmethasystems.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.ProdutoVendaDataModel;
import com.methasystems.pedidosandroidmethasystems.dataModel.RemessaDataModel;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.Remessa;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RemessaController extends DataSource {

    ContentValues dados;

    public RemessaController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(Remessa obj){

        boolean sucesso = true;

        dados = new ContentValues();

        //dados.put(RemessaDataModel.getCodigo(), obj.getCodigo());
        dados.put(RemessaDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(RemessaDataModel.getCnpj(), obj.getCnpj());
        dados.put(RemessaDataModel.getNroRemessa(), obj.getNroRemessa());

        //Transformar a data em uma string para poder inserir no BD
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(obj.getDataRemessa());
        dados.put(RemessaDataModel.getDataRemessa(), date);

        dados.put(RemessaDataModel.getLoginEmpresa(), obj.getLoginEmpresa());
        dados.put(RemessaDataModel.getGrupoEmpresa(), obj.getGrupoEmpresa());

        sucesso = insert(RemessaDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(Remessa obj){
        boolean sucesso = true;

        sucesso = deletar(RemessaDataModel.getTABELA(), obj.getCodigo());

        return sucesso;
    }

    public boolean alterar(Remessa obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(RemessaDataModel.getCodigo(), obj.getCodigo());
        //dados.put(RemessaDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(RemessaDataModel.getCnpj(), obj.getCnpj());
        dados.put(RemessaDataModel.getNroRemessa(), obj.getNroRemessa());

        //Transformar a data em uma string para poder inserir no BD
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(obj.getDataRemessa());
        dados.put(RemessaDataModel.getDataRemessa(), date);

        dados.put(RemessaDataModel.getLoginEmpresa(), obj.getLoginEmpresa());
        dados.put(RemessaDataModel.getGrupoEmpresa(), obj.getGrupoEmpresa());

        sucesso = alterar(RemessaDataModel.getTABELA(), dados);

        return sucesso;

    }
}
