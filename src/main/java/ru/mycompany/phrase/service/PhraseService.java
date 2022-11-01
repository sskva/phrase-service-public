package ru.mycompany.phrase.service;

import org.springframework.http.ResponseEntity;
import ru.mycompany.phrase.domen.response.Response;

public interface PhraseService {

    ResponseEntity<Response> test();
}
