package ru.mycompany.phrase.domain.api.search.searchPhrasesByPartWord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mycompany.phrase.domain.api.search.common.PhraseResp;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchPhrasesByPartWordResp {

    private List<PhraseResp> phrases;
}
