package ru.mycompany.phrase.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mycompany.phrase.domen.api.LoginReq;
import ru.mycompany.phrase.domen.api.PublicPhraseReq;
import ru.mycompany.phrase.domen.api.RegistrationReq;
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



    @PostMapping("/publicPhrase")
    public ResponseEntity<Response> publicPhrase(@RequestHeader String accessToken, @RequestBody final PublicPhraseReq req) {

        log.info("START endpoint publicPhrase, accessToken: {}, request: {}", accessToken, req);
        ResponseEntity<Response> resp = phraseService.publicPhrase(req, accessToken);
        log.info("END endpoint publicPhrase, response: {}", resp);
        return resp;
    }



    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody final LoginReq req) {

        log.info("START endpoint login, request: {}", req);
        ResponseEntity<Response> resp = phraseService.login(req);
        log.info("END endpoint login, response: {}", resp);
        return resp;
    }



    @PostMapping("/registration")
    public ResponseEntity<Response> registration(@RequestBody final RegistrationReq req) {

        log.info("START endpoint registration, request: {}", req);
        ResponseEntity<Response> resp = phraseService.registration(req);
        log.info("END endpoint registration, response: {}", resp);
        return resp;
    }
}
