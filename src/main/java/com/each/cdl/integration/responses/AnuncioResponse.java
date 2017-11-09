package com.each.cdl.integration.responses;

import com.each.cdl.model.Anuncio;
import com.each.cdl.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties
public class AnuncioResponse {
    @JsonProperty("sucesso")
    Boolean sucesso;
    @JsonProperty("dataExecucao")
    Date dataExecucao;
    @JsonProperty("anuncio")
    Anuncio anuncio;
    @JsonProperty("anuncios")
    List<Anuncio> anuncios;

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

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }
}
