package com.methasystems.pedidosandroidmethasystems.model;

import com.methasystems.pedidosandroidmethasystems.util.MaskEditUtil;

public class Cliente {

    private String nome;
    private String cnpj;
    private String inscricaoEstadual;
    private String cpf;
    private String loginEmpresa;
    private int codGefims;
    private int codigo;
    private int codigoPk;
    private String grupoEmpresa;


    public Cliente(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLoginEmpresa() {
        return loginEmpresa;
    }

    public void setLoginEmpresa(String loginEmpresa) {
        this.loginEmpresa = loginEmpresa;
    }

    public int getCodGefims() {
        return codGefims;
    }

    public void setCodGefims(int codGefims) {
        this.codGefims = codGefims;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodigoPk() {
        return codigoPk;
    }

    public void setCodigoPk(int codigoPk) {
        this.codigoPk = codigoPk;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public void setGrupoEmpresa(String grupoEmpresa) {
        this.grupoEmpresa = grupoEmpresa;
    }

    @Override
    public String toString() {
        if (cnpj == null || cnpj.equals("NULL")){
            return nome + " - " + MaskEditUtil.mascaraCPF(cpf);
        } else {
            return nome + " - " + MaskEditUtil.mascaraCNPJ(cnpj);
        }

    }
}
