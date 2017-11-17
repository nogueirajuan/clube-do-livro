package com.each.cdl.controller;

import com.each.cdl.config.Constants;
import com.each.cdl.integration.UserIntegration;
import com.each.cdl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@ControllerAdvice
@Controller
@RequestMapping("/setup")
public class SetupController {

    @Autowired
    UserIntegration userIntegration;

    @Autowired
    HttpSession session;

    @RequestMapping("/init")
    public ModelAndView init(RedirectAttributes ra){

        ModelAndView mav = new ModelAndView("redirect:/");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        Usuario user = userIntegration.findUserByUsername(username);

        session.setAttribute(Constants.HTTP_SESSION_LEITOR, user);

        return mav;
    }
}
