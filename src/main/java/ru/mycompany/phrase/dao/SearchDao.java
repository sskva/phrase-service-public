package ru.mycompany.phrase.dao;

import ru.mycompany.phrase.domain.api.search.searchTags.TagResp;

import java.util.List;

public interface SearchDao {

    List<TagResp> searchTags(String partTag);
}
