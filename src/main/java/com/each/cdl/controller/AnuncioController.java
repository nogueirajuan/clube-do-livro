package com.each.cdl.controller;

import com.each.cdl.integration.AnuncioIntegration;
import com.each.cdl.integration.LivroIntegration;
import com.each.cdl.integration.UserIntegration;
import com.each.cdl.model.Anuncio;
import com.each.cdl.model.Livro;
import com.each.cdl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/anuncio")
public class AnuncioController {


    @Autowired
    AnuncioIntegration anuncioIntegration;

    @Autowired
    LivroIntegration livroIntegration;

    @Autowired
    UserIntegration userIntegration;

    @RequestMapping("busca")
    public ModelAndView buscaAnuncio(@RequestParam String nome){
        return new ModelAndView("busca");
        
    }

    @RequestMapping("cadastrar-anuncio")
    public ModelAndView cadastrarAnuncio(){

        ModelAndView mav = new ModelAndView("cadastrar-anuncio");

        List<Livro> livros = livroIntegration.findAll();

        mav.addObject("livros", livros);
        return mav;

    }

    @RequestMapping("cadastrar-anuncio-request")
    public ModelAndView cadastrarAnuncioRequest(@RequestParam String descricao, @RequestParam String idLivro){

//
//        Anuncio novoAnuncio = new Anuncio();
//        novoAnuncio.setDescricao(descricao);
//        novoAnuncio.setLivro(new Livro(idLivro));

        anuncioIntegration.cadastrarAnuncio(descricao, idLivro, new Anuncio());

        return new ModelAndView("redirect:/livro/meus-livros");

    }


}
