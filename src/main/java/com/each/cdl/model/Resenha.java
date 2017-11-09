package com.each.cdl.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Resenha {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("livro")
    private Livro livro;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("imagem")
    private String imagem;
    @JsonProperty("texto")
    private String texto;
    @JsonProperty("autor")
    private Usuario autor;

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}
