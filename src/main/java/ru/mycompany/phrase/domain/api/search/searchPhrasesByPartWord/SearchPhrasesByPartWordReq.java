package ru.mycompany.phrase.domain.api.search.searchPhrasesByPartWord;

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
public class SearchPhrasesByPartWordReq {

    @NotBlank(message = "partWord должен быть заполнен")
    @Pattern(regexp = RegExp.partWord, message = "Некорректный partWord")
    private String partWord;

    @NotNull(message = "sort должен быть заполнен")
    private Sort sort;
}
