package com.example.controleentradacliente.model;

import java.sql.Date;
import java.sql.Time;

public class Empresa {

    private int id;
    private int idPk;
    private String nome;
    private String cnpj;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String descricao;
    private Time horaAberturaSegunda;
    private Time horaFechamentoSegunda;
    private Time horaAberturaTerca;
    private Time horaFechamentoTerca;
    private Time horaAberturaQuarta;
    private Time horaFechamentoQuarta;
    private Time horaAberturaQuinta;
    private Time horaFechamentoQuinta;
    private Time horaAberturaSexta;
    private Time horaFechamentoSexta;
    private Time horaAberturaSabado;
    private Time horaFechamentoSabado;
    private Time horaAberturaDomingo;
    private Time horaFechamentoDomingo;
    private String tokenFirebase;
    private String email;
    private String senha;

    public Empresa() {

    };

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getIdPk() {
        return idPk;
    }

    public void setIdPk(int idPk) {
        this.idPk = idPk;
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Time getHoraAberturaSegunda() {
        return horaAberturaSegunda;
    }

    public void setHoraAberturaSegunda(Time horaAberturaSegunda) {
        this.horaAberturaSegunda = horaAberturaSegunda;
    }

    public Time getHoraFechamentoSegunda() {
        return horaFechamentoSegunda;
    }

    public void setHoraFechamentoSegunda(Time horaFechamentoSegunda) {
        this.horaFechamentoSegunda = horaFechamentoSegunda;
    }

    public Time getHoraAberturaTerca() {
        return horaAberturaTerca;
    }

    public void setHoraAberturaTerca(Time horaAberturaTerca) {
        this.horaAberturaTerca = horaAberturaTerca;
    }

    public Time getHoraFechamentoTerca() {
        return horaFechamentoTerca;
    }

    public void setHoraFechamentoTerca(Time horaFechamentoTerca) {
        this.horaFechamentoTerca = horaFechamentoTerca;
    }

    public Time getHoraAberturaQuarta() {
        return horaAberturaQuarta;
    }

    public void setHoraAberturaQuarta(Time horaAberturaQuarta) {
        this.horaAberturaQuarta = horaAberturaQuarta;
    }

    public Time getHoraFechamentoQuarta() {
        return horaFechamentoQuarta;
    }

    public void setHoraFechamentoQuarta(Time horaFechamentoQuarta) {
        this.horaFechamentoQuarta = horaFechamentoQuarta;
    }

    public Time getHoraAberturaQuinta() {
        return horaAberturaQuinta;
    }

    public void setHoraAberturaQuinta(Time horaAberturaQuinta) {
        this.horaAberturaQuinta = horaAberturaQuinta;
    }

    public Time getHoraFechamentoQuinta() {
        return horaFechamentoQuinta;
    }

    public void setHoraFechamentoQuinta(Time horaFechamentoQuinta) {
        this.horaFechamentoQuinta = horaFechamentoQuinta;
    }

    public Time getHoraAberturaSexta() {
        return horaAberturaSexta;
    }

    public void setHoraAberturaSexta(Time horaAberturaSexta) {
        this.horaAberturaSexta = horaAberturaSexta;
    }

    public Time getHoraFechamentoSexta() {
        return horaFechamentoSexta;
    }

    public void setHoraFechamentoSexta(Time horaFechamentoSexta) {
        this.horaFechamentoSexta = horaFechamentoSexta;
    }

    public Time getHoraAberturaSabado() {
        return horaAberturaSabado;
    }

    public void setHoraAberturaSabado(Time horaAberturaSabado) {
        this.horaAberturaSabado = horaAberturaSabado;
    }

    public Time getHoraFechamentoSabado() {
        return horaFechamentoSabado;
    }

    public void setHoraFechamentoSabado(Time horaFechamentoSabado) {
        this.horaFechamentoSabado = horaFechamentoSabado;
    }

    public Time getHoraAberturaDomingo() {
        return horaAberturaDomingo;
    }

    public void setHoraAberturaDomingo(Time horaAberturaDomingo) {
        this.horaAberturaDomingo = horaAberturaDomingo;
    }

    public Time getHoraFechamentoDomingo() {
        return horaFechamentoDomingo;
    }

    public void setHoraFechamentoDomingo(Time horaFechamentoDomingo) {
        this.horaFechamentoDomingo = horaFechamentoDomingo;
    }

    public String getTokenFirebase() {
        return tokenFirebase;
    }

    public void setTokenFirebase(String tokenFirebase) {
        this.tokenFirebase = tokenFirebase;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
