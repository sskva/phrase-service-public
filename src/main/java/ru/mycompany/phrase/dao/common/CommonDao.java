package ru.mycompany.phrase.dao.common;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domain.api.common.CommentResp;
import ru.mycompany.phrase.domain.api.common.TagResp;

import java.util.List;

@Service
public interface CommonDao {

    List<CommentResp> getCommentsByPhraseId(long phraseId);

    long getCountLikesByPhraseId(long phraseId);

    List<TagResp> getTagsByPhraseId(long phraseId);

    long getUserIdByToken(String accessToken);

    void testSchedulerLock(String instanceName);
}
