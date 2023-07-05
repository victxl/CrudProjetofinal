package com.victxl.siteDeVendas.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idProduto;

    private String nome;
    private String descricao;
    private int quantidadeEstoque;
    private Date dataCadastro;
    private String categoria;
    private String marca;
    private String imagem;
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
        this.dataCadastro = dataCadastro;
        this.categoria = categoria;
        this.marca = marca;
        this.imagem = imagem;
        this.ativo = ativo;
        this.valor = valor;
        this.vendaCliente = vendaCliente;
        this.vendaClienteEndereco = vendaClienteEndereco;
        this.vendaVendedor = vendaVendedor;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
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
