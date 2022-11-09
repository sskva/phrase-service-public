package ru.mycompany.phrase.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import ru.mycompany.phrase.dao.Dao;
import ru.mycompany.phrase.domen.api.RegistrationReq;
import ru.mycompany.phrase.domen.api.RegistrationResp;
import ru.mycompany.phrase.domen.constant.Code;
import ru.mycompany.phrase.domen.dto.User;
import ru.mycompany.phrase.domen.response.Response;
import ru.mycompany.phrase.domen.response.SuccessResponse;
import ru.mycompany.phrase.domen.response.exception.CommonException;
import ru.mycompany.phrase.service.PhraseService;
import ru.mycompany.phrase.util.ValidationUtils;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhraseServiceImpl implements PhraseService {

    private final ValidationUtils validationUtils;
    private final Dao dao;


    @Override
    public ResponseEntity<Response> registration(RegistrationReq req) {

        validationUtils.validationRequest(req);

        if (dao.isExistsNickname(req.getNickname()))
            throw CommonException.builder().code(Code.NICKNAME_BUSY).message("Этот ник уже занят, придумайте другой").httpStatus(HttpStatus.BAD_REQUEST).build();

        String accessToken = UUID.randomUUID().toString().replace("-","") + System.currentTimeMillis();
        String encryptPassword = DigestUtils.md5DigestAsHex(req.getPassword().getBytes());
        dao.insertNewUser(User.builder().nickname(req.getNickname()).encryptPassword(encryptPassword).accessToken(accessToken).build());

        return new ResponseEntity<>(SuccessResponse.builder().data(RegistrationResp.builder().accessToken(accessToken).build()).build(), HttpStatus.OK);
    }
}
