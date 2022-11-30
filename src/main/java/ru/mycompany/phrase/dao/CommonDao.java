package ru.mycompany.phrase.dao;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domain.api.common.TagResp;

import java.util.List;

@Service
public interface CommonDao {

    List<TagResp> getTagsByPhraseId(long phraseId);

    long getUserIdByToken(String accessToken);

    void testSchedulerLock(String instanceName);
}
