package com.each.cdl.integration;

import com.each.cdl.integration.responses.AnuncioResponse;
import com.each.cdl.integration.responses.LivroResponse;
import com.each.cdl.model.Anuncio;
import com.each.cdl.model.Livro;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Component
public class LivroIntegration {

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

    public Livro buscaLivroPorId(String id) {
        HashMap<String, String> map = new HashMap<>();

        map.put("id", id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = "http://localhost:9999/livros/find-by-id?id={id}";

        RestTemplate restTemplate = new RestTemplate();

        LivroResponse result = restTemplate.getForObject(url, LivroResponse.class, map);

        return result.getLivro();
    }

}
