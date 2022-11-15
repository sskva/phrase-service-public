package ru.mycompany.phrase.domain.response.error;

import lombok.Builder;
import lombok.Data;
import ru.mycompany.phrase.domain.response.Response;


@Data
@Builder
public class ErrorResponse implements Response {

    private Error error;
}
