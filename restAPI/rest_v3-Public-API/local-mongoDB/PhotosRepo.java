package com.Application.KafkaMicroServices.Photos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author - yogesh
 */

@Repository
public interface PhotosRepo extends MongoRepository<PhotoEntity, String> {
}
