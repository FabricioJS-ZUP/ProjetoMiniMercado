package br.com.zup.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private double preco;
    private String descricao;
    private String categoria;
    private int quantidadeemestoque;

    public Produtos() {
    }

    public Produtos(String categoria, String descricao, String nome, double preco, int quantidadeemestoque) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeemestoque = quantidadeemestoque;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeemestoque() {
        return quantidadeemestoque;
    }

    public void setQuantidadeemestoque(int quantidadeemestoque) {
        this.quantidadeemestoque = quantidadeemestoque;
    }
}