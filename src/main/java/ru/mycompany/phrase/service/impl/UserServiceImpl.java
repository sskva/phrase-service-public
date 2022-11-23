package ru.mycompany.phrase.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mycompany.phrase.config.MapperConfig;
import ru.mycompany.phrase.dao.CommonDao;
import ru.mycompany.phrase.dao.UserDao;
import ru.mycompany.phrase.domain.api.user.getMyPhrases.GetMyPhrasesResp;
import ru.mycompany.phrase.domain.api.user.getMyPhrases.PhraseResp;
import ru.mycompany.phrase.domain.api.common.TagResp;
import ru.mycompany.phrase.domain.api.user.login.LoginReq;
import ru.mycompany.phrase.domain.api.user.login.LoginResp;
import ru.mycompany.phrase.domain.api.user.publicPhrase.PublicPhraseReq;
import ru.mycompany.phrase.domain.api.user.registration.RegistrationReq;
import ru.mycompany.phrase.domain.api.user.registration.RegistrationResp;
import ru.mycompany.phrase.domain.constant.Code;
import ru.mycompany.phrase.domain.dto.User;
import ru.mycompany.phrase.domain.entity.Phrase;
import ru.mycompany.phrase.domain.response.Response;
import ru.mycompany.phrase.domain.response.SuccessResponse;
import ru.mycompany.phrase.domain.response.exception.CommonException;
import ru.mycompany.phrase.service.UserService;
import ru.mycompany.phrase.util.EncryptUtils;
import ru.mycompany.phrase.util.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ValidationUtils validationUtils;
    private final EncryptUtils encryptUtils;
    private final UserDao userDao;
    private final CommonDao commonDao;
//    private final MapperConfig mapper;



    @Override
    public ResponseEntity<Response> getMyPhrases(String accessToken) {



        long userId = commonDao.getUserIdByToken(accessToken);
        List<Phrase> phraseList = userDao.getPhrasesByUserId(userId);

        List<PhraseResp> phraseRespList = new ArrayList<>();
        for (Phrase phrase : phraseList) {
            List<TagResp> tags = commonDao.getTagsByPhraseId(phrase.getId());
            PhraseResp phraseResp = new ModelMapper().map(phrase, PhraseResp.class);
            phraseResp.setTags(tags);
            phraseRespList.add(phraseResp);
        }
        return new ResponseEntity<>(SuccessResponse.builder().data(GetMyPhrasesResp.builder().phrases(phraseRespList).build()).build(), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Response> publicPhrase(PublicPhraseReq req, String accessToken) {

        validationUtils.validationRequest(req);

        long userId = commonDao.getUserIdByToken(accessToken);
        long phraseId = userDao.addPhrase(userId, req.getText());
        log.info("userId: {}, phraseId: {}", userId, phraseId);

        for (String tag : req.getTags()) {
            userDao.addTag(tag);
            userDao.addPhraseTag(phraseId, tag);
        }

        return new ResponseEntity<>(SuccessResponse.builder().build(), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Response> login(LoginReq req) {

        validationUtils.validationRequest(req);

        String encryptPassword = encryptUtils.encryptPassword(req.getAuthorization().getPassword());
        String accessToken = userDao.getAccessToken(User.builder().nickname(req.getAuthorization().getNickname()).encryptPassword(encryptPassword).build());
        return new ResponseEntity<>(SuccessResponse.builder().data(LoginResp.builder().accessToken(accessToken).build()).build(), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Response> registration(RegistrationReq req) {

        validationUtils.validationRequest(req);

        if (userDao.isExistsNickname(req.getAuthorization().getNickname()))
            throw CommonException.builder().code(Code.NICKNAME_BUSY).userMessage("Этот ник уже занят, придумайте другой").httpStatus(HttpStatus.BAD_REQUEST).build();

        String accessToken = UUID.randomUUID().toString().replace("-", "") + System.currentTimeMillis();
        String encryptPassword = encryptUtils.encryptPassword(req.getAuthorization().getPassword());
        userDao.insertNewUser(User.builder().nickname(req.getAuthorization().getNickname()).encryptPassword(encryptPassword).accessToken(accessToken).build());

        return new ResponseEntity<>(SuccessResponse.builder().data(RegistrationResp.builder().accessToken(accessToken).build()).build(), HttpStatus.OK);
    }


}
