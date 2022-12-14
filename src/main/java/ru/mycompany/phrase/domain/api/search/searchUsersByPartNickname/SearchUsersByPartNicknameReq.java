package ru.mycompany.phrase.domain.api.search.searchUsersByPartNickname;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mycompany.phrase.domain.constant.RegExp;
import ru.mycompany.phrase.domain.constant.Sort;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchUsersByPartNicknameReq {

    @NotBlank(message = "partNickname должен быть заполнен")
    @Pattern(regexp = RegExp.partNickname, message = "Некорректный partNickname")
    private String partNickname;
}
