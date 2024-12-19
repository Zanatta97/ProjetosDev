package com.example.controleentradacliente.dataModel;

public class ClienteDataModel {

    private final static String TABELA = "clientes";

    private final static String id = "id_cliente";
    private final static String idPk = "id_pk_cliente";
    private final static String nome = "nome_cliente";
    private final static String email = "email_cliente";
    private final static String senha = "senha_cliente";
    private final static String telefone = "telefone_cliente";
    private final static String status = "status_cliente";
    private final static String tokenFirebase = "token_cliente";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela+= " (";
        queryCriarTabela+= id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela+= idPk + " INTEGER, ";
        queryCriarTabela+= nome + " TEXT, ";
        queryCriarTabela+= email + " TEXT, ";
        queryCriarTabela+= senha + " TEXT, ";
        queryCriarTabela+= telefone + " TEXT, ";
        queryCriarTabela+= status + " TEXT, ";
        queryCriarTabela+= tokenFirebase + " TEXT";
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

    public static String getNome() {
        return nome;
    }

    public static String getEmail() {
        return email;
    }

    public static String getSenha() {
        return senha;
    }

    public static String getTelefone() {
        return telefone;
    }

    public static String getStatus() {
        return status;
    }

    public static String getTokenFirebase() {
        return tokenFirebase;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        ClienteDataModel.queryCriarTabela = queryCriarTabela;
    }
}
