package ru.mycompany.phrase.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class EncryptUtils {


    public String encryptPassword(String password) {

        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
