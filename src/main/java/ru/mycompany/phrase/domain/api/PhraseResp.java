package ru.mycompany.phrase.domain.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhraseResp {

    private long id;
    private String text;
    private String timeInsert;
    private List<String> tags;
}
