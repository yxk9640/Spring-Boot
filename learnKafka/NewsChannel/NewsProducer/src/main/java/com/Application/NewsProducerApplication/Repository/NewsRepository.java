package com.Application.NewsProducerApplication.Repository;

import reactor.core.publisher.Mono;

/**
 * @author - yogesh
 */
public interface NewsRepository {
    Mono<Object> getNews(String date);
}
