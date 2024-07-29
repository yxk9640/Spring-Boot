package com.Application.NewsProducerApplication.Service.impl;

import com.Application.NewsProducerApplication.Repository.NewsRepository;
import com.Application.NewsProducerApplication.Service.MessageService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author - yogesh
 */

@Service
public class MessageServiceImpl implements MessageService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewsRepository newsRepository;

    public MessageServiceImpl(KafkaTemplate<String, String> kafkaTemplate, NewsRepository newsRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.newsRepository = newsRepository;
    }

    @Override
    public Mono<Void> publisToMessageBroker(String date) {
        ProducerRecord<String, String> record = new ProducerRecord<>("news", null, date);
        return Mono.fromFuture(kafkaTemplate.send(record)).then();
    }

    @Override
    public Mono<Object> getNews(String date) {
        return newsRepository.getNews(date)
                .flatMap(Mono::just)
                .switchIfEmpty(Mono.defer(()->publisToMessageBroker(date)));
    }
}
