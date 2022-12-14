package ru.mycompany.phrase.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mycompany.phrase.domain.api.user.login.LoginReq;
import ru.mycompany.phrase.domain.api.user.publicPhrase.PublicPhraseReq;
import ru.mycompany.phrase.domain.api.user.registration.RegistrationReq;
import ru.mycompany.phrase.domain.response.Response;
import ru.mycompany.phrase.service.user.UserService;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("phrase-service-public/user")
public class UserController {

    private final UserService userService;



    @GetMapping("/hello")
    public String hello() {
        String hello = "Hello, phrase-service! Version: 1.0.0";
        log.info(hello);
        return hello;
    }



    @GetMapping("/getMyPhrases")
    public ResponseEntity<Response> getMyPhrases(@RequestHeader final String accessToken) {

        log.info("START endpoint getMyPhrases, accessToken: {}", accessToken);
        ResponseEntity<Response> resp = userService.getMyPhrases(accessToken);
        log.info("END endpoint getMyPhrases, response: {}", resp);
        return resp;
    }



    @PostMapping("/publicPhrase")
    public ResponseEntity<Response> publicPhrase(@RequestHeader final String accessToken, @RequestBody final PublicPhraseReq req) {

        log.info("START endpoint publicPhrase, accessToken: {}, request: {}", accessToken, req);
        ResponseEntity<Response> resp = userService.publicPhrase(req, accessToken);
        log.info("END endpoint publicPhrase, response: {}", resp);
        return resp;
    }



    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody final LoginReq req) {

        log.info("START endpoint login, request: {}", req);
        ResponseEntity<Response> resp = userService.login(req);
        log.info("END endpoint login, response: {}", resp);
        return resp;
    }



    @PostMapping("/registration")
    public ResponseEntity<Response> registration(@RequestBody final RegistrationReq req) {

        log.info("START endpoint registration, request: {}", req);
        ResponseEntity<Response> resp = userService.registration(req);
        log.info("END endpoint registration, response: {}", resp);
        return resp;
    }
}
