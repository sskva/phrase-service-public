package ru.mycompany.phrase.domen.response.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import ru.mycompany.phrase.domen.constant.Code;

@Data
@Builder
public class CommonException extends RuntimeException {

    private final Code code;
    private final String message;
    private final HttpStatus httpStatus;
}
