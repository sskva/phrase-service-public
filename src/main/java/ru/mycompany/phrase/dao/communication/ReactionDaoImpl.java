package ru.mycompany.phrase.dao.communication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mycompany.phrase.domain.api.common.PhraseRespRowMapper;
import ru.mycompany.phrase.domain.api.communication.reaction.commentPhrase.CommentPhraseReq;
import ru.mycompany.phrase.domain.dto.WhoseComment;
import ru.mycompany.phrase.domain.dto.WhoseCommentRowMapper;
import ru.mycompany.phrase.domain.response.exception.CommonException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static ru.mycompany.phrase.domain.constant.Code.COMMENT_NOT_FOUND;

@Slf4j
@Repository
@Transactional
public class ReactionDaoImpl extends JdbcDaoSupport implements ReactionDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }



    @Override
    public void deleteComment(long commentId) {

        jdbcTemplate.update("DELETE FROM comment WHERE id = ?;", commentId);
    }



    @Override
    public WhoseComment whoseComment(long commentId) {
        try {
            return jdbcTemplate.queryForObject("SELECT comment.user_id AS comment_user_id, p.user_id AS phrase_user_id " +
                    "FROM comment JOIN phrase p on p.id = comment.phrase_id " +
                    "WHERE comment.id = ?;", new WhoseCommentRowMapper(), commentId);
        } catch (EmptyResultDataAccessException e) {
            throw CommonException.builder().code(COMMENT_NOT_FOUND).userMessage("Комментарий не найден").httpStatus(BAD_REQUEST).build();
        }
    }



    @Override
    public void commentPhrase(long userId, CommentPhraseReq req) {
        jdbcTemplate.update("INSERT IGNORE INTO comment(user_id, phrase_id, text) VALUES (?,?,?);", userId, req.getPhraseId(), req.getText());
    }



    @Override
    public void deleteLikePhrase(long userId, long phraseId) {
        jdbcTemplate.update("DELETE FROM like_phrase WHERE phrase_id = ? AND user_id = ?;", phraseId, userId);
    }



    @Override
    public void likePhrase(long userId, long phraseId) {
        jdbcTemplate.update("INSERT IGNORE INTO like_phrase(phrase_id, user_id) VALUES (?,?);", phraseId, userId);
    }
}


