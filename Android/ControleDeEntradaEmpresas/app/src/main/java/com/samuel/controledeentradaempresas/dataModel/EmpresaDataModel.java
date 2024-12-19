package com.samuel.controledeentradaempresas.dataModel;

public class EmpresaDataModel {

    private final static String TABELA = "empresas";

    private final static String id = "id_empresa";
    private final static String idPk = "id_pk_empresa";
    private final static String nome = "nome_empresa";
    private final static String cnpj = "cnpj_empresa";
    private final static String endereco = "endereco_empresa";
    private final static String numero = "numero_empresa";
    private final static String complemento = "complemento_empresa";
    private final static String bairro = "bairro_empresa";
    private final static String cidade = "cidade_empresa";
    private final static String uf = "uf_empresa";
    private final static String cep = "cep_empresa";
    private final static String descricao = "descricao_empresa";
    private final static String horaAberturaSegunda = "abre_segunda";
    private final static String horaFechamentoSegunda = "fecha_segunda";
    private final static String horaAberturaTerca = "abre_terca";
    private final static String horaFechamentoTerca = "fecha_terca";
    private final static String horaAberturaQuarta = "abre_quarta";
    private final static String horaFechamentoQuarta = "fecha_quarta";
    private final static String horaAberturaQuinta = "abre_quinta";
    private final static String horaFechamentoQuinta = "fecha_quinta";
    private final static String horaAberturaSexta = "abre_sexta";
    private final static String horaFechamentoSexta = "fecha_sexta";
    private final static String horaAberturaSabado = "abre_sabado";
    private final static String horaFechamentoSabado = "fecha_sabado";
    private final static String horaAberturaDomingo = "abre_domingo";
    private final static String horaFechamentoDomingo = "fecha_domingo";
    private final static String tokenFirebase = "token_firebase";
    private final static String email = "email_empresa";
    private final static String senha = "senha_empresa";

    private static String queryCriarTabela = "";

    public static String criarTabela(){


        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela+= " (";
        queryCriarTabela+= id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela+= idPk + " INTEGER, ";
        queryCriarTabela+= nome + " TEXT, ";
        queryCriarTabela+= cnpj + " TEXT, ";
        queryCriarTabela+= endereco + " TEXT, ";
        queryCriarTabela+= numero + " INTEGER, ";
        queryCriarTabela+= complemento + " TEXT, ";
        queryCriarTabela+= bairro + " TEXT, ";
        queryCriarTabela+= cidade + " TEXT, ";
        queryCriarTabela+= uf + " TEXT, ";
        queryCriarTabela+= cep + " TEXT, ";
        queryCriarTabela+= descricao + " TEXT, ";
        queryCriarTabela+= horaAberturaSegunda + " TIME, ";
        queryCriarTabela+= horaFechamentoSegunda + " TIME, ";
        queryCriarTabela+= horaAberturaTerca + " TIME, ";
        queryCriarTabela+= horaFechamentoTerca + " TIME, ";
        queryCriarTabela+= horaAberturaQuarta + " TIME, ";
        queryCriarTabela+= horaFechamentoQuarta + " TIME, ";
        queryCriarTabela+= horaAberturaQuinta + " TIME, ";
        queryCriarTabela+= horaFechamentoQuinta + " TIME, ";
        queryCriarTabela+= horaAberturaSexta + " TIME, ";
        queryCriarTabela+= horaFechamentoSexta + " TIME, ";
        queryCriarTabela+= horaAberturaSabado + " TIME, ";
        queryCriarTabela+= horaFechamentoSabado + " TIME, ";
        queryCriarTabela+= horaAberturaDomingo + " TIME, ";
        queryCriarTabela+= horaFechamentoDomingo + " TIME, ";
        queryCriarTabela+= tokenFirebase + " TEXT, ";
        queryCriarTabela+= email + " TEXT, ";
        queryCriarTabela+= senha + " TEXT";
        queryCriarTabela+= ")";

        return queryCriarTabela;
    }


    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getIdPk() {
        return idPk;
    }

    public static String getNome() {
        return nome;
    }

    public static String getCnpj() {
        return cnpj;
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

    public static String getCidade() {
        return cidade;
    }

    public static String getUf() {
        return uf;
    }

    public static String getCep() {
        return cep;
    }

    public static String getDescricao() {
        return descricao;
    }

    public static String getHoraAberturaSegunda() {
        return horaAberturaSegunda;
    }

    public static String getHoraFechamentoSegunda() {
        return horaFechamentoSegunda;
    }

    public static String getHoraAberturaTerca() {
        return horaAberturaTerca;
    }

    public static String getHoraFechamentoTerca() {
        return horaFechamentoTerca;
    }

    public static String getHoraAberturaQuarta() {
        return horaAberturaQuarta;
    }

    public static String getHoraFechamentoQuarta() {
        return horaFechamentoQuarta;
    }

    public static String getHoraAberturaQuinta() {
        return horaAberturaQuinta;
    }

    public static String getHoraFechamentoQuinta() {
        return horaFechamentoQuinta;
    }

    public static String getHoraAberturaSexta() {
        return horaAberturaSexta;
    }

    public static String getHoraFechamentoSexta() {
        return horaFechamentoSexta;
    }

    public static String getHoraAberturaSabado() {
        return horaAberturaSabado;
    }

    public static String getHoraFechamentoSabado() {
        return horaFechamentoSabado;
    }

    public static String getHoraAberturaDomingo() {
        return horaAberturaDomingo;
    }

    public static String getHoraFechamentoDomingo() {
        return horaFechamentoDomingo;
    }

    public static String getTokenFirebase() {
        return tokenFirebase;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        EmpresaDataModel.queryCriarTabela = queryCriarTabela;
    }

    public static String getEmail() {
        return email;
    }

    public static String getSenha() {
        return senha;
    }
}
