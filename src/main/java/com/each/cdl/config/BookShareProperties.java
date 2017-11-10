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

    @Value("${bookshare-server.anuncios.find-by-username}")
    private String anunciosFindByUsername;

    @Value("${bookshare-server.anuncios.create}")
    private String anunciosCadastrar;

    /* Livros */
    @Value("${bookshare-server.livros.prefix}")
    private String livrosPrefix;

    @Value("${bookshare-server.livros.find-by-id}")
    private String livrosFindById;

    @Value("${bookshare-server.livros.cadastrar}")
    private String livrosCadastrar;

    /* Usuarios */
    @Value("${bookshare-server.usuarios.prefix}")
    private String usuariosPrefix;

    @Value("${bookshare-server.usuarios.login}")
    private String usuariosLogin;

    @Value("${bookshare-server.usuarios.cadastrar}")
    private String usuariosCadastrar;

    @Value("${bookshare-server.usuarios.find-by-id}")
    private String usuariosFindById;

    @Value("${bookshare-server.usuarios.find-by-username}")
    private String usuariosFindByUsername;

    /* chat */
    @Value("${bookshare-server.chat.prefix}")
    private String chatPrefix;
    @Value("${bookshare-server.chat.enviar}")
    private String chatEnviarMensagem;
    @Value("${bookshare-server.chat.mensagens}")
    private String chatGetMensagens;
    @Value("${bookshare-server.chat.destinatarios}")
    private String chatGetDestinatarios;

    public void setChatPrefix(String chatPrefix) {
        this.chatPrefix = chatPrefix;
    }

    public void setChatEnviarMensagem(String chatEnviarMensagem) {
        this.chatEnviarMensagem = chatEnviarMensagem;
    }

    public void setChatGetMensagens(String chatGetMensagens) {
        this.chatGetMensagens = chatGetMensagens;
    }

    public void setChatGetDestinatarios(String chatGetDestinatarios) {
        this.chatGetDestinatarios = chatGetDestinatarios;
    }

    public String getChatPrefix() {
        return chatPrefix;
    }

    public String getChatEnviarMensagem() {
        return chatEnviarMensagem;
    }

    public String getChatGetMensagens() {
        return chatGetMensagens;
    }

    public String getChatGetDestinatarios() {
        return chatGetDestinatarios;
    }

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

    public String getUsuariosFindById() {
        return usuariosFindById;
    }

    public void setUsuariosFindById(String usuariosFindById) {
        this.usuariosFindById = usuariosFindById;
    }

    public String getUsuariosFindByUsername() {
        return usuariosFindByUsername;
    }

    public void setUsuariosFindByUsername(String usuariosFindByUsername) {
        this.usuariosFindByUsername = usuariosFindByUsername;
    }

    public String getLivrosCadastrar() {
        return livrosCadastrar;
    }

    public void setLivrosCadastrar(String livrosCadastrar) {
        this.livrosCadastrar = livrosCadastrar;
    }

    public String getAnunciosFindByUsername() {
        return anunciosFindByUsername;
    }

    public void setAnunciosFindByUsername(String anunciosFindByUsername) {
        this.anunciosFindByUsername = anunciosFindByUsername;
    }

    public String getAnunciosCadastrar() {
        return anunciosCadastrar;
    }

    public void setAnunciosCadastrar(String anunciosCadastrar) {
        this.anunciosCadastrar = anunciosCadastrar;
    }
}
