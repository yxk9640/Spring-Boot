package com.Application.NewsConsumer.Repository.Impl;

import com.Application.NewsConsumer.Repository.NewsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.Duration;

/**
 * @author - yogesh
 */

@Repository
public class NewsRepositoryImpl implements NewsRepository {
    private final ReactiveRedisOperations<String, Object> redisOperations;

    public NewsRepositoryImpl(ReactiveRedisOperations<String, Object> redisOperations) {
        this.redisOperations = redisOperations;
    }

    @Override
    public Mono<Boolean> saveNews(String date, Object newsObject) throws JsonProcessingException{
        Duration ttl = Duration.ofHours(1);
        ObjectMapper objectMapper = new ObjectMapper();
        return redisOperations.opsForValue().set(date, objectMapper.readTree(newsObject.toString()), ttl);
    }
}
