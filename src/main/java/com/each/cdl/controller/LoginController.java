package com.each.cdl.controller;

import com.each.cdl.integration.UserIntegration;
import com.each.cdl.integration.responses.LoginResponse;
import com.each.cdl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@ControllerAdvice
@Controller
public class LoginController {

    @Autowired
    UserIntegration userIntegration;

    @RequestMapping("login-request")
    public String loginRequest(HttpSession session){

        if (session != null
                && session.getAttribute("username") != null
                && !session.getAttribute("username").toString().isEmpty()) {
            return "/";
        }

        return "login/loginForm";

    }

}
