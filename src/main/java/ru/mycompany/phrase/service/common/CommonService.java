package ru.mycompany.phrase.service.common;

import ru.mycompany.phrase.domain.api.common.PhraseResp;

import java.util.List;

public interface CommonService {

    void phraseEnrichment(List<PhraseResp> phrases);
}
