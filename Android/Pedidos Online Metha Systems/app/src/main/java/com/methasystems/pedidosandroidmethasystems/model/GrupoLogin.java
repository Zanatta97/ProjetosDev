package com.methasystems.pedidosandroidmethasystems.model;

public class GrupoLogin {

    private int codigo;
    private int codigoPk;
    private String nome;
    private boolean isAdmin;

    public GrupoLogin() {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
