package ru.mycompany.phrase.service.communication;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mycompany.phrase.dao.common.CommonDao;
import ru.mycompany.phrase.dao.communication.ReactionDao;
import ru.mycompany.phrase.dao.communication.SubscriptionDao;
import ru.mycompany.phrase.domain.api.communication.reaction.commentPhrase.CommentPhraseReq;
import ru.mycompany.phrase.domain.api.communication.reaction.getBlockUsers.GetBlockUsersResp;
import ru.mycompany.phrase.domain.dto.WhoseComment;
import ru.mycompany.phrase.domain.response.Response;
import ru.mycompany.phrase.domain.response.SuccessResponse;
import ru.mycompany.phrase.domain.response.error.Error;
import ru.mycompany.phrase.domain.response.error.ErrorResponse;
import ru.mycompany.phrase.service.common.CommonService;
import ru.mycompany.phrase.util.ValidationUtils;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;
import static ru.mycompany.phrase.domain.constant.Code.NOT_BLOCK_YOURSELF;
import static ru.mycompany.phrase.domain.constant.Code.NOT_YOUR_COMMENT;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {

    private final ValidationUtils validationUtils;
    private final CommonDao commonDao;
    private final ReactionDao reactionDao;
    private final SubscriptionDao subscriptionDao;
    private final CommonService commonService;



    @Override
    public ResponseEntity<Response> unblockUser(String accessToken, long blockUserId) {

        validationUtils.validationDecimalMin("blockUserId", blockUserId, 1);
        long userId = commonDao.getUserIdByToken(accessToken);
        reactionDao.unblockUser(userId, blockUserId);
        return new ResponseEntity<>(SuccessResponse.builder().build(), OK);
    }



    @Override
    public ResponseEntity<Response> getBlockUsers(String accessToken) {

        long userId = commonDao.getUserIdByToken(accessToken);
        return new ResponseEntity<>(SuccessResponse.builder()
                .data(GetBlockUsersResp.builder().blockUsers(reactionDao.getBlockUsers(userId)).build()).build(), OK);
    }



    @Override
    public ResponseEntity<Response> blockUser(String accessToken, long blockUserId) {

        validationUtils.validationDecimalMin("blockUserId", blockUserId, 1);
        long userId = commonDao.getUserIdByToken(accessToken);

        if (userId == blockUserId)
            return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code(NOT_BLOCK_YOURSELF).userMessage("Вы не можете заблокировать себя").build()).build(), BAD_REQUEST);

        reactionDao.blockUser(userId, blockUserId);
        subscriptionDao.unsubscription(blockUserId, userId);
        return new ResponseEntity<>(SuccessResponse.builder().build(), OK);
    }



    @Override
    public ResponseEntity<Response> deleteCommentPhrase(String accessToken, long commentId) {

        validationUtils.validationDecimalMin("commentId", commentId, 1);
        long userId = commonDao.getUserIdByToken(accessToken);

        WhoseComment whoseComment = reactionDao.whoseComment(commentId);
        log.info("userId: {}, whoseComment: {}", userId, whoseComment);

        if (whoseComment.getCommentUserId() == userId || whoseComment.getPhraseUserId() == userId) {
            reactionDao.deleteComment(commentId);
            return new ResponseEntity<>(SuccessResponse.builder().build(), OK);
        }

        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code(NOT_YOUR_COMMENT)
                .userMessage("Это не ваш комментарий и не комментарий у вашей фразы")
                .build()).build(), BAD_REQUEST);
    }



    @Override
    public ResponseEntity<Response> commentPhrase(String accessToken, CommentPhraseReq req) {

        validationUtils.validationRequest(req);
        long userId = commonDao.getUserIdByToken(accessToken);

        commonService.checkBlockByPhraseId(userId, req.getPhraseId());

        reactionDao.commentPhrase(userId, req);
        return new ResponseEntity<>(SuccessResponse.builder().build(), OK);
    }



    @Override
    public ResponseEntity<Response> deleteLikePhrase(String accessToken, long phraseId) {

        validationUtils.validationDecimalMin("phraseId", phraseId, 1);
        long userId = commonDao.getUserIdByToken(accessToken);
        reactionDao.deleteLikePhrase(userId, phraseId);
        return new ResponseEntity<>(SuccessResponse.builder().build(), OK);
    }



    @Override
    public ResponseEntity<Response> likePhrase(String accessToken, long phraseId) {

        validationUtils.validationDecimalMin("phraseId", phraseId, 1);
        long userId = commonDao.getUserIdByToken(accessToken);

        commonService.checkBlockByPhraseId(userId, phraseId);

        reactionDao.likePhrase(userId, phraseId);
        return new ResponseEntity<>(SuccessResponse.builder().build(), OK);
    }
}