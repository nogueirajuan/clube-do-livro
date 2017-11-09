package com.each.cdl.integration.responses;

import com.each.cdl.model.Anuncio;
import com.each.cdl.model.Livro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties
public class LivroResponse {
    @JsonProperty("sucesso")
    Boolean sucesso;
    @JsonProperty("dataExecucao")
    Date dataExecucao;
    @JsonProperty("livro")
    Livro livro;
    @JsonProperty("livros")
    List<Livro> livros;


    public Boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
