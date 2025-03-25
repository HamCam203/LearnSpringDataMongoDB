package com.backend.faceSnaps.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.backend.faceSnaps.model.Face;

@Repository
public interface FaceSnapsRepository extends MongoRepository<Face, String> {
    Optional<Face> findByTitle(String title);
}
