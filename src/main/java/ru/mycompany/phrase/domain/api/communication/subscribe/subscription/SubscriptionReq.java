package ru.mycompany.phrase.domain.api.communication.subscribe.subscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionReq {

    @DecimalMin(value = "1", message = "Значение pubUserId должно быть больше 0")
    private long pubUserId;
}
