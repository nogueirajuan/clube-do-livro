package com.each.cdl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/anuncio")
public class AnuncioController {

    @RequestMapping("busca")
    public ModelAndView buscaAnuncio(@RequestParam String nome){
        return new ModelAndView("busca");
    }

}
