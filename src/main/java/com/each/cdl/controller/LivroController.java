package com.each.cdl.controller;

import com.each.cdl.config.Constants;
import com.each.cdl.integration.*;
import com.each.cdl.integration.responses.AnuncioResponse;
import com.each.cdl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
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

    @Autowired
    UserIntegration userIntegration;

    @Autowired
    CategoriaIntegration categoriaIntegration;

    @Autowired
    AvaliacaoIntegration avaliacaoIntegration;

    @Autowired
    HttpSession httpSession;

    @RequestMapping("meus-livros")
    public ModelAndView meusLivros() {
        ModelAndView mav = new ModelAndView("meus-livros");

        AnuncioResponse anunciosUsername = anuncioIntegration.buscaAnuncioPorUsername(((Usuario)httpSession.getAttribute(Constants.HTTP_SESSION_LEITOR)).getUsername());
        mav.addObject("anuncios", anunciosUsername.getAnuncios());

        return mav;
    }

    @RequestMapping("detalhe-livro")
    public ModelAndView detalheLivro(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("detalhe-livro");


        AnuncioResponse anuncio = anuncioIntegration.buscaAnuncioPorId(id);
        AnuncioResponse anunciosCategoria = anuncioIntegration.buscaAnuncioPorCategoria(anuncio.getAnuncio().getLivro().getCategoria().getId());

        List<Anuncio> anuncios = anuncioIntegration.buscaAnuncios();

        String isbn = anuncio.getAnuncio().getLivro().getIsbn();
        List<Avaliacao> avaliacoes = avaliacaoIntegration.findAllByLivro(isbn);

        mav.addObject("anuncios", anuncios);
        mav.addObject("anuncio", anuncio.getAnuncio());
        mav.addObject("anunciosCategoria", anunciosCategoria.getAnuncios());
        mav.addObject("avaliacoes", avaliacoes);
        return mav;

    }

    @RequestMapping("cadastrar-livro")
    public ModelAndView cadastrarLivro() {
        ModelAndView mav = new ModelAndView("cadastrar-livro");

        List<Categoria> categorias = categoriaIntegration.findAll();

        mav.addObject("categorias", categorias);
        return mav;
    }

    @RequestMapping("/busca")
    public ModelAndView searchAnuncios(@RequestParam String nome) {
        ModelAndView mav = new ModelAndView("busca");

        List<Anuncio> anuncios = anuncioIntegration.buscaAnuncioPorNome(nome).getAnuncios();
        mav.addObject("anuncios", anuncios);
        return mav;
    }

    @RequestMapping("cadastrar-livro-request")
    public ModelAndView cadastrarLivroRequest(@RequestParam String titulo,
                                              @RequestParam String isbn,
                                              @RequestParam String autor,
                                              @RequestParam String descricao,
                                              @RequestParam String dataPublicacao,
                                              @RequestParam Long categoria,
                                              @RequestParam String foto) {

        ModelAndView mav = new ModelAndView("redirect:/anuncio/cadastrar-anuncio");
        Livro novoLivro = new Livro();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        novoLivro.setAutor(autor);
        novoLivro.setDataPublicacao("01/01/2017");
        novoLivro.setDescricao(descricao);
        novoLivro.setImagem(foto);
        novoLivro.setTitulo(titulo);
        novoLivro.setIsbn(isbn);
        novoLivro.setCategoria(new Categoria(categoria));

        Livro livro = livroIntegration.cadastrarLivro(novoLivro);

        return mav;
    }
}
