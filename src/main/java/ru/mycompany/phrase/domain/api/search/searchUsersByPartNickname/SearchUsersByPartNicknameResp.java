package ru.mycompany.phrase.domain.api.search.searchUsersByPartNickname;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mycompany.phrase.domain.api.common.PhraseResp;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchUsersByPartNicknameResp {

    private List<PhraseResp> phrases;
}
