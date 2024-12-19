package com.methasystems.pedidosandroidmethasystems.dataModel;

public class UsuarioDataModel {

    private final static String TABELA = "TB_LOGIN_USER";

    private final static String codigo = "codigo";
    private final static String codigoPk = "codigo_pk";
    private final static String nome = "nome";
    private final static String login = "login";
    private final static String senha = "senha";
    private final static String nomeGrupo = "nome_grupo";
    private final static String grupo = "grupo";
    private final static String obs = "obs";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela+= " (";
        queryCriarTabela+= codigo + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela+= codigoPk + " INTEGER, ";
        queryCriarTabela+= nome + " TEXT, ";
        queryCriarTabela+= login + " TEXT, ";
        queryCriarTabela+= senha + " TEXT, ";
        queryCriarTabela+= nomeGrupo + " TEXT, ";
        queryCriarTabela+= grupo + " INTEGER, ";
        queryCriarTabela+= obs + " TEXT";
        queryCriarTabela+= ")";

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

    public static String getLogin() {
        return login;
    }

    public static String getSenha() {
        return senha;
    }

    public static String getNomeGrupo() {
        return nomeGrupo;
    }

    public static String getGrupo() {
        return grupo;
    }

    public static String getObs() {
        return obs;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        UsuarioDataModel.queryCriarTabela = queryCriarTabela;
    }
}
