package com.each.cdl.controller;

import com.each.cdl.integration.AnuncioIntegration;
import com.each.cdl.integration.LivroIntegration;
import com.each.cdl.integration.responses.AnuncioResponse;
import com.each.cdl.model.Anuncio;
import com.each.cdl.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroIntegration  livroIntegration;
    
    @Autowired
    AnuncioIntegration anuncioIntegration;


    @RequestMapping("meus-livros")
    public String meusLivros() {
        return "meus-livros";
    }

    @RequestMapping("detalhe-livro")
    public ModelAndView detalheLivro(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("detalhe-livro");


        AnuncioResponse anuncio = anuncioIntegration.buscaAnuncioPorId(id);

        mav.addObject("anuncio", anuncio);
        return mav;

    }

    @RequestMapping("cadastrar-livro")
    public String cadastrarLivro() {
        return "cadastrar-livro";
    }
}
