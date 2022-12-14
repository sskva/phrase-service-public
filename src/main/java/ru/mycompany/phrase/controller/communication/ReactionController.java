package ru.mycompany.phrase.controller.communication;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mycompany.phrase.domain.api.communication.comment.CommentPhraseReq;
import ru.mycompany.phrase.domain.response.Response;
import ru.mycompany.phrase.service.communication.ReactionService;


@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("phrase-service-public/communication/reaction")
public class ReactionController {

    private final ReactionService reactionService;



    @PostMapping("/commentPhrase")
    public ResponseEntity<Response> commentPhrase(@RequestHeader String accessToken, @RequestBody final CommentPhraseReq req) {

        log.info("START endpoint commentPhrase  accessToken: {}, req: {}", accessToken, req);
        ResponseEntity<Response> resp = reactionService.commentPhrase(accessToken, req);
        log.info("END endpoint commentPhrase, response: {}", resp);
        return resp;
    }



    @GetMapping("/deleteLikePhrase/{phraseId}")
    public ResponseEntity<Response> deleteLikePhrase(@RequestHeader String accessToken, @PathVariable long phraseId) {

        log.info("START endpoint deleteLikePhrase  accessToken: {}, phraseId: {}", accessToken, phraseId);
        ResponseEntity<Response> resp = reactionService.deleteLikePhrase(accessToken, phraseId);
        log.info("END endpoint deleteLikePhrase, response: {}", resp);
        return resp;
    }



    @GetMapping("/likePhrase/{phraseId}")
    public ResponseEntity<Response> likePhrase(@RequestHeader String accessToken, @PathVariable long phraseId) {

        log.info("START endpoint likePhrase  accessToken: {}, phraseId: {}", accessToken, phraseId);
        ResponseEntity<Response> resp = reactionService.likePhrase(accessToken, phraseId);
        log.info("END endpoint likePhrase, response: {}", resp);
        return resp;
    }
}
