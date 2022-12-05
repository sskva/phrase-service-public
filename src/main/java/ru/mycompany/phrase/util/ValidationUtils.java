package ru.mycompany.phrase.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.mycompany.phrase.domain.constant.Code;
import ru.mycompany.phrase.domain.response.exception.CommonException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class ValidationUtils {

    private final Validator validator;



    public <T> void validationRequest(T req) {

        if (req != null) {
            Set<ConstraintViolation<T>> result = validator.validate(req);
            if (!result.isEmpty()) {
                String resultValidations = result.stream()
                        .map(ConstraintViolation::getMessage)
                        .reduce((s1, s2) -> s1 + ". " + s2).orElse("");
                log.error("Переданный в запросе json не валиден, ошибки валидации: {}", resultValidations);
                throw CommonException.builder().code(Code.REQUEST_VALIDATION_ERROR).techMessage(resultValidations).httpStatus(HttpStatus.BAD_REQUEST).build();
            }
        }
    }



    public void validationDecimalMin(String fieldName, int fieldValue, int constraint) {

        if (fieldValue < constraint) {
            throw CommonException.builder().code(Code.REQUEST_VALIDATION_ERROR).techMessage(fieldName + " должно быть больше или равно " + constraint).httpStatus(HttpStatus.BAD_REQUEST).build();
        }
    }
}
