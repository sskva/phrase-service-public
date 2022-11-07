package ru.mycompany.phrase.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domen.constant.Code;
import ru.mycompany.phrase.domen.response.Response;
import ru.mycompany.phrase.domen.response.exception.CommonException;
import ru.mycompany.phrase.service.PhraseService;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhraseServiceImpl implements PhraseService {

    @Override
    public ResponseEntity<Response> test() {

//        int x = 1/0;
        throw CommonException.builder().code(Code.TEST).message("Test").httpStatus(HttpStatus.BAD_REQUEST).build();
    }
}
