package ru.mycompany.phrase.domain.api.communication.reaction.commentPhrase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mycompany.phrase.domain.constant.RegExp;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentPhraseReq {

    @DecimalMin(value = "1", message = "Значение phraseId должно быть больше 0")
    private long phraseId;

    @NotBlank(message = "text должен быть заполнен")
    @Pattern(regexp = RegExp.phrase, message = "Некорректный text")
    private String text;
}
