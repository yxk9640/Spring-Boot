package com.Application.NewsProducerApplication.Service;

import reactor.core.publisher.Mono;

/**
 * @author - yogesh
 */
public interface MessageService {
    Mono<Void> publisToMessageBroker(String data);
    Mono<Object> getNews(String date);
}
