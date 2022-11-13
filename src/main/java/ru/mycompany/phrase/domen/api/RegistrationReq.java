package ru.mycompany.phrase.domen.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationReq {

    @NotNull(message = "authorization должен быть заполнен")
    private Authorization authorization;
}
