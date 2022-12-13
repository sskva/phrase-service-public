package ru.mycompany.phrase.service.communication;

import org.springframework.http.ResponseEntity;
import ru.mycompany.phrase.domain.api.communication.comment.CommentPhraseReq;
import ru.mycompany.phrase.domain.response.Response;

public interface ReactionService {

    ResponseEntity<Response> commentPhrase(String accessToken, CommentPhraseReq req);

    ResponseEntity<Response> deleteLikePhrase(String accessToken, long phraseId);

    ResponseEntity<Response> likePhrase(String accessToken, long phraseId);
}