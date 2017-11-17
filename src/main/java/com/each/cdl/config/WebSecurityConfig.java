package com.each.cdl.config;

import com.each.cdl.controller.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionFixation()
                .migrateSession()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .maximumSessions(1)
                .expiredUrl("/");
//
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/setup/init").authenticated()
                .antMatchers("/anuncio/cadastrar-anuncio").authenticated()
                .antMatchers("/livro/cadastrar-livro").authenticated()
                .antMatchers("/livro/meus-livros").authenticated()
                .antMatchers("/mensagem/mensagens").authenticated()
                .antMatchers("/mensagem/chat").authenticated()
                .antMatchers("/usuario/meu-cadastro").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").successForwardUrl("/setup/init")
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .permitAll();

        http.csrf().disable();
    }
}
