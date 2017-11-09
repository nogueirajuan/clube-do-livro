package com.each.cdl.controller;

import com.each.cdl.integration.UserIntegration;
import com.each.cdl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UserIntegration userIntegration;

    @RequestMapping("meu-cadastro")
    public String meuCadastro() {
        return "meu-cadastro";
    }

    @RequestMapping(value = "cadastrar-usuario", method = RequestMethod.GET)
    public ModelAndView cadastrarUsuario(@RequestParam String nome, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataNascimento, @RequestParam String sobrenome, @RequestParam String email, @RequestParam String username, @RequestParam String senha) {

        ModelAndView mav = new ModelAndView("redirect:/login");

        Usuario u = new Usuario();
        u.setDataNascimento(dataNascimento);
        u.setEmail(email);
        u.setNome(nome);
        u.setSobrenome(sobrenome);
        u.setUsername(username);

        userIntegration.cadastrarUsuario(u);

        return mav;
    }

}
