package com.Application.NewsConsumer.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


/**
 * @author - yogesh
 */
@Configuration
public class WebClientConfig {
    //@yog change public api
    @Value("${newsapi.uri}")
    private String apiUri;

    @Bean
    public WebClient webClient(){
        return WebClient.create(apiUri);
    }

}
