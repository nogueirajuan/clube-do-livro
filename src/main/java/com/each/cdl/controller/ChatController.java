package com.each.cdl.controller;

import com.each.cdl.integration.ChatIntegration;
import com.each.cdl.integration.responses.MensagemResponse;
import com.each.cdl.model.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private ChatIntegration chatIntegration;

    @Autowired
    public ChatController(ChatIntegration chatIntegration) {
        this.chatIntegration = chatIntegration;
    }

    @PutMapping("/enviar-mensagem")
    public MensagemResponse enviarMensagem(@RequestParam("sender") String sender,
                                           @RequestParam("receiver") String receiver,
                                           @RequestParam("content") String content) {
        return chatIntegration.enviarMensagem(new Mensagem(sender, receiver, content, new Date()));
    }

    @GetMapping("/get-mensagens")
    public Mensagem[] getMensagens(@RequestParam("sender") String sender,
                                   @RequestParam("receiver") String receiver) {
        return chatIntegration.getMensagens(sender, receiver);
    }

    @GetMapping("/get-destinatarios")
    public String[] getDestinatarios(@RequestParam("sender") String sender) {
        return chatIntegration.getDestinatarios(sender);
    }

}
