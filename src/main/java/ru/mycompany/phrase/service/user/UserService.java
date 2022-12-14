package ru.mycompany.phrase.service.user;

import org.springframework.http.ResponseEntity;
import ru.mycompany.phrase.domain.api.user.login.LoginReq;
import ru.mycompany.phrase.domain.api.user.publicPhrase.PublicPhraseReq;
import ru.mycompany.phrase.domain.api.user.registration.RegistrationReq;
import ru.mycompany.phrase.domain.response.Response;

public interface UserService {

    ResponseEntity<Response> getMyPhrases(String accessToken);

    ResponseEntity<Response> publicPhrase(PublicPhraseReq req, String accessToken);

    ResponseEntity<Response> login(LoginReq req);

    ResponseEntity<Response> registration(RegistrationReq req);
}
