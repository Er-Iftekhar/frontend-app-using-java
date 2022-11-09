package com.app.javabackend.controller;

import com.app.javabackend.dto.Process;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    @PostMapping(path = "/process", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProcess(@RequestBody Process process){
        System.out.println("Recieved process here"+process);
    }
}
