package com.each.cdl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookShareProperties {

    /* Bookshare Server */
    @Value("${bookshare-server}")
    private String bookshareServer;

    /* Anuncios */
    @Value("${bookshare-server.anuncios.prefix}")
    private String anunciosPrefix;

    @Value("${bookshare-server.anuncios.find-all}")
    private String anunciosFindAll;

    @Value("${bookshare-server.anuncios.find-by-id}")
    private String anunciosFindById;

    /* Livros */
    @Value("${bookshare-server.livros.prefix}")
    private String livrosPrefix;

    @Value("${bookshare-server.livros.find-by-id}")
    private String livrosFindById;

    /* Usuarios */
    @Value("${bookshare-server.usuarios.prefix}")
    private String usuariosPrefix;

    @Value("${bookshare-server.usuarios.login}")
    private String usuariosLogin;

    @Value("${bookshare-server.usuarios.cadastrar}")
    private String usuariosCadastrar;

    /* chat */

    public String getBookshareServer() {
        return bookshareServer;
    }

    public void setBookshareServer(String bookshareServer) {
        this.bookshareServer = bookshareServer;
    }

    public String getAnunciosPrefix() {
        return anunciosPrefix;
    }

    public void setAnunciosPrefix(String anunciosPrefix) {
        this.anunciosPrefix = anunciosPrefix;
    }

    public String getAnunciosFindAll() {
        return anunciosFindAll;
    }

    public void setAnunciosFindAll(String anunciosFindAll) {
        this.anunciosFindAll = anunciosFindAll;
    }

    public String getAnunciosFindById() {
        return anunciosFindById;
    }

    public void setAnunciosFindById(String anunciosFindById) {
        this.anunciosFindById = anunciosFindById;
    }

    public String getLivrosPrefix() {
        return livrosPrefix;
    }

    public void setLivrosPrefix(String livrosPrefix) {
        this.livrosPrefix = livrosPrefix;
    }

    public String getLivrosFindById() {
        return livrosFindById;
    }

    public void setLivrosFindById(String livrosFindById) {
        this.livrosFindById = livrosFindById;
    }

    public String getUsuariosPrefix() {
        return usuariosPrefix;
    }

    public void setUsuariosPrefix(String usuariosPrefix) {
        this.usuariosPrefix = usuariosPrefix;
    }

    public String getUsuariosLogin() {
        return usuariosLogin;
    }

    public void setUsuariosLogin(String usuariosLogin) {
        this.usuariosLogin = usuariosLogin;
    }

    public String getUsuariosCadastrar() {
        return usuariosCadastrar;
    }

    public void setUsuariosCadastrar(String usuariosCadastrar) {
        this.usuariosCadastrar = usuariosCadastrar;
    }
}
