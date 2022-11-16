package ru.mycompany.phrase.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mycompany.phrase.filter.AuthorizationFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AuthorizationFilter> authorizationFilter() {
        final var filterBean = new FilterRegistrationBean<>(new AuthorizationFilter());
        filterBean.addUrlPatterns(
                "/phrase-service-public/search/*",
                "/phrase-service-public/communication/*",
                "/phrase-service-public/user/getMyPhrases",
                "/phrase-service-public/user/publicPhrase"
        );
        return filterBean;
    }
}
