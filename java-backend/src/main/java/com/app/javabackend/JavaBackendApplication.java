package com.app.javabackend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@SpringBootApplication
public class JavaBackendApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(JavaBackendApplication.class, args);


    }

}
