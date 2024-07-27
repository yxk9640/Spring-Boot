package com.Application.KafkaMicroServices.Photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author - yogesh
 */


@Service
public class PhotosService {
    @Autowired
    private PhotosRepo photosRepo;


    public List<PhotoEntity> getAllPhotos() {
        return photosRepo.findAll();
    }

    public PhotoEntity getPhotoById(String id) {
        return photosRepo.findById(id).orElse(null);
    }

    public PhotoEntity savePhoto(PhotoEntity photo) {
        return photosRepo.save(photo);
    }

    public void deletePhoto(String id) {
        photosRepo.deleteById(id);
    }
}


