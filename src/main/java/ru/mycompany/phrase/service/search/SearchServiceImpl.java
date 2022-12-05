package ru.mycompany.phrase.service.search;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mycompany.phrase.dao.common.CommonDao;
import ru.mycompany.phrase.dao.search.SearchDao;
import ru.mycompany.phrase.domain.api.common.TagResp;
import ru.mycompany.phrase.domain.api.common.PhraseResp;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByPartWord.SearchPhrasesByPartWordReq;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByTag.SearchPhrasesByTagReq;
import ru.mycompany.phrase.domain.api.search.searchPhrasesByTag.SearchPhrasesByTagResp;
import ru.mycompany.phrase.domain.api.search.searchTags.SearchTagsReq;
import ru.mycompany.phrase.domain.api.search.searchTags.SearchTagsResp;
import ru.mycompany.phrase.domain.api.search.searchUsersByPartNickname.SearchUsersByPartNicknameReq;
import ru.mycompany.phrase.domain.response.Response;
import ru.mycompany.phrase.domain.response.SuccessResponse;
import ru.mycompany.phrase.util.ValidationUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchDao searchDao;
    private final ValidationUtils validationUtils;
    private final CommonDao commonDao;



    @Override
    public ResponseEntity<Response> searchUsersByPartNickname(SearchUsersByPartNicknameReq req, String accessToken) {

        validationUtils.validationRequest(req);
        commonDao.getUserIdByToken(accessToken);

        return new ResponseEntity<>(SuccessResponse.builder().data(searchDao.searchUsersByPartNickname(req.getPartNickname())).build(), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Response> searchPhrasesByPartWord(SearchPhrasesByPartWordReq req, String accessToken) {

        validationUtils.validationRequest(req);
        commonDao.getUserIdByToken(accessToken);

        List<PhraseResp> phrases = searchDao.searchPhrasesByPartWord(req);
        for (PhraseResp phraseResp : phrases) {
            List<TagResp> tags = commonDao.getTagsByPhraseId(phraseResp.getPhraseId());
            phraseResp.setTags(tags);
        }
        return new ResponseEntity<>(SuccessResponse.builder().data(SearchPhrasesByTagResp.builder().phrases(phrases).build()).build(), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Response> searchPhrasesByTag(SearchPhrasesByTagReq req, String accessToken) {

        validationUtils.validationRequest(req);
        commonDao.getUserIdByToken(accessToken);

        List<PhraseResp> phrases = searchDao.searchPhrasesByTag(req);
        for (PhraseResp phraseResp : phrases) {
            List<TagResp> tags = commonDao.getTagsByPhraseId(phraseResp.getPhraseId());
            phraseResp.setTags(tags);
        }
        return new ResponseEntity<>(SuccessResponse.builder().data(SearchPhrasesByTagResp.builder().phrases(phrases).build()).build(), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Response> searchTags(SearchTagsReq req, String accessToken) {

        validationUtils.validationRequest(req);
        commonDao.getUserIdByToken(accessToken);

        List<TagResp> tagRespList = searchDao.searchTags(req.getPartTag());
        return new ResponseEntity<>(SuccessResponse.builder().data(SearchTagsResp.builder().tags(tagRespList).build()).build(), HttpStatus.OK);
    }
}