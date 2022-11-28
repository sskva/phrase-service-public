package ru.mycompany.phrase.domain.api.communication.getMySubscribers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mycompany.phrase.domain.api.common.UserResp;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetMySubscribersResp {

    private List<UserResp> subscribers;
}
