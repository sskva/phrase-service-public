package ru.mycompany.phrase.dao.communication;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domain.api.communication.comment.CommentPhraseReq;

import java.util.List;

@Service
public interface ReactionDao {

    void commentPhrase(long userId, CommentPhraseReq req);

    void deleteLikePhrase(long userId, long phraseId);

    void likePhrase(long userId, long phraseId);
}
