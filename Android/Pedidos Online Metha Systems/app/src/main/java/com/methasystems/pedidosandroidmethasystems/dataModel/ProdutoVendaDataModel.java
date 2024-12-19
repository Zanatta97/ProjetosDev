package com.methasystems.pedidosandroidmethasystems.dataModel;

import java.util.Date;

public class ProdutoVendaDataModel {

    private final static String TABELA = "TB_PROD_VENDAS";

    private final static String cliente = "cliente";
    private final static String data = "data";
    private final static String codigoProduto = "codigo_produto";
    private final static String quantidade = "quantidade";
    private final static String valorUnitario = "vlr_unitario";
    private final static String valorTotal = "vlr_total";
    private final static String unidade = "unidade";
    private final static String item = "item";
    private final static String numPedido = "num_pedido";
    private final static String codigo = "codigo";
    private final static String codigoPk = "codigo_pk";
    private final static String loginEmpresa = "login_empresa";
    private final static String nomeProduto = "nome_produto";
    private final static String referencia = "referencia";
    private final static String codigoVenda = "codigo_venda";
    private final static String grupoEmpresa = "grupo_empresa";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela+= " (";
        queryCriarTabela+= codigo + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela+= codigoPk + " INTEGER, ";
        queryCriarTabela+= cliente + " INTEGER, ";
        queryCriarTabela+= data + " DATE, ";
        queryCriarTabela+= codigoProduto + " INTEGER, ";
        queryCriarTabela+= quantidade + " REAL, ";
        queryCriarTabela+= valorUnitario + " REAL, ";
        queryCriarTabela+= valorTotal + " REAL, ";
        queryCriarTabela+= unidade + " TEXT, ";
        queryCriarTabela+= item + " INTEGER, ";
        queryCriarTabela+= numPedido + " TEXT, ";
        queryCriarTabela+= loginEmpresa + " TEXT, ";
        queryCriarTabela+= nomeProduto + " TEXT, ";
        queryCriarTabela+= referencia + " TEXT, ";
        queryCriarTabela+= codigoVenda + " INTEGER, ";
        queryCriarTabela+= grupoEmpresa + " TEXT";
        queryCriarTabela+= ")";

        return queryCriarTabela;
    }


    public static String getTABELA() {
        return TABELA;
    }

    public static String getCliente() {
        return cliente;
    }

    public static String getData() {
        return data;
    }

    public static String getCodigoProduto() {
        return codigoProduto;
    }

    public static String getQuantidade() {
        return quantidade;
    }

    public static String getValorUnitario() {
        return valorUnitario;
    }

    public static String getValorTotal() {
        return valorTotal;
    }

    public static String getUnidade() {
        return unidade;
    }

    public static String getItem() {
        return item;
    }

    public static String getNumPedido() {
        return numPedido;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static String getCodigoPk() {
        return codigoPk;
    }

    public static String getLoginEmpresa() {
        return loginEmpresa;
    }

    public static String getNomeProduto() {
        return nomeProduto;
    }

    public static String getReferencia() {
        return referencia;
    }

    public static String getCodigoVenda() {
        return codigoVenda;
    }

    public static String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        ProdutoVendaDataModel.queryCriarTabela = queryCriarTabela;
    }
}
