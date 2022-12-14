package ru.mycompany.phrase.dao.communication;

import org.springframework.stereotype.Service;
import ru.mycompany.phrase.domain.api.common.PhraseResp;
import ru.mycompany.phrase.domain.api.common.UserResp;

import java.util.List;

@Service
public interface SubscriptionDao {

    List<PhraseResp> getMyPublishersPhrases(long userId, int from, int limit);

    List<UserResp> getMySubscribers(long userId);

    List<UserResp> getMyPublishers(long userId);

    void unsubscription(long subUserId, long pubUserId);

    void subscription(long subUserId, long pubUserId);
}
