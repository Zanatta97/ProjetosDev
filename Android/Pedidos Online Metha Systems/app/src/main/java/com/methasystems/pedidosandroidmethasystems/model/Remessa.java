package com.methasystems.pedidosandroidmethasystems.model;

import java.util.Date;

public class Remessa {

    private int codigo;
    private int codigoPk;
    private String cnpj;
    private int nroRemessa;
    private Date dataRemessa;
    private String loginEmpresa;
    private String grupoEmpresa;

    public Remessa() {
    }

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getNroRemessa() {
        return nroRemessa;
    }

    public void setNroRemessa(int nroRemessa) {
        this.nroRemessa = nroRemessa;
    }

    public Date getDataRemessa() {
        return dataRemessa;
    }

    public void setDataRemessa(Date dataRemessa) {
        this.dataRemessa = dataRemessa;
    }

    public String getLoginEmpresa() {
        return loginEmpresa;
    }

    public void setLoginEmpresa(String loginEmpresa) {
        this.loginEmpresa = loginEmpresa;
    }

    public String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public void setGrupoEmpresa(String grupoEmpresa) {
        this.grupoEmpresa = grupoEmpresa;
    }
}
