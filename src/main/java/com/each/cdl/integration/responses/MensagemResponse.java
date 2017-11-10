package com.each.cdl.integration.responses;

import com.each.cdl.model.Mensagem;

public class MensagemResponse {
    private boolean sucesso;
    private Mensagem mensagem;

    public boolean isSucesso() {
        return sucesso;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public MensagemResponse(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public MensagemResponse(boolean sucesso, Mensagem mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }
}
