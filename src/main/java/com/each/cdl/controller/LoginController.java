package com.each.cdl.controller;

import com.each.cdl.config.Constants;
import com.each.cdl.integration.UserIntegration;
import com.each.cdl.integration.responses.LoginResponse;
import com.each.cdl.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@ControllerAdvice
@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserIntegration userIntegration;

    @RequestMapping("/login")
    public String loginRequest(HttpSession session){

        log.debug("usuário logado: " + session.getAttribute("user"));

        if (session != null
                && session.getAttribute(Constants.HTTP_SESSION_LEITOR) != null
                && !session.getAttribute(Constants.HTTP_SESSION_LEITOR).toString().isEmpty()) {
            return "redirect:/";
        }

        return "login/loginForm";
    }

}
