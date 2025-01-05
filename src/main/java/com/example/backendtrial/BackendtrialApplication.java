package com.example.backendtrial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BackendtrialApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendtrialApplication.class, args);
    }

}
