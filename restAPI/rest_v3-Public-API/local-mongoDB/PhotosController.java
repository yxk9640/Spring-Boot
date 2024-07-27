package com.Application.KafkaMicroServices.Photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<PhotoEntity> getAllPhotos(){
        return photosService.getAllPhotos();
    }

    @PostMapping("/photo")
    public PhotoEntity savePhoto(@RequestBody PhotoEntity photo) {
        return photosService.savePhoto(photo);
    }
}
