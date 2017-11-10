package com.each.cdl.integration;

import com.each.cdl.config.BookShareProperties;
import com.each.cdl.integration.responses.LoginResponse;
import com.each.cdl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.HashMap;

@Component
public class UserIntegration {

    @Autowired
    BookShareProperties properties;

    private HttpHeaders getDefaultHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "application/json");
        return httpHeaders;
    }

    private ResponseEntity starkTowerRequest(String uri, Class classType, HashMap<String, String> parameters) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, getDefaultHeaders());

        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                classType);
    }

    public LoginResponse login(Usuario u) {

        HashMap<String, String> map = new HashMap<>();
        map.put("username", u.getUsername());
        map.put("password", u.getSenha());

        String url = properties.getBookshareServer() + properties.getUsuariosPrefix() + properties.getUsuariosLogin();

        RestTemplate rt = new RestTemplate();
        LoginResponse result = rt.postForObject(url, u, LoginResponse.class, map);

        return result;
    }

    public Usuario cadastrarUsuario(Usuario u) {
        HashMap<String, String> map = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        map.put("dataNascimento", sdf.format(u.getDataNascimento()));
        map.put("email", u.getEmail());
        map.put("nome", u.getNome());
        map.put("sobrenome", u.getSobrenome());
        map.put("username", u.getUsername());
        map.put("senha", u.getSenha());

        String url = properties.getBookshareServer() + properties.getUsuariosPrefix() + properties.getUsuariosCadastrar();

        Usuario newUser = new Usuario();
        RestTemplate restTemplate = new RestTemplate();

        try {
            newUser = restTemplate.postForObject(url, u, Usuario.class, map);

        } catch (HttpClientErrorException ex) {
            return null;
        }

        return newUser;
    }

    public Usuario findUserByUsername(String username) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);

        String url = properties.getBookshareServer() + properties.getUsuariosPrefix() + properties.getUsuariosFindByUsername();

        Usuario newUser = new Usuario();
        RestTemplate restTemplate = new RestTemplate();

        try {
            newUser = restTemplate.getForObject(url, Usuario.class, map);

        } catch (HttpClientErrorException ex) {
            return null;
        }

        return newUser;
    }

}
