package com.methasystems.pedidosandroidmethasystems.dataModel;

import com.methasystems.pedidosandroidmethasystems.model.ModalidadePagamento;

import java.util.List;

public class ModalidadePagamentoDataModel {

    private final static String TABELA = "TB_MOD_PAGAMENTO";

    private final static String codigo = "codigo";
    private final static String codigoPk = "codigo_pk";
    private final static String nome = "nome";
    //private static List<ModalidadePagamento> modalidades;


    private static String queryCriarTabela = "";

    public static String criarTabela(){
        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += " (";
        queryCriarTabela += codigo + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += codigoPk + " INTEGER, ";
        queryCriarTabela += nome + " TEXT";
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

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        ModalidadePagamentoDataModel.queryCriarTabela = queryCriarTabela;
    }

}
