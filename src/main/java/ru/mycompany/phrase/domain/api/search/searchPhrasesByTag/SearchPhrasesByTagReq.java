package ru.mycompany.phrase.domain.api.search.searchPhrasesByTag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mycompany.phrase.domain.constant.Sort;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchPhrasesByTagReq {

    @DecimalMin(value = "1", message = "Значение tagId должно быть больше 0")
    private long tagId;

    @NotNull(message = "sort должен быть заполнен")
    private Sort sort;
}
