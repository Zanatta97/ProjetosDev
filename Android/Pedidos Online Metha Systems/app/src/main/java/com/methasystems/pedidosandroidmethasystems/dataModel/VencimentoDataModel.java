package com.methasystems.pedidosandroidmethasystems.dataModel;

import java.util.Date;

public class VencimentoDataModel {

    private final static String TABELA = "TB_VENCIMENTOS";

    private final static String codigo = "codigo";
    private final static String codigoPk = "codigo_pk";
    private final static String codigoVenda = "codigo_venda";
    private final static String numVenda = "num_venda";
    private final static String numVencimento = "num_vencimento";
    private final static String valorParcela = "valor_parcela";
    private final static String loginEmpresa = "login_empresa";
    private final static String dataVencimento = "data_vencimento";
    private final static String grupoEmpresa = "grupo_empresa";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela+= " (";
        queryCriarTabela+= codigo + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela+= codigoPk + " INTEGER, ";
        queryCriarTabela+= codigoVenda + " INTEGER, ";
        queryCriarTabela+= numVenda + " INTEGER, ";
        queryCriarTabela+= numVencimento + " INTEGER, ";
        queryCriarTabela+= valorParcela + " REAL, ";
        queryCriarTabela+= loginEmpresa + " TEXT, ";
        queryCriarTabela+= dataVencimento + " DATE, ";
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

    public static String getCodigoVenda() {
        return codigoVenda;
    }

    public static String getNumVenda() {
        return numVenda;
    }

    public static String getNumVencimento() {
        return numVencimento;
    }

    public static String getValorParcela() {
        return valorParcela;
    }

    public static String getLoginEmpresa() {
        return loginEmpresa;
    }

    public static String getDataVencimento() {
        return dataVencimento;
    }

    public static String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        VencimentoDataModel.queryCriarTabela = queryCriarTabela;
    }
}
