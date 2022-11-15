package ru.mycompany.phrase.domain.api.user.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mycompany.phrase.domain.api.user.common.AuthorizationReq;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationReq {

    @NotNull(message = "authorization должен быть заполнен")
    private AuthorizationReq authorization;


}
