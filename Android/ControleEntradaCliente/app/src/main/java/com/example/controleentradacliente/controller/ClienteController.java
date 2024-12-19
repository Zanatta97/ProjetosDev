package com.example.controleentradacliente.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.example.controleentradacliente.dataModel.ClienteDataModel;
import com.example.controleentradacliente.dataSource.DataSource;
import com.example.controleentradacliente.model.Cliente;

public class ClienteController extends DataSource {

    ContentValues dados;

    public ClienteController(@Nullable Context context) {
        super(context);
    }

    // Faz o insert no banco de dados
    public boolean salvar(Cliente obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(ClienteDataModel.getIdPk(), obj.getIdPk());
        dados.put(ClienteDataModel.getNome(), obj.getNome());
        dados.put(ClienteDataModel.getEmail(), obj.getEmail());
        dados.put(ClienteDataModel.getSenha(), obj.getSenha());
        dados.put(ClienteDataModel.getTelefone(), obj.getTelefone());
        dados.put(ClienteDataModel.getStatus(), obj.getStatus());
        dados.put(ClienteDataModel.getTokenFirebase(), obj.getTokenFirebase());

        sucesso = insert(ClienteDataModel.getTABELA(), dados);

        return sucesso;
    }

    //Faz o Delete no banco de dados
    public boolean deletar(Cliente obj){

        boolean sucesso = true;

        sucesso = deletar(ClienteDataModel.getTABELA(), obj.getId());

        return sucesso;
    }

    //Faz o Update no banco de dados
    public boolean alterar(Cliente obj){

        boolean sucesso = true;
        dados = new ContentValues();

        dados.put(ClienteDataModel.getId(), obj.getId());
        //dados.put(ClienteDataModel.getIdPk(), obj.getIdPk());
        dados.put(ClienteDataModel.getNome(), obj.getNome());
        dados.put(ClienteDataModel.getNome(), obj.getNome());
        dados.put(ClienteDataModel.getEmail(), obj.getEmail());
        dados.put(ClienteDataModel.getSenha(), obj.getSenha());
        dados.put(ClienteDataModel.getTelefone(), obj.getTelefone());
        dados.put(ClienteDataModel.getStatus(), obj.getStatus());
        dados.put(ClienteDataModel.getTokenFirebase(), obj.getTokenFirebase());


        sucesso = alterarCliente(ClienteDataModel.getTABELA(), dados);

        return sucesso;

    }
}
