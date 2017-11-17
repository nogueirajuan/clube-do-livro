package com.each.cdl.integration;

import com.each.cdl.config.BookShareProperties;
import com.each.cdl.integration.responses.CategoriaResponse;
import com.each.cdl.integration.responses.LoginResponse;
import com.each.cdl.integration.responses.UsuarioResponse;
import com.each.cdl.model.Categoria;
import com.each.cdl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Component
public class CategoriaIntegration {

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

    public List<Categoria> findAll() {

        String url = properties.getBookshareServer() + properties.getCategoriaPrefix() + properties.getCategoriaFindAll();

        CategoriaResponse categorias = new CategoriaResponse();
        RestTemplate restTemplate = new RestTemplate();

        try {
            categorias = restTemplate.getForObject(url, CategoriaResponse.class);

        } catch (HttpClientErrorException ex) {
            return null;
        }

        return categorias.getCategorias();
    }

}
