package com.methasystems.pedidosandroidmethasystems.dataModel;

public class ProdutoDataModel {

    private static final String TABELA = "TB_PRODUTOS";

    private final static String nome = "nome";
    private final static String valor = "valor";
    private final static String estoque = "estoque";
    private final static String unidade = "unidade";
    private final static String referencia = "referencia";
    private final static String codEmpresa = "cod_empresa";
    private final static String loginEmpresa = "login_empresa";
    private final static String codGefims = "cod_gefims";
    private final static String grupoEmpresa = "grupo_empresa";
    private final static String codigo = "codigo";
    private final static String codigoPk = "codigo_pk";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += " (";
        queryCriarTabela += codigo + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += codigoPk + " INTEGER, ";
        queryCriarTabela += nome + " TEXT, ";
        queryCriarTabela += valor + " REAL, ";
        queryCriarTabela += estoque + " REAL, ";
        queryCriarTabela += unidade + " TEXT, ";
        queryCriarTabela += referencia + " TEXT, ";
        queryCriarTabela += codEmpresa + " INTEGER, ";
        queryCriarTabela += loginEmpresa + " TEXTE, ";
        queryCriarTabela += codGefims + " INTEGER, ";
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

    public static String getValor() {
        return valor;
    }

    public static String getEstoque() {
        return estoque;
    }

    public static String getUnidade() {
        return unidade;
    }

    public static String getReferencia() {
        return referencia;
    }

    public static String getCodEmpresa() {
        return codEmpresa;
    }

    public static String getLoginEmpresa() {
        return loginEmpresa;
    }

    public static String getCodGefims() {
        return codGefims;
    }

    public static String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static String getCodigoPk() {
        return codigoPk;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        ProdutoDataModel.queryCriarTabela = queryCriarTabela;
    }
}
