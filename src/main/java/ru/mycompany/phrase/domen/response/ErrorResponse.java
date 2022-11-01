package ru.mycompany.phrase.domen.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ErrorResponse implements Response {

    private Error error;
}
