package ru.mycompany.phrase.dao;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domen.dto.User;

@Service
public interface Dao {

    String getAccessToken(User user);

    boolean isExistsNickname(String nickname);

    void insertNewUser(User user);
}
