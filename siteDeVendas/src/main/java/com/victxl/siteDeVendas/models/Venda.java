package com.victxl.siteDeVendas.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;

    private double valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cliente_endereco_idendereco")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "vendedor_idvendedor")
    private Vendedor vendedor;

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
