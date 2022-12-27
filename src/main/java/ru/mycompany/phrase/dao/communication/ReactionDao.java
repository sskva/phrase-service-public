package ru.mycompany.phrase.dao.communication;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domain.api.common.UserResp;
import ru.mycompany.phrase.domain.api.communication.reaction.commentPhrase.CommentPhraseReq;
import ru.mycompany.phrase.domain.dto.WhoseComment;

import java.util.List;

@Service
public interface ReactionDao {

    void unblockUser(long userId, long blockUserId);

    List<UserResp> getBlockUsers(long userId);

    void blockUser(long userId, long blockUserId);

    void deleteComment(long commentId);

    WhoseComment whoseComment(long commentId);

    void commentPhrase(long userId, CommentPhraseReq req);

    void deleteLikePhrase(long userId, long phraseId);

    void likePhrase(long userId, long phraseId);
}
