package ru.mycompany.phrase.dao.communication;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domain.api.common.PhraseResp;
import ru.mycompany.phrase.domain.api.common.UserResp;

import java.util.List;

@Service
public interface ReactionDao {

    void deleteLikePhrase(long userId, long phraseId);

    void likePhrase(long userId, long phraseId);
}
