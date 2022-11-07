package ru.mycompany.phrase.domen.response.error;

import lombok.Builder;
import lombok.Data;
import ru.mycompany.phrase.domen.response.Response;


@Data
@Builder
public class ErrorResponse implements Response {

    private Error error;
}
