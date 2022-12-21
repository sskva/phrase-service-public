package ru.mycompany.phrase.domain.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WhoseCommentRowMapper implements RowMapper<WhoseComment> {

    @Override
    public WhoseComment mapRow(ResultSet row, int rowNum) throws SQLException {

        return WhoseComment.builder()
                .commentUserId(row.getLong("comment_user_id"))
                .phraseUserId(row.getLong("phrase_user_id"))
                .build();
    }
}
