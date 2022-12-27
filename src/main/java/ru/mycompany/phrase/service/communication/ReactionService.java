package ru.mycompany.phrase.service.communication;

import org.springframework.http.ResponseEntity;
import ru.mycompany.phrase.domain.api.communication.reaction.commentPhrase.CommentPhraseReq;
import ru.mycompany.phrase.domain.response.Response;

public interface ReactionService {

    ResponseEntity<Response> unblockUser(String accessToken, long blockUserId);

    ResponseEntity<Response> getBlockUsers(String accessToken);

    ResponseEntity<Response> blockUser(String accessToken, long blockingUserId);

    ResponseEntity<Response> deleteCommentPhrase(String accessToken, long commentId);

    ResponseEntity<Response> commentPhrase(String accessToken, CommentPhraseReq req);

    ResponseEntity<Response> deleteLikePhrase(String accessToken, long phraseId);

    ResponseEntity<Response> likePhrase(String accessToken, long phraseId);
}