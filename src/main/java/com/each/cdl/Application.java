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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application extends SpringBootServletInitializer { 

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(new Object[]{Application.class});
        springApplication.setRegisterShutdownHook(true);
        springApplication.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
