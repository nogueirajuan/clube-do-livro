package com.each.cdl.controller;


import com.each.cdl.config.Constants;
import com.each.cdl.integration.AvaliacaoIntegration;
import com.each.cdl.model.Avaliacao;
import com.each.cdl.model.Categoria;
import com.each.cdl.model.Livro;
import com.each.cdl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    AvaliacaoIntegration avaliacaoIntegration;

    @Autowired
    HttpSession httpSession;

    @RequestMapping(value = "cadastrar-avaliacao-request", method = RequestMethod.POST)
    public ModelAndView cadastrarAvaliacaoRequest(@RequestParam Integer avaliacao,
                                              @RequestParam String descricao,
                                              @RequestParam String isbn,
                                              @RequestParam String idAnuncio) {

        ModelAndView mav = new ModelAndView("redirect:/livro/detalhe-livro?id=" + idAnuncio);

        Avaliacao novaAvaliacao = new Avaliacao();
        novaAvaliacao.setAnunciante((Usuario)httpSession.getAttribute(Constants.HTTP_SESSION_LEITOR));
        novaAvaliacao.setAvaliacao(avaliacao);
        novaAvaliacao.setDataPublicacao(new Date());
        novaAvaliacao.setDescricao(descricao);
        novaAvaliacao.setLivro(new Livro(isbn));

        avaliacaoIntegration.cadastrarAvaliacao(novaAvaliacao);

        return mav;
    }

    @RequestMapping(value = "delete-avaliacao", method = RequestMethod.POST)
    public ModelAndView cadastrarAvaliacaoRequest(@RequestParam Long id,
                                                  @RequestParam String idAnuncio) {

        ModelAndView mav = new ModelAndView("redirect:/livro/detalhe-livro?id=" + idAnuncio);

        avaliacaoIntegration.delete(id);

        return mav;
    }

}
