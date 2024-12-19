package com.methasystems.pedidosandroidmethasystems.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.methasystems.pedidosandroidmethasystems.dataModel.EmpresaDataModel;
import com.methasystems.pedidosandroidmethasystems.dataSource.DataSource;
import com.methasystems.pedidosandroidmethasystems.model.Empresa;

public class EmpresaController extends DataSource {

    ContentValues dados;

    public EmpresaController(@Nullable Context context) {
        super(context);
    }

    public boolean salvar(Empresa obj){

        boolean sucesso = true;

        dados = new ContentValues();

        //dados.put(EmpresaDataModel.getCodigo(), obj.getCodigo());
        dados.put(EmpresaDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(EmpresaDataModel.getNome(), obj.getNome());
        dados.put(EmpresaDataModel.getFantasia(), obj.getFantasia());
        dados.put(EmpresaDataModel.getEndereco(), obj.getEndereco());
        dados.put(EmpresaDataModel.getNumero(), obj.getNumero());
        dados.put(EmpresaDataModel.getComplemento(), obj.getComplemento());
        dados.put(EmpresaDataModel.getBairro(), obj.getBairro());
        dados.put(EmpresaDataModel.getCep(), obj.getCep());
        dados.put(EmpresaDataModel.getCidade(), obj.getCidade());
        dados.put(EmpresaDataModel.getUf(), obj.getUf());
        dados.put(EmpresaDataModel.getCnpj(), obj.getCnpj());
        dados.put(EmpresaDataModel.getInscricaoEstadual(), obj.getInscricaoEstadual());
        dados.put(EmpresaDataModel.getCpf(), obj.getCpf());
        dados.put(EmpresaDataModel.getEmail(), obj.getEmail());
        dados.put(EmpresaDataModel.getTelefone(), obj.getTelefone());
        dados.put(EmpresaDataModel.getCelular(), obj.getCelular());
        dados.put(EmpresaDataModel.getUrlFtp(), obj.getUrlFtp());
        dados.put(EmpresaDataModel.getPortaFtp(), obj.getPortaFtp());
        dados.put(EmpresaDataModel.getUsuarioFtp(), obj.getUsuarioFtp());
        dados.put(EmpresaDataModel.getSenhaFtp(), obj.getSenhaFtp());
        dados.put(EmpresaDataModel.getPastaRemssaFtp(), obj.getPastaRemssaFtp());
        dados.put(EmpresaDataModel.getPastaPedidosFtp(), obj.getPastaPedidosFtp());


        sucesso = insert(EmpresaDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(Empresa obj){
        boolean sucesso = true;

        sucesso = deletar(EmpresaDataModel.getTABELA(), obj.getCodigo());

        return sucesso;
    }

    public boolean alterar(Empresa obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(EmpresaDataModel.getCodigo(), obj.getCodigo());
        //dados.put(EmpresaDataModel.getCodigoPk(), obj.getCodigoPk());
        dados.put(EmpresaDataModel.getNome(), obj.getNome());
        dados.put(EmpresaDataModel.getFantasia(), obj.getFantasia());
        dados.put(EmpresaDataModel.getEndereco(), obj.getEndereco());
        dados.put(EmpresaDataModel.getNumero(), obj.getNumero());
        dados.put(EmpresaDataModel.getComplemento(), obj.getComplemento());
        dados.put(EmpresaDataModel.getBairro(), obj.getBairro());
        dados.put(EmpresaDataModel.getCep(), obj.getCep());
        dados.put(EmpresaDataModel.getCidade(), obj.getCidade());
        dados.put(EmpresaDataModel.getUf(), obj.getUf());
        dados.put(EmpresaDataModel.getCnpj(), obj.getCnpj());
        dados.put(EmpresaDataModel.getInscricaoEstadual(), obj.getInscricaoEstadual());
        dados.put(EmpresaDataModel.getCpf(), obj.getCpf());
        dados.put(EmpresaDataModel.getEmail(), obj.getEmail());
        dados.put(EmpresaDataModel.getTelefone(), obj.getTelefone());
        dados.put(EmpresaDataModel.getCelular(), obj.getCelular());
        dados.put(EmpresaDataModel.getUrlFtp(), obj.getUrlFtp());
        dados.put(EmpresaDataModel.getPortaFtp(), obj.getPortaFtp());
        dados.put(EmpresaDataModel.getUsuarioFtp(), obj.getUsuarioFtp());
        dados.put(EmpresaDataModel.getSenhaFtp(), obj.getSenhaFtp());
        dados.put(EmpresaDataModel.getPastaRemssaFtp(), obj.getPastaRemssaFtp());
        dados.put(EmpresaDataModel.getPastaPedidosFtp(), obj.getPastaPedidosFtp());

        sucesso = alterar(EmpresaDataModel.getTABELA(), dados);

        return sucesso;

    }
}
