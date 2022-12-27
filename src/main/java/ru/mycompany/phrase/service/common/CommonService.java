package ru.mycompany.phrase.service.common;

import ru.mycompany.phrase.domain.api.common.PhraseResp;

import java.util.List;

public interface CommonService {

    void checkBlockByPhraseId(long userId, long phraseId);

    void checkBlockByUserId(long userId, long checkBlockUserId);

    void phraseEnrichment(List<PhraseResp> phrases);
}
