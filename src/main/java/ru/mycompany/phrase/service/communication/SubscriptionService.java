package ru.mycompany.phrase.service.communication;

import org.springframework.http.ResponseEntity;
import ru.mycompany.phrase.domain.api.communication.subscription.SubscriptionReq;
import ru.mycompany.phrase.domain.api.communication.unsubscription.UnsubscriptionReq;
import ru.mycompany.phrase.domain.response.Response;

public interface SubscriptionService {

    ResponseEntity<Response> getMyPublishersPhrases(String accessToken, int from, int limit);

    ResponseEntity<Response> getMySubscribers(String accessToken);

    ResponseEntity<Response> getMyPublishers(String accessToken);

    ResponseEntity<Response> unsubscription(UnsubscriptionReq req, String accessToken);

    ResponseEntity<Response> subscription(SubscriptionReq req, String accessToken);
}