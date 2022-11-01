package ru.mycompany.phrase.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mycompany.phrase.domen.response.Response;
import ru.mycompany.phrase.service.PhraseService;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("phrase-service-public")
public class Controller {

    private final PhraseService phraseService;


    @GetMapping("/hello")
    public String hello() {
        String hello = "Hello, phrase-service! Version: 1.0.0";
        log.info(hello);
        return hello;
    }


    @PostMapping("/test")
    public ResponseEntity<Response> test() {

        log.info("START endpoint test");
        ResponseEntity<Response> response = phraseService.test();
        log.info("END endpoint test, response: {}", response);
        return response;
    }
}
