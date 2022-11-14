package ru.mycompany.phrase.dao;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domen.dto.User;

@Service
public interface Dao {

    void addPhraseTag(long phraseId, String tag);

    void addTag(String tag);

    long addPhrase(long userId, String text);

    long getIdByToken(String accessToken);

    String getAccessToken(User user);

    boolean isExistsNickname(String nickname);

    void insertNewUser(User user);
}
