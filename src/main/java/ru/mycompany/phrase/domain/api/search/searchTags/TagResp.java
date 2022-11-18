package ru.mycompany.phrase.domain.api.search.searchTags;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagResp {

    private long id;
    private String text;
}
