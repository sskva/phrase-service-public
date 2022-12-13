package ru.mycompany.phrase.dao.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mycompany.phrase.domain.api.common.CommentResp;
import ru.mycompany.phrase.domain.api.common.CommentRespRowMapper;
import ru.mycompany.phrase.domain.api.common.TagResp;
import ru.mycompany.phrase.domain.api.common.TagRespRowMapper;
import ru.mycompany.phrase.domain.constant.Code;
import ru.mycompany.phrase.domain.response.exception.CommonException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class CommonDaoImpl extends JdbcDaoSupport implements CommonDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }



    @Override
    public List<CommentResp> getCommentsByPhraseId(long phraseId) {

        try {
            return jdbcTemplate.query("SELECT comment.id AS comment_id, user_id, nickname, text, comment.time_insert " +
                    "FROM comment " +
                    "         JOIN user u on u.id = comment.user_id " +
                    "WHERE phrase_id = ? " +
                    "ORDER BY comment.time_insert DESC;", new CommentRespRowMapper(), phraseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public long getCountLikesByPhraseId(long phraseId) {
        try {
            return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM like_phrase WHERE phrase_id = ?;", Long.class, phraseId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }



    @Override
    public List<TagResp> getTagsByPhraseId(long phraseId) {

        try {
            return jdbcTemplate.query("SELECT text, id FROM tag WHERE id IN (SELECT tag_id FROM phrase_tag WHERE phrase_id = ?);", new TagRespRowMapper(), phraseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public long getUserIdByToken(String accessToken) {

        try {
            return jdbcTemplate.queryForObject("SELECT id FROM user WHERE access_token = ?;", Long.class, accessToken);
        } catch (EmptyResultDataAccessException ex) {
            log.error(ex.toString());
            throw CommonException.builder().code(Code.AUTHORIZATION_ERROR).userMessage("Ошибка авторизации").httpStatus(HttpStatus.BAD_REQUEST).build();
        }
    }



    @Override
    public void testSchedulerLock(String instanceName) {

        jdbcTemplate.update("INSERT INTO test_scheduler_lock(instance_name) VALUES (?);", instanceName);
    }

}


