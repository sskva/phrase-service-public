package ru.mycompany.phrase.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByPartWord.SearchPhrasesByPartWordReq;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByTag.SearchPhrasesByTagReq;
import ru.mycompany.phrase.domain.api.search.searchTags.SearchTagsReq;
import ru.mycompany.phrase.domain.api.search.searchUsersByPartNickname.SearchUsersByPartNicknameReq;
import ru.mycompany.phrase.domain.response.Response;
import ru.mycompany.phrase.service.search.SearchService;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("phrase-service-public/search")
public class SearchController {

    private final SearchService searchService;



    @PostMapping("/searchUsersByPartNickname")
    public ResponseEntity<Response> searchUsersByPartNickname(@RequestHeader String accessToken, @RequestBody final SearchUsersByPartNicknameReq req) {

        log.info("START endpoint searchUsersByPartNickname  accessToken: {}, request: {}", accessToken, req);
        ResponseEntity<Response> resp = searchService.searchUsersByPartNickname(req, accessToken);
        log.info("END endpoint searchUsersByPartNickname, response: {}", resp);
        return resp;
    }



    @PostMapping("/searchPhrasesByPartWord")
    public ResponseEntity<Response> searchPhrasesByPartWord(@RequestHeader String accessToken, @RequestBody final SearchPhrasesByPartWordReq req) {

        log.info("START endpoint searchPhrasesByPartWord, accessToken: {}, request: {}", accessToken, req);
        ResponseEntity<Response> resp = searchService.searchPhrasesByPartWord(req, accessToken);
        log.info("END endpoint searchPhrasesByTag , response: {}", resp);
        return resp;
    }



    @PostMapping("/searchPhrasesByTag")
    public ResponseEntity<Response> searchPhrasesByTag(@RequestHeader String accessToken, @RequestBody final SearchPhrasesByTagReq req) {

        log.info("START endpoint searchPhrasesByTag, accessToken: {}, request: {}", accessToken, req);
        ResponseEntity<Response> resp = searchService.searchPhrasesByTag(req, accessToken);
        log.info("END endpoint searchPhrasesByTag , response: {}", resp);
        return resp;
    }



    @PostMapping("/searchTags")
    public ResponseEntity<Response> searchTags(@RequestHeader String accessToken, @RequestBody final SearchTagsReq req) {

        log.info("START endpoint searchTags, accessToken: {}, request: {}", accessToken, req);
        ResponseEntity<Response> resp = searchService.searchTags(req, accessToken);
        log.info("END endpoint searchTags , response: {}", resp);
        return resp;
    }
}
