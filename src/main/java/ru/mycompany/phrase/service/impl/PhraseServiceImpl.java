package ru.mycompany.phrase.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domen.api.RegistrationReq;
import ru.mycompany.phrase.domen.response.Response;
import ru.mycompany.phrase.domen.response.SuccessResponse;
import ru.mycompany.phrase.service.PhraseService;
import ru.mycompany.phrase.util.ValidationUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhraseServiceImpl implements PhraseService {

    private final ValidationUtils validationUtils;



    @Override
    public ResponseEntity<Response> registration(RegistrationReq req) {

        validationUtils.validationRequest(req);
        return new ResponseEntity<Response>((SuccessResponse.builder().data("Ол райт, Христофор Бонифатьевич!").build()), HttpStatus.OK);
    }
}
