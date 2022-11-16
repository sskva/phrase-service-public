package ru.mycompany.phrase.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.mycompany.phrase.domain.constant.Code;
import ru.mycompany.phrase.domain.response.error.Error;
import ru.mycompany.phrase.domain.response.error.ErrorResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        String accessToken = request.getHeader("AccessToken");
        if (Strings.isEmpty(accessToken)) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .error(Error.builder()
                            .code(Code.AUTHORIZATION_ERROR)
                            .userMessage("Ошибка авторизации, выброшенная из фильтра")
                            .build())
                    .build();
            log.info("Отсутствует header AccessToken. ErrorResponse: {}", errorResponse);
            response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
            response.setStatus(BAD_REQUEST.value());
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
