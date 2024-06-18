package com.project.peixelandia.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "peixes")
public class Peixes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 200, name = "imagem1")
    private String imagem1;

    @Column(length = 200, name = "imagem2")
    private String imagem2;

    @Column(length = 50, name = "nome")
    private String nome;

    @Column(length = 50, name = "nome_cientifico")
    private String nome_cientifico;

    @Column(length = 1000, name = "descricao")
    private String descricao;

    @Column(length = 50, name = "tipo_de_agua")
    private String tipo_de_agua;

    @Column(length = 50, name = "tamanho")
    private String tamanho;

    @Column(length = 200, name = "paises")
    private String paises;

    @Column(length = 50, name = "cor")
    private String cor;

    @Column(length = 50, name = "temperamento")
    private String temperamento;

    @Column(length = 245, name = "title")
    private String title;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_cientifico() {
        return nome_cientifico;
    }

    public void setNome_cientifico(String nome_cientifico) {
        this.nome_cientifico = nome_cientifico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo_de_agua() {
        return tipo_de_agua;
    }

    public void setTipo_de_agua(String tipo_de_agua) {
        this.tipo_de_agua = tipo_de_agua;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getPaises() {
        return paises;
    }

    public void setPaises(String paises) {
        this.paises = paises;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }
}
