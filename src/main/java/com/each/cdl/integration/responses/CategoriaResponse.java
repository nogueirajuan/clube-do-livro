package com.each.cdl.integration.responses;

import com.each.cdl.model.Categoria;
import com.each.cdl.model.Livro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties
public class CategoriaResponse {
    @JsonProperty("sucesso")
    Boolean sucesso;
    @JsonProperty("dataExecucao")
    Date dataExecucao;
    @JsonProperty("categorias")
    List<Categoria> categorias;

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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
