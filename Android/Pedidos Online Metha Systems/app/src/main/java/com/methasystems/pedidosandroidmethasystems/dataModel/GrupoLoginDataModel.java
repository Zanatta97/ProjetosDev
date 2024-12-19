package com.methasystems.pedidosandroidmethasystems.dataModel;

import java.util.Queue;

public class GrupoLoginDataModel {

    private final static String TABELA = "TB_LOGIN_GROUP";

    private final static String codigo = "codigo";
    private final static String codigoPk = "codigo_pk";
    private final static String nome = "nome";
    private final static String isAdmin = "is_admin";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela+= " (";
        queryCriarTabela+= codigo + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela+= codigoPk + " INTEGER, ";
        queryCriarTabela+= nome + " TEXT, ";
        queryCriarTabela+= isAdmin + " BOOLEAN";
        queryCriarTabela += ")";

        return queryCriarTabela;

    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static String getCodigoPk() {
        return codigoPk;
    }

    public static String getNome() {
        return nome;
    }

    public static String getIsAdmin() {
        return isAdmin;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        GrupoLoginDataModel.queryCriarTabela = queryCriarTabela;
    }
}
