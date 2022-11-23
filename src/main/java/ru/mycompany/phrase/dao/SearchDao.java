package ru.mycompany.phrase.dao;

import ru.mycompany.phrase.domain.api.common.TagResp;
import ru.mycompany.phrase.domain.api.search.common.PhraseResp;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByPartWord.SearchPhrasesByPartWordReq;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByTag.SearchPhrasesByTagReq;

import java.util.List;

public interface SearchDao {

    List<PhraseResp> searchPhrasesByPartWord(SearchPhrasesByPartWordReq req);

    List<PhraseResp> searchPhrasesByTag(SearchPhrasesByTagReq req);

    List<TagResp> searchTags(String partTag);
}
