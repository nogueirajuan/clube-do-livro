package com.each.cdl.controller;

import com.each.cdl.config.Constants;
import com.each.cdl.integration.ChatIntegration;
import com.each.cdl.model.Mensagem;
import com.each.cdl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("mensagem")
public class MensagemController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    ChatIntegration chatIntegration;

    @RequestMapping("mensagens")
    public ModelAndView mensagens(){

        ModelAndView mav = new ModelAndView("mensagens");
//        String[] destinatarios = chatIntegration.getDestinatarios(((Usuario) httpSession.getAttribute(Constants.HTTP_SESSION_LEITOR)).getUsername());
//
//        mav.addObject("chats", destinatarios);
        return mav;
    }

    @RequestMapping("chat")
    public ModelAndView chat(@RequestParam String user) {
        ModelAndView mav = new ModelAndView("chat");

//        Mensagem[] mensagens = chatIntegration.getMensagens(((Usuario) httpSession.getAttribute(Constants.HTTP_SESSION_LEITOR)).getUsername(), user);
//        mav.addObject("mensagens", mensagens);

        return mav;
    }

}
