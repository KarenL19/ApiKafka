package com.portal.cursoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CursoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CursoApiApplication.class, args);
    }

}
