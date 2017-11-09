package com.each.cdl.integration;

import com.each.cdl.integration.responses.LoginResponse;
import com.each.cdl.model.Usuario;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Component
public class UserIntegration {

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

    public LoginResponse login(Usuario u){

        HashMap<String, String> map = new HashMap<>();
        map.put("username", u.getUsername());
        map.put("password", u.getSenha());

        String url = "http://localhost:9999/usuarios/login?username={username}&password={password}";

        RestTemplate rt = new RestTemplate();
        LoginResponse result = rt.postForObject(url, u, LoginResponse.class, map);

        return result;

    }

    public void cadastrarUsuario(Usuario u) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", u.getUsername());
        map.put("senha", u.getSenha());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = "http://localhost:9999/usuarios/cadastrar";

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<String>(u.toString(), headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);
    }

}
