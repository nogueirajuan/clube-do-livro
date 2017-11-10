package com.each.cdl.integration;

import com.each.cdl.config.BookShareProperties;
import com.each.cdl.integration.responses.AnuncioResponse;
import com.each.cdl.integration.responses.LivroResponse;
import com.each.cdl.model.Anuncio;
import com.each.cdl.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Component
public class LivroIntegration {

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

    public Livro buscaLivroPorId(String id) {
        HashMap<String, String> map = new HashMap<>();

        map.put("id", id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = properties.getBookshareServer() + properties.getLivrosPrefix() + properties.getLivrosFindById();

        RestTemplate restTemplate = new RestTemplate();

        LivroResponse result = restTemplate.getForObject(url, LivroResponse.class, map);

        return result.getLivro();
    }

    public Livro cadastrarLivro(Livro livro){

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        HashMap<String, String> map = new HashMap<>();
        map.put("autor", livro.getAutor());
        map.put("descricao", livro.getDescricao());
        map.put("imagem", livro.getImagem());
        map.put("isbn", livro.getIsbn());
        map.put("titulo", livro.getTitulo());
        map.put("dataPublicacao", sdf.format(livro.getDataPublicacao()));

        String url = properties.getBookshareServer() + properties.getLivrosPrefix() + properties.getLivrosCadastrar();

        RestTemplate restTemplate = new RestTemplate();

        LivroResponse result = restTemplate.postForObject(url, livro, LivroResponse.class, map);

        return result.getLivro();
    }

    public List<Livro> findAll(){

        String url = properties.getBookshareServer() + properties.getLivrosPrefix() + "findAll";

        RestTemplate restTemplate = new RestTemplate();

        LivroResponse result = restTemplate.getForObject(url, LivroResponse.class);

        return result.getLivros();
    }

}
