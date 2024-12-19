package com.methasystems.pedidosandroidmethasystems.dataModel;

import java.util.Date;

public class VendaDataModel {

    private final static String TABELA = "TB_VENDAS";
    
    private final static String codigo = "codigo";
    private final static String codigoPk = "codigo_pk";
    private final static String data = "data";
    private final static String cliente = "cliente";
    private final static String total = "total";
    private final static String modalidadePagamento = "mod_pagamento";
    private final static String numParcelas = "num_parcelas";
    private final static String loginEmpresa = "login_empresa";
    private final static String numPedido = "num_pedido";
    private final static String grupoEmpresa = "grupo_empresa";
    private final static String transmitida = "transmitida";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela+= " (";
        queryCriarTabela+= codigo + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela+= codigoPk + " INTEGER, ";
        queryCriarTabela+= data + " DATE, ";
        queryCriarTabela+= cliente + " INTEGER, ";
        queryCriarTabela+= total + " REAL, ";
        queryCriarTabela+= modalidadePagamento + " INTEGER, ";
        queryCriarTabela+= numParcelas + " INTEGER, ";
        queryCriarTabela+= loginEmpresa + " TEXT, ";
        queryCriarTabela+= numPedido + " TEXT, ";
        queryCriarTabela+= grupoEmpresa + " TEXT, ";
        queryCriarTabela+= transmitida + " BOOLEAN";
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

    public static String getData() {
        return data;
    }

    public static String getCliente() {
        return cliente;
    }

    public static String getTotal() {
        return total;
    }

    public static String getModalidadePagamento() {
        return modalidadePagamento;
    }

    public static String getNumParcelas() {
        return numParcelas;
    }

    public static String getLoginEmpresa() {
        return loginEmpresa;
    }

    public static String getNumPedido() {
        return numPedido;
    }

    public static String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public static String getTransmitida() {
        return transmitida;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        VendaDataModel.queryCriarTabela = queryCriarTabela;
    }
}
