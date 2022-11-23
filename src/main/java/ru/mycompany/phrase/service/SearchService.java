package ru.mycompany.phrase.service;

import org.springframework.http.ResponseEntity;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByPartWord.SearchPhrasesByPartWordReq;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByTag.SearchPhrasesByTagReq;
import ru.mycompany.phrase.domain.api.search.searchTags.SearchTagsReq;
import ru.mycompany.phrase.domain.response.Response;

public interface SearchService {

    ResponseEntity<Response> searchPhrasesByPartWord(SearchPhrasesByPartWordReq req, String accessToken);
    ResponseEntity<Response> searchPhrasesByTag(SearchPhrasesByTagReq req, String accessToken);

    ResponseEntity<Response> searchTags(SearchTagsReq req, String accessToken);
}
