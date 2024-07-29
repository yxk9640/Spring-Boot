package com.Application.NewsConsumer.Service.Impl;

import com.Application.NewsConsumer.Service.WebClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author - yogesh
 */
@Service
public class WebClientServiceImpl implements WebClientService {
    @Value("${newsapi.api-key}")
    private String apiKey;

    @Value("${newsapi.search}")
    private String search; //usd



    private final WebClient webClient;

    public WebClientServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<ResponseEntity<String>> sendRequest(String date) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("api_token", apiKey)
                        .queryParam("search", search)
                        .build())
                .retrieve()
                .toEntity(String.class);
    }
}
