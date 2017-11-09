package com.each.cdl.integration.responses;

import com.each.cdl.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties
public class LoginResponse {
    @JsonProperty("sucesso")
    Boolean sucesso;
    @JsonProperty("dataExecucao")
    Date dataExecucao;
    @JsonProperty("usuario")
    Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
