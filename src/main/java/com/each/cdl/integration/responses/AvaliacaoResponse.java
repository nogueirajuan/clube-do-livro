package com.each.cdl.integration.responses;

import com.each.cdl.model.Avaliacao;
import com.each.cdl.model.Livro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties
public class AvaliacaoResponse {
    @JsonProperty("sucesso")
    Boolean sucesso;
    @JsonProperty("dataExecucao")
    Date dataExecucao;
    @JsonProperty("avaliacao")
    Avaliacao avaliacao;
    @JsonProperty("avaliacoes")
    List<Avaliacao> avaliacoes;

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

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
