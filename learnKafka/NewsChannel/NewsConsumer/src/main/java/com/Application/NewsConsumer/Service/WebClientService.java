package com.Application.NewsConsumer.Service;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

/**
 * @author - yogesh
 */


public interface WebClientService {
    Mono<ResponseEntity<String>> sendRequest(String date);
}
