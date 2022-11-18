package ru.mycompany.phrase.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mycompany.phrase.dao.SearchDao;
import ru.mycompany.phrase.dao.UserDao;
import ru.mycompany.phrase.domain.api.search.searchTags.SearchTagsReq;
import ru.mycompany.phrase.domain.api.search.searchTags.SearchTagsResp;
import ru.mycompany.phrase.domain.api.search.searchTags.TagResp;
import ru.mycompany.phrase.domain.response.Response;
import ru.mycompany.phrase.domain.response.SuccessResponse;
import ru.mycompany.phrase.service.SearchService;
import ru.mycompany.phrase.util.ValidationUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchDao searchDao;
    private final ValidationUtils validationUtils;
    private final UserDao userDao;



    @Override
    public ResponseEntity<Response> searchTags(SearchTagsReq req, String accessToken) {

        validationUtils.validationRequest(req);
        userDao.getUserIdByToken(accessToken);

        List<TagResp> tagRespList = searchDao.searchTags(req.getPartTag());
        return new ResponseEntity<>(SuccessResponse.builder().data(SearchTagsResp.builder().tags(tagRespList).build()).build(), HttpStatus.OK);
    }
}