package ru.mycompany.phrase.service;

import org.springframework.http.ResponseEntity;
import ru.mycompany.phrase.domain.api.search.searchTags.SearchTagsReq;
import ru.mycompany.phrase.domain.response.Response;

public interface SearchService {

    ResponseEntity<Response> searchTags(SearchTagsReq req, String accessToken);
}
