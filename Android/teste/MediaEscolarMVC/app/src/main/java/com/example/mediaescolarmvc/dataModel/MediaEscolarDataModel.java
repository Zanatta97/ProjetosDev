package com.example.mediaescolarmvc.dataModel;

public class MediaEscolarDataModel {

    //Dados para criar as tabelas no banco de dados
    // MOR - Modelo Objeto Relacional

    //Criar dinamicamente uma query SQL para criar a tabela Media Escolar  no Banco de Dados

    private final static String TABELA = "media_escolar";

    private final static String id = "id";
    private final static String idPK = "idpk";
    private final static String materia = "materia";
    private final static String bimestre = "bimestre";
    private final static String situacao = "situacao";
    private final static String notaProva = "notaProva";
    private final static String notaTrabalho = "notaTrabalho";
    private final static String mediaFinal = "mediaFinal";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += " (";
        queryCriarTabela += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += idPK + " INTEGER, ";
        queryCriarTabela += materia + " TEXT, ";
        queryCriarTabela += bimestre + " TEXT, ";
        queryCriarTabela += situacao + " TEXT, ";
        queryCriarTabela += notaProva + " REAL, ";
        queryCriarTabela += notaTrabalho + " REAL, ";
        queryCriarTabela += mediaFinal + " REAL ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getIdPK() {
        return idPK;
    }

    public static String getMateria() {
        return materia;
    }

    public static String getBimestre() {
        return bimestre;
    }

    public static String getSituacao() {
        return situacao;
    }

    public static String getNotaProva() {
        return notaProva;
    }

    public static String getNotaTrabalho() {
        return notaTrabalho;
    }

    public static String getMediaFinal() {
        return mediaFinal;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        MediaEscolarDataModel.queryCriarTabela = queryCriarTabela;
    }
}
