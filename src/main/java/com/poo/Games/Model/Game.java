package com.poo.Games.Model;

public class Game {
    private String nome;
    private int id, anoLancamento;
    private double preco;

    public Game(){};

    public Game(int id, String nome, int anoLancamento, double preco) {
        this.nome = nome;
        this.id = id;
        this.anoLancamento = anoLancamento;
        this.preco = preco;
    }

    public Game(String nome, int anoLancamento, double preco) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
