package ru.mycompany.phrase.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domen.response.ErrorResponse;
import ru.mycompany.phrase.domen.response.Error;
import ru.mycompany.phrase.domen.response.Response;
import ru.mycompany.phrase.domen.response.SuccessResponse;
import ru.mycompany.phrase.service.PhraseService;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhraseServiceImpl implements PhraseService {

    @Override
    public ResponseEntity<Response> test() {

        return new ResponseEntity<>(SuccessResponse.builder().data("SuccessResponse").build(), HttpStatus.OK);
//        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code("VALIDATION_ERROR").message("Ошибка валидации").build()).build(), HttpStatus.BAD_REQUEST);
    }
}
