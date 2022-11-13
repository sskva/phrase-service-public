package ru.mycompany.phrase.domen.response.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.mycompany.phrase.domen.constant.Code;
import ru.mycompany.phrase.domen.response.error.Error;
import ru.mycompany.phrase.domen.response.error.ErrorResponse;

import java.util.Optional;

@Slf4j
@ControllerAdvice
public class PhraseServiceErrorHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorResponse> handleCommonException(CommonException ex) {
        log.error("common error: {}", ex.toString());
        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code(ex.getCode()).message(ex.getMessage()).build()).build(), ex.getHttpStatus());
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedErrorException(Exception ex) {
        log.error("internal server error: {}", ex.toString());
        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code(Code.INTERNAL_SERVER_ERROR).message("Внутренняя ошибка сервиса").build()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
