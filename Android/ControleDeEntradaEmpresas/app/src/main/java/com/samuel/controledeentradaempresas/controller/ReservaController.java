package com.samuel.controledeentradaempresas.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.samuel.controledeentradaempresas.dataModel.ClienteDataModel;
import com.samuel.controledeentradaempresas.dataModel.ReservaDataModel;
import com.samuel.controledeentradaempresas.dataSource.DataSource;
import com.samuel.controledeentradaempresas.model.Cliente;
import com.samuel.controledeentradaempresas.model.Reserva;
import com.samuel.controledeentradaempresas.util.UtilAplicativo;

import java.sql.Timestamp;

public class ReservaController extends DataSource {

    ContentValues dados;

    public ReservaController(@Nullable Context context) {
        super(context);
    }

    // Faz o insert no banco de dados
    public boolean salvar(Reserva obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(ReservaDataModel.getIdPk(), obj.getIdPk());
        dados.put(ReservaDataModel.getIdCliente(), obj.getIdCliente());
        dados.put(ReservaDataModel.getNomeCliente(), obj.getNomeClliente());
        dados.put(ReservaDataModel.getIdEmpresa(), obj.getIdEmpresa());
        dados.put(ReservaDataModel.getQtdPessoas(), obj.getQtdPessoas());
        dados.put(ReservaDataModel.getHoraReserva(), String.valueOf(obj.getHoraReserva()));
        dados.put(ReservaDataModel.getStatus(), obj.getStatus());
        dados.put(ReservaDataModel.getTelefoneCliente(), obj.getTelefoneCliente());

        sucesso = insert(ReservaDataModel.getTABELA(), dados);

        return sucesso;
    }

    //Faz o Delete no banco de dados
    public boolean deletarReserva(Reserva obj){

        boolean sucesso = true;

        sucesso = deletarReserva(ReservaDataModel.getTABELA(), obj.getId());

        return sucesso;
    }

    //Faz o Update no banco de dados
    public boolean alterar(Reserva obj){

        boolean sucesso = true;
        dados = new ContentValues();

        dados.put(ReservaDataModel.getId(), obj.getId());
        //dados.put(ReservaDataModel.getIdPk(), obj.getIdPk());
        dados.put(ReservaDataModel.getIdPk(), obj.getIdPk());
        dados.put(ReservaDataModel.getIdCliente(), obj.getIdCliente());
        dados.put(ReservaDataModel.getNomeCliente(), obj.getNomeClliente());
        dados.put(ReservaDataModel.getIdEmpresa(), obj.getIdEmpresa());
        dados.put(ReservaDataModel.getHoraReserva(), String.valueOf(obj.getHoraReserva()));
        dados.put(ReservaDataModel.getStatus(), obj.getStatus());
        dados.put(ReservaDataModel.getTelefoneCliente(), obj.getTelefoneCliente());


        sucesso = alterarReserva(ReservaDataModel.getTABELA(), dados);

        return sucesso;

    }

    //Define a cor de acordo com a aprovação
    public String corStatus(String status) {

        if (status.equals(UtilAplicativo.statusReservaAguardando)) {
            return "#006400";
        } else if (status.equals(UtilAplicativo.statusReservaChamado1)) {
            return "#0000FF";
        } else if (status.equals(UtilAplicativo.statusReservaChamado2)) {
            return "#0000FF";
        } else if (status.equals(UtilAplicativo.statusReservaEntrou)) {
            return "#006400";
        } else {
            //if (status == "Chamado 3x")
            return "#FF0000";
        }
    }

}
