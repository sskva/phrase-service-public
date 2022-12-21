package ru.mycompany.phrase.dao.communication;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domain.api.communication.reaction.commentPhrase.CommentPhraseReq;
import ru.mycompany.phrase.domain.dto.WhoseComment;

@Service
public interface ReactionDao {

    void deleteComment(long commentId);

    WhoseComment whoseComment(long commentId);

    void commentPhrase(long userId, CommentPhraseReq req);

    void deleteLikePhrase(long userId, long phraseId);

    void likePhrase(long userId, long phraseId);
}
