package ru.mycompany.phrase.dao.search;

import ru.mycompany.phrase.domain.api.common.TagResp;
import ru.mycompany.phrase.domain.api.common.PhraseResp;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByPartWord.SearchPhrasesByPartWordReq;
import ru.mycompany.phrase.domain.api.common.UserResp;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByTag.SearchPhrasesByTagReq;

import java.util.List;

public interface SearchDao {

    List<UserResp> searchUsersByPartNickname(String partNickname);

    List<PhraseResp> searchPhrasesByPartWord(SearchPhrasesByPartWordReq req, long userId);

    List<PhraseResp> searchPhrasesByTag(SearchPhrasesByTagReq req, long userId);

    List<TagResp> searchTags(String partTag);
}
