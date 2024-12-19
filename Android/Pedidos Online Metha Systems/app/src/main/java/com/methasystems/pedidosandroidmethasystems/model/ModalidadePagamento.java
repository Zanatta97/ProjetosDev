package com.methasystems.pedidosandroidmethasystems.model;

public class ModalidadePagamento {

    private int codigo;
    private int codigoPk;
    private String nome;

    public ModalidadePagamento() {}

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return nome;
    }
}
