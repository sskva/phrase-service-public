package ru.mycompany.phrase.service;

import org.springframework.http.ResponseEntity;
import ru.mycompany.phrase.domen.api.LoginReq;
import ru.mycompany.phrase.domen.api.PublicPhraseReq;
import ru.mycompany.phrase.domen.api.RegistrationReq;
import ru.mycompany.phrase.domen.response.Response;

public interface PhraseService {

    ResponseEntity<Response> publicPhrase(PublicPhraseReq req, String accessToken);

    ResponseEntity<Response> login(LoginReq req);

    ResponseEntity<Response> registration(RegistrationReq req);
}
