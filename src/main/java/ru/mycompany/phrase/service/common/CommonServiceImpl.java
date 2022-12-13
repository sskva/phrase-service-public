package ru.mycompany.phrase.service.common;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mycompany.phrase.dao.common.CommonDao;
import ru.mycompany.phrase.domain.api.common.PhraseResp;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final CommonDao commonDao;



    @Override
    public void phraseEnrichment(List<PhraseResp> phrases) {

        for (PhraseResp phraseResp : phrases) {
            phraseResp.setTags(commonDao.getTagsByPhraseId(phraseResp.getPhraseId()));
            phraseResp.setCountLikes(commonDao.getCountLikesByPhraseId(phraseResp.getPhraseId()));
            phraseResp.setComments(commonDao.getCommentsByPhraseId(phraseResp.getPhraseId()));
        }
    }
}
