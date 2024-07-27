package com.Application.KafkaMicroServices.Sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author - yogesh
 */
@RestController
public class PhotosController {

    @Autowired
    private PhotosService photosService;

    @GetMapping("/photos")
    public List<Object> getInfo(){
        return photosService.getPhotos();

    }
}
