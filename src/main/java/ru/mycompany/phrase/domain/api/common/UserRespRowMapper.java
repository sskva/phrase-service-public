package ru.mycompany.phrase.domain.api.common;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRespRowMapper implements RowMapper<UserResp> {

    @Override
    public UserResp mapRow(ResultSet row, int rowNum) throws SQLException {

        return UserResp.builder()
                .userId(row.getLong("id"))
                .nickname(row.getString("nickname"))
                .build();
    }

}
