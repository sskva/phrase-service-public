package ru.mycompany.phrase.domain.api.communication.unsubscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnsubscriptionReq {

    @DecimalMin(value = "1", message = "Значение pubUserId должно быть больше 0")
    private long pubUserId;
}
