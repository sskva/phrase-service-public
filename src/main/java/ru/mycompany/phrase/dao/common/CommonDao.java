package ru.mycompany.phrase.dao.common;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domain.api.common.TagResp;

import java.util.List;

@Service
public interface CommonDao {

    long getCountLikes(long phraseId);

    List<TagResp> getTagsByPhraseId(long phraseId);

    long getUserIdByToken(String accessToken);

    void testSchedulerLock(String instanceName);
}
