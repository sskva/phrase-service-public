package ru.mycompany.phrase.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mycompany.phrase.dao.Dao;
import ru.mycompany.phrase.domen.api.*;
import ru.mycompany.phrase.domen.constant.Code;
import ru.mycompany.phrase.domen.dto.User;
import ru.mycompany.phrase.domen.response.Response;
import ru.mycompany.phrase.domen.response.SuccessResponse;
import ru.mycompany.phrase.domen.response.exception.CommonException;
import ru.mycompany.phrase.service.PhraseService;
import ru.mycompany.phrase.util.EncryptUtils;
import ru.mycompany.phrase.util.ValidationUtils;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhraseServiceImpl implements PhraseService {

    private final ValidationUtils validationUtils;
    private final EncryptUtils encryptUtils;
    private final Dao dao;



    @Override
    public ResponseEntity<Response> publicPhrase(PublicPhraseReq req, String accessToken) {

        validationUtils.validationRequest(req);

        long userId = dao.getIdByToken(accessToken);
        long phraseId = dao.addPhrase(userId, req.getText());
        log.info("userId: {}, phraseId: {}", userId, phraseId);

        for (String tag : req.getTags()) {
            dao.addTag(tag);
            dao.addPhraseTag(phraseId, tag);
        }

        return new ResponseEntity<>(SuccessResponse.builder().build(), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Response> login(LoginReq req) {

        validationUtils.validationRequest(req);

        String encryptPassword = encryptUtils.encryptPassword(req.getAuthorization().getPassword());
        String accessToken = dao.getAccessToken(User.builder().nickname(req.getAuthorization().getNickname()).encryptPassword(encryptPassword).build());
        return new ResponseEntity<>(SuccessResponse.builder().data(LoginResp.builder().accessToken(accessToken).build()).build(), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Response> registration(RegistrationReq req) {

        validationUtils.validationRequest(req);

        if (dao.isExistsNickname(req.getAuthorization().getNickname()))
            throw CommonException.builder().code(Code.NICKNAME_BUSY).message("Этот ник уже занят, придумайте другой").httpStatus(HttpStatus.BAD_REQUEST).build();

        String accessToken = UUID.randomUUID().toString().replace("-", "") + System.currentTimeMillis();
        String encryptPassword = encryptUtils.encryptPassword(req.getAuthorization().getPassword());
        dao.insertNewUser(User.builder().nickname(req.getAuthorization().getNickname()).encryptPassword(encryptPassword).accessToken(accessToken).build());

        return new ResponseEntity<>(SuccessResponse.builder().data(RegistrationResp.builder().accessToken(accessToken).build()).build(), HttpStatus.OK);
    }
}
