package com.Application.NewsConsumer.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author - yogesh
 */

@Repository
public interface NewsRepository {
    Mono<Boolean> saveNews(String date, Object newsObject) throws JsonProcessingException;
}
