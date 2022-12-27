package ru.mycompany.phrase.service.common;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mycompany.phrase.dao.common.CommonDao;
import ru.mycompany.phrase.domain.api.common.PhraseResp;
import ru.mycompany.phrase.domain.response.exception.CommonException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static ru.mycompany.phrase.domain.constant.Code.BLOCKED;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final CommonDao commonDao;



    @Override
    public void checkBlockByPhraseId(long userId, long phraseId) {

        long checkBlockUserId = commonDao.getUserIdByPhraseId(phraseId);
        checkBlock(userId, checkBlockUserId);
    }



    @Override
    public void checkBlockByUserId(long userId, long checkBlockUserId) {

        checkBlock(userId, checkBlockUserId);
    }



    private void checkBlock(long userId, long checkBlockUserId) {

        if (commonDao.isBlocked(userId, checkBlockUserId))
            throw CommonException.builder().code(BLOCKED).userMessage("Вы заблокированы этим юзером").httpStatus(BAD_REQUEST).build();
    }



    @Override
    public void phraseEnrichment(List<PhraseResp> phrases) {

        for (PhraseResp phraseResp : phrases) {
            phraseResp.setTags(commonDao.getTagsByPhraseId(phraseResp.getPhraseId()));
            phraseResp.setCountLikes(commonDao.getCountLikesByPhraseId(phraseResp.getPhraseId()));
            phraseResp.setComments(commonDao.getCommentsByPhraseId(phraseResp.getPhraseId()));
        }
    }
}
