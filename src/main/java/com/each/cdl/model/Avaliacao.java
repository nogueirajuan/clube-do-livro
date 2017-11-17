package com.each.cdl.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties
public class Avaliacao {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("livro")
    private Livro livro;
    @JsonProperty("anunciante")
    private Usuario anunciante;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("avaliacao")
    private Integer avaliacao;
    @JsonProperty("dataPublicacao")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dataPublicacao;

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

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", livro=" + livro +
                ", anunciante=" + anunciante +
                ", descricao='" + descricao + '\'' +
                ", avaliacao=" + avaliacao +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }
}
