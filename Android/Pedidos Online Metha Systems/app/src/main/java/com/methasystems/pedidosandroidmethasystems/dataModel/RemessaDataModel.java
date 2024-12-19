package com.methasystems.pedidosandroidmethasystems.dataModel;

public class RemessaDataModel {

    private final static String TABELA = "TB_REMESSA";

    private final static String codigo = "codigo";
    private final static String codigoPk = "codigo_pk";
    private final static String cnpj = "cnpj";
    private final static String nroRemessa = "nro_remessa";
    private final static String data = "data";
    private final static String loginEmpresa = "login_empresa";
    private final static String grupoEmpresa = "grupo_empresa";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela+= " (";
        queryCriarTabela+= codigo + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela+= codigoPk + " INTEGER, ";
        queryCriarTabela+= cnpj + " TEXT, ";
        queryCriarTabela+= nroRemessa + " INTEGER, ";
        queryCriarTabela+= data + " DATE, ";
        queryCriarTabela+= loginEmpresa + " TEXT, ";
        queryCriarTabela+= grupoEmpresa + " TEXT";
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

    public static String getCnpj() {
        return cnpj;
    }

    public static String getNroRemessa() {
        return nroRemessa;
    }

    public static String getDataRemessa() {
        return data;
    }

    public static String getLoginEmpresa() {
        return loginEmpresa;
    }

    public static String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        RemessaDataModel.queryCriarTabela = queryCriarTabela;
    }
}
