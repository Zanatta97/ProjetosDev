package com.methasystems.pedidosandroidmethasystems.model;

import java.util.Date;

public class Vencimento {

    private int codigo;
    private int codigoPk;
    private int codigoVenda;
    private String numVenda;
    private int numVencimento;
    private float valorParcela;
    private String loginEmpresa;
    private Date dataVencimento;
    private String grupoEmpresa;

    public Vencimento() {}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoPk() {
        return codigoPk;
    }

    public void setCodigoPk(int codigoPk) {
        this.codigoPk = codigoPk;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public String getNumVenda() {
        return numVenda;
    }

    public void setNumVenda(String numVenda) {
        this.numVenda = numVenda;
    }

    public int getNumVencimento() {
        return numVencimento;
    }

    public void setNumVencimento(int numVencimento) {
        this.numVencimento = numVencimento;
    }

    public float getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getLoginEmpresa() {
        return loginEmpresa;
    }

    public void setLoginEmpresa(String loginEmpresa) {
        this.loginEmpresa = loginEmpresa;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public void setGrupoEmpresa(String grupoEmpresa) {
        this.grupoEmpresa = grupoEmpresa;
    }
}
