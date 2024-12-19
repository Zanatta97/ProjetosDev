package com.methasystems.pedidosandroidmethasystems.dataModel;

public class EmpresaDataModel {

    private final static String TABELA = "TB_EMPRESAS";

    private final static String codigo = "codigo";
    private final static String codigoPk = "codigo_pk";
    private final static String nome = "nome";
    private final static String fantasia = "fantasia";
    private final static String endereco = "endereco";
    private final static String numero = "numero";
    private final static String complemento = "complemento";
    private final static String bairro = "bairro";
    private final static String cep = "cep";
    private final static String cidade = "cidade";
    private final static String uf = "uf";
    private final static String cnpj = "cnpj";
    private final static String inscricaoEstadual = "inscricao_estadual";
    private final static String cpf = "cpf";
    private final static String email = "email";
    private final static String telefone = "telefone";
    private final static String celular = "celular";
    private final static String urlFtp = "url_ftp";
    private final static String portaFtp = "porta_ftp";
    private final static String usuarioFtp = "usuario_ftp";
    private final static String senhaFtp = "senha_ftp";
    private final static String pastaRemssaFtp = "pasta_remessa_ftp";
    private final static String pastaPedidosFtp = "pasta_pedidos_ftp";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += " (";
        queryCriarTabela += codigo + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += codigoPk + " INTEGER, ";
        queryCriarTabela += nome + " TEXT, ";
        queryCriarTabela += fantasia + " TEXT, ";
        queryCriarTabela += endereco + " TEXT, ";
        queryCriarTabela += numero + " TEXT, ";
        queryCriarTabela += complemento + " TEXT, ";
        queryCriarTabela += bairro + " TEXT, ";
        queryCriarTabela += cep + " TEXT, ";
        queryCriarTabela += cidade + " TEXT, ";
        queryCriarTabela += uf + " TEXT, ";
        queryCriarTabela += cnpj + " TEXT, ";
        queryCriarTabela += inscricaoEstadual + " TEXT, ";
        queryCriarTabela += cpf + " TEXT, ";
        queryCriarTabela += email + " TEXT, ";
        queryCriarTabela += telefone + " TEXT, ";
        queryCriarTabela += celular + " TEXT, ";
        queryCriarTabela += urlFtp + " TEXT, ";
        queryCriarTabela += portaFtp + " INTEGER, ";
        queryCriarTabela += usuarioFtp + " TEXT, ";
        queryCriarTabela += senhaFtp + " TEXT, ";
        queryCriarTabela += pastaRemssaFtp + " TEXT, ";
        queryCriarTabela += pastaPedidosFtp + " TEXT";
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

    public static String getFantasia() {
        return fantasia;
    }

    public static String getEndereco() {
        return endereco;
    }

    public static String getNumero() {
        return numero;
    }

    public static String getComplemento() {
        return complemento;
    }

    public static String getBairro() {
        return bairro;
    }

    public static String getCep() {
        return cep;
    }

    public static String getCidade() {
        return cidade;
    }

    public static String getUf() {
        return uf;
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

    public static String getEmail() {
        return email;
    }

    public static String getTelefone() {
        return telefone;
    }

    public static String getCelular() {
        return celular;
    }

    public static String getUrlFtp() {
        return urlFtp;
    }

    public static String getPortaFtp() {
        return portaFtp;
    }

    public static String getUsuarioFtp() {
        return usuarioFtp;
    }

    public static String getSenhaFtp() {
        return senhaFtp;
    }

    public static String getPastaRemssaFtp() {
        return pastaRemssaFtp;
    }

    public static String getPastaPedidosFtp() {
        return pastaPedidosFtp;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        EmpresaDataModel.queryCriarTabela = queryCriarTabela;
    }
}
