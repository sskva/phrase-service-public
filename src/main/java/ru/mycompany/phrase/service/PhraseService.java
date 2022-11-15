package ru.mycompany.phrase.service;

import org.springframework.http.ResponseEntity;
import ru.mycompany.phrase.domain.api.LoginReq;
import ru.mycompany.phrase.domain.api.PublicPhraseReq;
import ru.mycompany.phrase.domain.api.RegistrationReq;
import ru.mycompany.phrase.domain.response.Response;

public interface PhraseService {

    ResponseEntity<Response> getMyPhrases(String accessToken);

    ResponseEntity<Response> publicPhrase(PublicPhraseReq req, String accessToken);

    ResponseEntity<Response> login(LoginReq req);

    ResponseEntity<Response> registration(RegistrationReq req);
}
