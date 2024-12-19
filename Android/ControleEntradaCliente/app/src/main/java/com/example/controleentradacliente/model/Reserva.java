package com.example.controleentradacliente.model;

import java.sql.Timestamp;

public class Reserva {

    private int id;
    private int idPk;
    private int idCliente;
    private String nomeClliente;
    private int idEmpresa;
    private int qtdPessoas;
    private Timestamp horaReserva;
    private String status;
    private String telefoneCliente;

    public Reserva(){

    }


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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public Timestamp getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(Timestamp horaReserva) {
        this.horaReserva = horaReserva;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getNomeClliente() {
        return nomeClliente;
    }

    public void setNomeClliente(String nomeClliente) {
        this.nomeClliente = nomeClliente;
    }
}
