/*
 * Portugal Telecom Inovação Brasil S/A
 * Class: BackofficeApplication
 *
 * Copyright (c) 2016. Portugal Telecom Inovação Brasil
 *
 * Created on Jan/2016
 * @author Bruno Cintra, Felipe Costa, Juan Nogueira
 */
package com.each.cdl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
public class Application extends SpringBootServletInitializer { 

    public static void main(String[] args) {
        configurarUnirest();
        SpringApplication springApplication = new SpringApplication(new Object[]{Application.class});
        springApplication.setRegisterShutdownHook(true);
        springApplication.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void configurarUnirest() {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
