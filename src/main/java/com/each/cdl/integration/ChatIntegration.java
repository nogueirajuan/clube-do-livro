package com.each.cdl.integration;

import com.each.cdl.config.BookShareProperties;
import com.each.cdl.integration.responses.MensagemResponse;
import com.each.cdl.model.Mensagem;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ChatIntegration {
    final BookShareProperties properties;

    @Autowired
    public ChatIntegration(BookShareProperties properties) {
        this.properties = properties;
    }

    public MensagemResponse enviarMensagem(Mensagem mensagem) {
        try {
            return Unirest
                    .post(properties.getBookshareServer() + properties.getChatPrefix() + properties.getChatEnviarMensagem())
                    .header("Content-Type", "application/json")
                    .body(mensagem)
                    .asObject(MensagemResponse.class)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return new MensagemResponse(false);
        }
    }

    public Mensagem[] getMensagens(String sender, String receiver) {
        try {
            return Unirest
                    .get(properties.getBookshareServer() + properties.getChatPrefix() + properties.getChatGetMensagens())
                    .queryString("sender", sender)
                    .queryString("receiver", receiver)
                    .asObject(Mensagem[].class)
                    .getBody();

        } catch (UnirestException e) {
            e.printStackTrace();
            return new Mensagem[0];
        }
    }

    public String[] getDestinatarios(String sender) {
        try {
            return Unirest
                    .get(properties.getBookshareServer() + properties.getChatPrefix() + properties.getChatGetDestinatarios())
                    .queryString("sender", sender)
                    .asObject(String[].class)
                    .getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

}
