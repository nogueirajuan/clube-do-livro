package com.each.cdl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mensagem")
public class MensagemController {

    @RequestMapping("mensagens")
    public String mensagens(){
        return "mensagens";
    }

    @RequestMapping("chat")
    public String chat() { return "chat"; }

}
