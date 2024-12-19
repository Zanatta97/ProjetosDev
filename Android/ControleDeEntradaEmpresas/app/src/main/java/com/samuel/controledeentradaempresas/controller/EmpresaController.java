package com.samuel.controledeentradaempresas.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.samuel.controledeentradaempresas.dataModel.EmpresaDataModel;
import com.samuel.controledeentradaempresas.dataSource.DataSource;
import com.samuel.controledeentradaempresas.model.Empresa;

import java.sql.Time;

public class EmpresaController extends DataSource {

    ContentValues dados;

    public EmpresaController(@Nullable Context context) {
        super(context);
    }

    // Faz o insert no banco de dados
    public boolean salvar(Empresa obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(EmpresaDataModel.getIdPk(), obj.getIdPk());
        dados.put(EmpresaDataModel.getNome(), obj.getNome());
        dados.put(EmpresaDataModel.getCnpj(), obj.getCnpj());
        dados.put(EmpresaDataModel.getEndereco(), obj.getEndereco());
        dados.put(EmpresaDataModel.getNumero(), obj.getNumero());
        dados.put(EmpresaDataModel.getComplemento(), obj.getComplemento());
        dados.put(EmpresaDataModel.getBairro(), obj.getBairro());
        dados.put(EmpresaDataModel.getCidade(), obj.getCidade());
        dados.put(EmpresaDataModel.getUf(), obj.getUf());
        dados.put(EmpresaDataModel.getCep(), obj.getCep());
        dados.put(EmpresaDataModel.getDescricao(), obj.getDescricao());

        dados.put(EmpresaDataModel.getHoraAberturaSegunda(), String.valueOf(obj.getHoraAberturaSegunda()));
        dados.put(EmpresaDataModel.getHoraFechamentoSegunda(), String.valueOf(obj.getHoraFechamentoSegunda()));

        dados.put(EmpresaDataModel.getHoraAberturaTerca(), String.valueOf(obj.getHoraAberturaTerca()));
        dados.put(EmpresaDataModel.getHoraFechamentoTerca(), String.valueOf(obj.getHoraFechamentoTerca()));

        dados.put(EmpresaDataModel.getHoraAberturaQuarta(), String.valueOf(obj.getHoraAberturaQuarta()));
        dados.put(EmpresaDataModel.getHoraFechamentoQuarta(), String.valueOf(obj.getHoraFechamentoQuarta()));

        dados.put(EmpresaDataModel.getHoraAberturaQuinta(), String.valueOf(obj.getHoraAberturaQuinta()));
        dados.put(EmpresaDataModel.getHoraFechamentoQuinta(), String.valueOf(obj.getHoraFechamentoQuinta()));

        dados.put(EmpresaDataModel.getHoraAberturaSexta(), String.valueOf(obj.getHoraAberturaSexta()));
        dados.put(EmpresaDataModel.getHoraFechamentoSexta(), String.valueOf(obj.getHoraFechamentoSexta()));

        dados.put(EmpresaDataModel.getHoraAberturaSabado(), String.valueOf(obj.getHoraAberturaSabado()));
        dados.put(EmpresaDataModel.getHoraFechamentoSabado(), String.valueOf(obj.getHoraFechamentoSabado()));

        dados.put(EmpresaDataModel.getHoraAberturaDomingo(), String.valueOf(obj.getHoraAberturaDomingo()));
        dados.put(EmpresaDataModel.getHoraFechamentoDomingo(), String.valueOf(obj.getHoraFechamentoDomingo()));

        dados.put(EmpresaDataModel.getTokenFirebase(), obj.getTokenFirebase());
        dados.put(EmpresaDataModel.getEmail(), obj.getEmail());
        dados.put(EmpresaDataModel.getSenha(), obj.getSenha());

        sucesso = insert(EmpresaDataModel.getTABELA(), dados);

        return sucesso;
    }

    //Faz o Delete no banco de dados
    public boolean deletar(Empresa obj){

        boolean sucesso = true;

        sucesso = deletar(EmpresaDataModel.getTABELA(), obj.getId());

        return sucesso;
    }

    //Faz o Update no banco de dados
    public boolean alterar(Empresa obj){

        boolean sucesso = true;
        dados = new ContentValues();

        dados.put(EmpresaDataModel.getId(), obj.getId());
        //dados.put(EmpresaDataModel.getIdPk(), obj.getIdPk());
        dados.put(EmpresaDataModel.getNome(), obj.getNome());
        dados.put(EmpresaDataModel.getCnpj(), obj.getCnpj());
        dados.put(EmpresaDataModel.getEndereco(), obj.getEndereco());
        dados.put(EmpresaDataModel.getNumero(), obj.getNumero());
        dados.put(EmpresaDataModel.getComplemento(), obj.getComplemento());
        dados.put(EmpresaDataModel.getBairro(), obj.getBairro());
        dados.put(EmpresaDataModel.getCidade(), obj.getCidade());
        dados.put(EmpresaDataModel.getUf(), obj.getUf());
        dados.put(EmpresaDataModel.getCep(), obj.getCep());
        dados.put(EmpresaDataModel.getDescricao(), obj.getDescricao());

        dados.put(EmpresaDataModel.getHoraAberturaSegunda(), String.valueOf(obj.getHoraAberturaSegunda()));
        dados.put(EmpresaDataModel.getHoraFechamentoSegunda(), String.valueOf(obj.getHoraFechamentoSegunda()));

        dados.put(EmpresaDataModel.getHoraAberturaTerca(), String.valueOf(obj.getHoraAberturaTerca()));
        dados.put(EmpresaDataModel.getHoraFechamentoTerca(), String.valueOf(obj.getHoraFechamentoTerca()));

        dados.put(EmpresaDataModel.getHoraAberturaQuarta(), String.valueOf(obj.getHoraAberturaQuarta()));
        dados.put(EmpresaDataModel.getHoraFechamentoQuarta(), String.valueOf(obj.getHoraFechamentoQuarta()));

        dados.put(EmpresaDataModel.getHoraAberturaQuinta(), String.valueOf(obj.getHoraAberturaQuinta()));
        dados.put(EmpresaDataModel.getHoraFechamentoQuinta(), String.valueOf(obj.getHoraFechamentoQuinta()));

        dados.put(EmpresaDataModel.getHoraAberturaSexta(), String.valueOf(obj.getHoraAberturaSexta()));
        dados.put(EmpresaDataModel.getHoraFechamentoSexta(), String.valueOf(obj.getHoraFechamentoSexta()));

        dados.put(EmpresaDataModel.getHoraAberturaSabado(), String.valueOf(obj.getHoraAberturaSabado()));
        dados.put(EmpresaDataModel.getHoraFechamentoSabado(), String.valueOf(obj.getHoraFechamentoSabado()));

        dados.put(EmpresaDataModel.getHoraAberturaDomingo(), String.valueOf(obj.getHoraAberturaDomingo()));
        dados.put(EmpresaDataModel.getHoraFechamentoDomingo(), String.valueOf(obj.getHoraFechamentoDomingo()));

        dados.put(EmpresaDataModel.getTokenFirebase(), obj.getTokenFirebase());
        dados.put(EmpresaDataModel.getEmail(), obj.getEmail());
        dados.put(EmpresaDataModel.getSenha(), obj.getSenha());

        sucesso = alterarEmpresa(EmpresaDataModel.getTABELA(), dados);

        return sucesso;
    }
}
