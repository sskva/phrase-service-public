package ru.mycompany.phrase.domain.api.common;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhraseRespRowMapper implements RowMapper<PhraseResp> {

    @Override
    public PhraseResp mapRow(ResultSet row, int rowNum) throws SQLException {

        return PhraseResp.builder()
                .phraseId(row.getLong("phrase_id"))
                .userId(row.getLong("user_id"))
                .nickname(row.getString("nickname"))
                .text(row.getString("text"))
                .timeInsert(row.getString("time_insert"))
                .build();
    }

}
