package ru.mycompany.phrase.domain.api.search.searchPhrasesByTag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchPhrasesByTagResp {

    private List<PhraseResp> phrases;
}
