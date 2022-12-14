package ru.mycompany.phrase.domain.api.common;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRespRowMapper implements RowMapper<CommentResp> {

    @Override
    public CommentResp mapRow(ResultSet row, int rowNum) throws SQLException {

        return CommentResp.builder()
                .commentId(row.getLong("comment_id"))
                .userId(row.getLong("user_id"))
                .nickname(row.getString("nickname"))
                .text(row.getString("text"))
                .timeInsert(row.getString("time_insert"))
                .build();
    }
}
