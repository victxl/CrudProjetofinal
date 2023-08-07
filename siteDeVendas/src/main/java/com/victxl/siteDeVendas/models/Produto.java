package com.victxl.siteDeVendas.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idProduto;

    private String nome;
    private String descricao;
    private int quantidadeEstoque;
    private LocalDate dataCadastro;



    private boolean ativo;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "venda_cliente_idcliente")
    private Cliente vendaCliente;

    @ManyToOne
    @JoinColumn(name = "venda_cliente_endereco_idendereco")
    private Endereco vendaClienteEndereco;

    @ManyToOne
    @JoinColumn(name = "venda_vendedor_idvendedor")
    private Vendedor vendaVendedor;

    // Construtores, getters e setters


    public Produto(Long idProduto, String nome, String descricao, int quantidadeEstoque, Date dataCadastro, String categoria, String marca, String imagem, boolean ativo, double valor, Cliente vendaCliente, Endereco vendaClienteEndereco, Vendedor vendaVendedor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;



        this.ativo = ativo;
        this.valor = valor;
        this.vendaCliente = vendaCliente;
        this.vendaClienteEndereco = vendaClienteEndereco;
        this.vendaVendedor = vendaVendedor;
    }

    public Produto() {

    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getVendaCliente() {
        return vendaCliente;
    }

    public void setVendaCliente(Cliente vendaCliente) {
        this.vendaCliente = vendaCliente;
    }

    public Endereco getVendaClienteEndereco() {
        return vendaClienteEndereco;
    }

    public void setVendaClienteEndereco(Endereco vendaClienteEndereco) {
        this.vendaClienteEndereco = vendaClienteEndereco;
    }

    public Vendedor getVendaVendedor() {
        return vendaVendedor;
    }

    public void setVendaVendedor(Vendedor vendaVendedor) {
        this.vendaVendedor = vendaVendedor;
    }
}
