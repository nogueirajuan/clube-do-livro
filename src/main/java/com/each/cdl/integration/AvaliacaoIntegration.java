package com.each.cdl.integration;

import com.each.cdl.config.BookShareProperties;
import com.each.cdl.integration.responses.AnuncioResponse;
import com.each.cdl.integration.responses.AvaliacaoResponse;
import com.each.cdl.integration.responses.LivroResponse;
import com.each.cdl.model.Anuncio;
import com.each.cdl.model.Avaliacao;
import com.each.cdl.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Component
public class AvaliacaoIntegration {

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

    public AnuncioResponse buscaAnuncioPorIdLivro(String isbn) {
        HashMap<String, String> map = new HashMap<>();
        map.put("isbn", isbn);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = properties.getBookshareServer() + properties.getAnunciosPrefix() + properties.getAnunciosFindById();

        RestTemplate restTemplate = new RestTemplate();

        AnuncioResponse result = restTemplate.getForObject(url, AnuncioResponse.class, map);

        return result;
    }

    public List<Avaliacao> findAllByLivro(String isbn){

        HashMap<String, String> map = new HashMap<>();
        map.put("isbn", isbn);

        String url = properties.getBookshareServer() + properties.getAvaliacaoPrefix() + properties.getAvaliacaoFindByLivro();

        RestTemplate restTemplate = new RestTemplate();

        AvaliacaoResponse result = restTemplate.getForObject(url, AvaliacaoResponse.class, map);

        return result.getAvaliacoes();
    }

    public void cadastrarAvaliacao(Avaliacao avaliacao) {
        HashMap<String, String> map = new HashMap<>();
        map.put("descricao", avaliacao.getDescricao());
        map.put("username", avaliacao.getAnunciante().getUsername());
        map.put("avaliacao", avaliacao.getAvaliacao().toString());
        map.put("isbn", avaliacao.getLivro().getIsbn());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = properties.getBookshareServer() + properties.getAvaliacaoPrefix() + properties.getAvaliacaoCadastrar();

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(url, avaliacao, AnuncioResponse.class, map);
    }

    public void delete(Long id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = properties.getBookshareServer() + properties.getAvaliacaoPrefix() + properties.getAvaliacaoDelete();

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(url, id, AnuncioResponse.class, map);
    }

}
