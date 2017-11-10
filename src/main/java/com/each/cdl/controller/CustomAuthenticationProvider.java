/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.cdl.controller;

import com.each.cdl.integration.UserIntegration;
import com.each.cdl.integration.responses.LoginResponse;
import com.each.cdl.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author victorluni
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final String LOG_PREFIX = "[CUSTOM-AUTHENTICATION-PROVIDER]";

    private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    UserIntegration userIntegration;

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {


        Usuario u = new Usuario();
        u.setUsername(a.getName());
        u.setSenha(a.getCredentials().toString());

        if (u.getUsername() == null || u.getSenha() == null || u.getSenha().equals("")) {
            throw new BadCredentialsException("invalid login or password");
        }

        LoginResponse login = userIntegration.login(u);

        if (login.getSucesso()) {

            List<GrantedAuthority> granted = new ArrayList<>();

            granted.add(new SimpleGrantedAuthority("leitor"));
            return new UsernamePasswordAuthenticationToken(u.getUsername(), a.getCredentials().toString(), granted);
        }else{
            log.error(LOG_PREFIX + "[MESSAGE]-[{}]", "User not found");
            throw new BadCredentialsException("User not found");
        }

    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
}
