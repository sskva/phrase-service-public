package ru.mycompany.phrase.dao.user;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domain.dto.User;
import ru.mycompany.phrase.domain.entity.Phrase;

import java.util.List;

@Service
public interface UserDao {

    List<Phrase> getPhrasesByUserId(long userId);

    void addPhraseTag(long phraseId, String tag);

    void addTag(String tag);

    long addPhrase(long userId, String text);

    String getAccessToken(User user);

    boolean isExistsNickname(String nickname);

    void insertNewUser(User user);
}
