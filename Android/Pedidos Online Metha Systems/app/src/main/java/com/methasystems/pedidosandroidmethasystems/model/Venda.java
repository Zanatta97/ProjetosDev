package com.methasystems.pedidosandroidmethasystems.model;

import java.util.Date;

public class Venda {

    private int codigo;
    private int codigoPk;
    private Date data;
    private int cliente;
    private float total;
    private int modalidadePagamento;
    private int numParcelas;
    private String loginEmpresa;
    private String numPedido;
    private String grupoEmpresa;
    private boolean transmitida;

    public Venda() {}

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getModalidadePagamento() {
        return modalidadePagamento;
    }

    public void setModalidadePagamento(int modalidadePagamento) {
        this.modalidadePagamento = modalidadePagamento;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public String getLoginEmpresa() {
        return loginEmpresa;
    }

    public void setLoginEmpresa(String loginEmpresa) {
        this.loginEmpresa = loginEmpresa;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public void setGrupoEmpresa(String grupoEmpresa) {
        this.grupoEmpresa = grupoEmpresa;
    }

    public boolean isTransmitida() {
        return transmitida;
    }

    public void setTransmitida(boolean transmitida) {
        this.transmitida = transmitida;
    }
}
