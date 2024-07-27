package com.Application.KafkaMicroServices.Sample;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author - yogesh
 */


@Service
public class PhotosService {
    private final RestTemplate restTemplate;
    public PhotosService(){
        this.restTemplate = new RestTemplate();
    }

    public List<Object> getPhotos(){
        String url = "https://jsonplaceholder.typicode.com/photos";
        Object[] photos = restTemplate.getForObject(url, Object[].class);
        if (photos == null)
            throw new NullPointerException("Photos not found");
        return List.of(photos);
    }
}
