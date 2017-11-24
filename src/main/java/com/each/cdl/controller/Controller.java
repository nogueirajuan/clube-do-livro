/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.cdl.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.each.cdl.integration.AnuncioIntegration;
import com.each.cdl.model.Anuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author juan_
 */
@org.springframework.stereotype.Controller
public class Controller {

    private static final Logger log = Logger.getLogger(Controller.class.getName());

    @Autowired
    AnuncioIntegration anuncioIntegration;

    @Autowired
    HttpSession httpSession;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");
        log.log(Level.INFO, "[CHAIN RESERVAS]-[PAGE REQUEST]-[INDEX]");

        List<Anuncio> anuncios = anuncioIntegration.buscaAnuncios();
        List<Anuncio> anunciosMaisAvaliados = anuncioIntegration.buscaAnunciosMaisAvaliados();


        mav.addObject("anuncios", anuncios);
        mav.addObject("anunciosMaisAvaliados", anunciosMaisAvaliados);
        return mav;
    }
}
