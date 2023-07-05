package com.victxl.siteDeVendas.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Vendedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVendedor;

    private String usuario;
    private String email;
    private String senha;

    // Construtores, getters e setters

    public Vendedor() {
    }

    public Vendedor(String usuario, String email, String senha) {
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
