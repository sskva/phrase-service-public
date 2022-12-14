package ru.mycompany.phrase.dao.user;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domain.api.common.PhraseResp;
import ru.mycompany.phrase.domain.dto.User;

import java.util.List;

@Service
public interface UserDao {

    List<PhraseResp> getPhrasesByUserId(long userId);

    void addPhraseTag(long phraseId, String tag);

    void addTag(String tag);

    long addPhrase(long userId, String text);

    String getAccessToken(User user);

    boolean isExistsNickname(String nickname);

    void insertNewUser(User user);
}
