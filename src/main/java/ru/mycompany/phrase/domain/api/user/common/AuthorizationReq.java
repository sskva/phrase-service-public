package ru.mycompany.phrase.domain.api.user.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mycompany.phrase.domain.constant.RegExp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationReq {

    @NotBlank(message = "nickname должен быть заполнен")
    @Pattern(regexp = RegExp.nickname, message = "Некорректный nickname")
    private String nickname;

    @NotBlank(message = "password должен быть заполнен")
    @Pattern(regexp = RegExp.password, message = "Некорректный password")
    private String password;
}
