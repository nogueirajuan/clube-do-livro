package com.each.cdl.integration;

import com.each.cdl.config.BookShareProperties;
import com.each.cdl.integration.responses.AnuncioResponse;
import com.each.cdl.integration.responses.LoginResponse;
import com.each.cdl.model.Anuncio;
import com.each.cdl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Component
public class AnuncioIntegration {

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

    public List<Anuncio> buscaAnuncios() {
        HashMap<String, String> map = new HashMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = properties.getBookshareServer() + properties.getAnunciosPrefix() + properties.getAnunciosFindAll();

        RestTemplate restTemplate = new RestTemplate();

        AnuncioResponse result = restTemplate.getForObject(url, AnuncioResponse.class);

        return result.getAnuncios();
    }

    public AnuncioResponse buscaAnuncioPorId(String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = properties.getBookshareServer() + properties.getAnunciosPrefix() + properties.getAnunciosFindById();

        RestTemplate restTemplate = new RestTemplate();

        AnuncioResponse result = restTemplate.getForObject(url, AnuncioResponse.class, map);

        return result;
    }

    public AnuncioResponse buscaAnuncioPorUsername(String username) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = properties.getBookshareServer() + properties.getAnunciosPrefix() + properties.getAnunciosFindByUsername();

        RestTemplate restTemplate = new RestTemplate();

        AnuncioResponse result = restTemplate.getForObject(url, AnuncioResponse.class, map);

        return result;
    }

    public AnuncioResponse cadastrarAnuncio(Anuncio anuncio) {
        HashMap<String, String> map = new HashMap<>();
        map.put("idLivro", anuncio.getLivro().getIsbn());
        map.put("anunciante", anuncio.getAnunciante().getUsername());
        map.put("descricao", anuncio.getDescricao());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = properties.getBookshareServer() + properties.getAnunciosPrefix() + properties.getAnunciosCadastrar();

        RestTemplate restTemplate = new RestTemplate();

        AnuncioResponse result = restTemplate.postForObject(url, anuncio, AnuncioResponse.class, map);

        return result;
    }

}
