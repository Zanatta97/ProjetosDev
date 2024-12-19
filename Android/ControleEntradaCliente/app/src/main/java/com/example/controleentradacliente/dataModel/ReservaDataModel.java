package com.example.controleentradacliente.dataModel;

public class ReservaDataModel {

    private final static String TABELA = "reservas";

    private final static String id = "id_reserva";
    private final static String idPk = "id_pk_reserva";
    private final static String idCliente = "id_cliente";
    private final static String nomeCliente = "nome_cliente";
    private final static String idEmpresa = "id_empresa";
    private final static String qtdPessoas = "qtd_pessoas";
    private final static String horaReserva = "hora_reserva";
    private final static String status = "status_reserva";
    private final static String telefoneCliente = "telefone_cliente";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela+= " (";
        queryCriarTabela+= id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela+= idPk + " INTEGER, ";
        queryCriarTabela+= idCliente + " INTEGER, ";
        queryCriarTabela+= nomeCliente + " TEXT, ";
        queryCriarTabela+= idEmpresa + " INTEGER, ";
        queryCriarTabela+= qtdPessoas + " INTEGER, ";
        queryCriarTabela+= horaReserva + " TIMESTAMP, ";
        queryCriarTabela+= status + " TEXT, ";
        queryCriarTabela+= telefoneCliente + " TEXT";
        queryCriarTabela+= ")";

        return queryCriarTabela;
    }


    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getIdPk() {
        return idPk;
    }

    public static String getIdCliente() {
        return idCliente;
    }

    public static String getIdEmpresa() {
        return idEmpresa;
    }

    public static String getQtdPessoas() {
        return qtdPessoas;
    }

    public static String getHoraReserva() {
        return horaReserva;
    }

    public static String getStatus() {
        return status;
    }

    public static String getTelefoneCliente() {
        return telefoneCliente;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        ReservaDataModel.queryCriarTabela = queryCriarTabela;
    }

    public static String getNomeCliente() {
        return nomeCliente;
    }
}
