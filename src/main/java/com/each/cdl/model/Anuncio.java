package com.each.cdl.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Anuncio {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("livro")
    private Livro livro;
    @JsonProperty("anunciante")
    private Usuario anunciante;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("valor")
    private Long valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Usuario anunciante) {
        this.anunciante = anunciante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "id=" + id +
                ", livro=" + livro +
                ", anunciante=" + anunciante +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
