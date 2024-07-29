package com.Application.NewsProducerApplication.Repository.Impl;

import com.Application.NewsProducerApplication.Repository.NewsRepository;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author - yogesh
 */

@Repository
public class NewsRepositoryImpl implements NewsRepository {
    private final ReactiveRedisOperations<String, Object> redisOperations;

    public NewsRepositoryImpl(ReactiveRedisOperations<String, Object> redisOperations){
        this.redisOperations = redisOperations;
    }

    @Override
    public Mono<Object> getNews(String date) {
        return redisOperations.opsForValue().get(date);
    }
}
