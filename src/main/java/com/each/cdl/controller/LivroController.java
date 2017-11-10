package com.each.cdl.controller;

import com.each.cdl.integration.AnuncioIntegration;
import com.each.cdl.integration.LivroIntegration;
import com.each.cdl.integration.responses.AnuncioResponse;
import com.each.cdl.model.Anuncio;
import com.each.cdl.model.Livro;
import com.each.cdl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroIntegration livroIntegration;

    @Autowired
    AnuncioIntegration anuncioIntegration;

    HttpSession httpSession;

    @RequestMapping("meus-livros")
    public ModelAndView meusLivros() {
        ModelAndView mav = new ModelAndView("meus-livros");

        AnuncioResponse anunciosUsername = anuncioIntegration.buscaAnuncioPorUsername(((Usuario) httpSession.getAttribute("user")).getUsername());
        mav.addObject("anuncios", anunciosUsername.getAnuncios());
        return mav;
    }

    @RequestMapping("detalhe-livro")
    public ModelAndView detalheLivro(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("detalhe-livro");


        AnuncioResponse anuncio = anuncioIntegration.buscaAnuncioPorId(id);

        List<Anuncio> anuncios = anuncioIntegration.buscaAnuncios();
        mav.addObject("anuncios", anuncios);
        mav.addObject("anuncio", anuncio.getAnuncio());
        return mav;

    }

    @RequestMapping("cadastrar-livro")
    public String cadastrarLivro() {
        return "cadastrar-livro";
    }

    @RequestMapping("/busca")
    public ModelAndView searchAnuncios() {
        ModelAndView mav = new ModelAndView("busca");

        List<Anuncio> anuncios = anuncioIntegration.buscaAnuncios();
        mav.addObject("anuncios", anuncios);
        return mav;
    }

    @RequestMapping("cadastrar-livro-request")
    public ModelAndView cadastrarLivroRequest(@RequestParam String titulo,
                                              @RequestParam String isbn,
                                              @RequestParam String autor,
                                              @RequestParam String descricao,
                                              @RequestParam Date dataPublicacao,
                                              @RequestParam String foto) {

        ModelAndView mav = new ModelAndView("redirect:/livro/meus-livros");
        Livro novoLivro = new Livro();

        novoLivro.setAutor(autor);
        novoLivro.setDataPublicacao(dataPublicacao.toString());
        novoLivro.setDescricao(descricao);
        novoLivro.setImagem(foto);
        novoLivro.setTitulo(titulo);
        novoLivro.setIsbn(isbn);

        Livro livro = livroIntegration.cadastrarLivro(novoLivro);

        return mav;
    }
}
