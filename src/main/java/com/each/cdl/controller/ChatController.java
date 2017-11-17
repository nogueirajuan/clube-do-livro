package com.each.cdl.controller;

import com.each.cdl.config.Constants;
import com.each.cdl.integration.ChatIntegration;
import com.each.cdl.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private ChatIntegration chatIntegration;

    @Autowired
    HttpSession httpSession;

    private static final Logger log = LoggerFactory.getLogger(ChatIntegration.class);

    @Autowired
    public ChatController(ChatIntegration chatIntegration) {
        this.chatIntegration = chatIntegration;
    }

//    @PutMapping("/enviar-mensagem")
//    public MensagemResponse enviarMensagem(@RequestParam("sender") String sender,
//                                           @RequestParam("receiver") String receiver,
//                                           @RequestParam("content") String content) {
//        return chatIntegration.enviarMensagem(new Mensagem(sender, receiver, content, new Date()));
//    }

    @GetMapping("/conversas")
    public ModelAndView conversas() {

        ModelAndView mav = new ModelAndView("chat");

        String[] destinatarios = chatIntegration.getDestinatarios(((Usuario) httpSession.getAttribute(Constants.HTTP_SESSION_LEITOR)).getUsername());

        mav.addObject("chats", destinatarios);
        return mav;
    }

//    @GetMapping("/get-mensagens")
//    public Mensagem[] getMensagens(@RequestParam("sender") String sender,
//                                   @RequestParam("receiver") String receiver) {
//        return chatIntegration.getMensagens(sender, receiver);
//    }
//
//    @GetMapping("/get-destinatarios")
//    public String[] getDestinatarios(@RequestParam("sender") String sender) {
//        return chatIntegration.getDestinatarios(sender);
//    }

}
