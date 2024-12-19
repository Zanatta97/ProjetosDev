package com.methasystems.pedidosandroidmethasystems.dataModel;

public class ClienteDataModel {

    private static final String TABELA = "TB_CLIENTES";

    private static final String nome = "nome";
    private static final String cnpj = "cnpj";
    private static final String inscricaoEstadual = "inscricao_estadual";
    private static final String cpf = "cpf";
    private static final String loginEmpresa = "login_empresa";
    private static final String codGefims = "cod_gefims";
    private static final String codigo = "codigo";
    private static final String codigoPk = "codigo_pk";
    private static final String grupoEmpresa = "grupo_empresa";

    private static String queryCriarTabela = "";

    public static String criarTabela(){
        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += " (";
        queryCriarTabela += codigo + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += codigoPk + " INTEGER, ";
        queryCriarTabela += nome + " TEXT, ";
        queryCriarTabela += cnpj + " TEXT, ";
        queryCriarTabela += inscricaoEstadual + " TEXT, ";
        queryCriarTabela += cpf + " TEXT, ";
        queryCriarTabela += loginEmpresa + " TEXT, ";
        queryCriarTabela += codGefims + " TEXT, ";
        queryCriarTabela += grupoEmpresa + " TEXT";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getNome() {
        return nome;
    }

    public static String getCnpj() {
        return cnpj;
    }

    public static String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public static String getCpf() {
        return cpf;
    }

    public static String getLoginEmpresa() {
        return loginEmpresa;
    }

    public static String getCodGefims() {
        return codGefims;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static String getCodigoPk() {
        return codigoPk;
    }

    public static String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        ClienteDataModel.queryCriarTabela = queryCriarTabela;
    }
}
