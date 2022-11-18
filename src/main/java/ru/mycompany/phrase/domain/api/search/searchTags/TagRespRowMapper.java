package ru.mycompany.phrase.domain.api.search.searchTags;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagRespRowMapper implements RowMapper<TagResp> {

    @Override
    public TagResp mapRow(ResultSet row, int rowNum) throws SQLException {

        return TagResp.builder()
                .id(row.getLong("id"))
                .text(row.getString("text"))
                .build();
    }

}
