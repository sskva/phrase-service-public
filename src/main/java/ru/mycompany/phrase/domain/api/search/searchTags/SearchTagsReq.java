package ru.mycompany.phrase.domain.api.search.searchTags;

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
public class SearchTagsReq {

    @NotBlank(message = "partTag должен быть заполнен")
    @Pattern(regexp = RegExp.tag, message = "Некорректный partTag")
    private String partTag;
}
