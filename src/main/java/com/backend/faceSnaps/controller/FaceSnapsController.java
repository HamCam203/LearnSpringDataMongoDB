package com.backend.faceSnaps.controller;

import com.backend.faceSnaps.model.Face;
import com.backend.faceSnaps.repository.FaceSnapsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facesnaps")
@CrossOrigin(origins = "http://localhost:4200") // Autoriser Angular à accéder au backend
public class FaceSnapsController {

    @Autowired
    private FaceSnapsRepository faceSnapsRepository;

    // Endpoint pour récupérer tous les FaceSnaps
    @GetMapping
    public List<Face> getAllFaceSnaps() {
        return faceSnapsRepository.findAll();
    }

    // Endpoint pour mettre à jour le nombre de snaps d'un FaceSnap
    @PutMapping("/{id}")
    public Face updateFaceSnap(@PathVariable("id") String id, @RequestBody Face updatedFace) {
        Optional<Face> existingFaceSnap = faceSnapsRepository.findById(id);
        
        if (existingFaceSnap.isPresent()) {
            Face face = existingFaceSnap.get();
            // Augmenter le nombre de snaps
            face.setSnaps(face.getSnaps() + 1);
            // Sauvegarder l'objet mis à jour dans la base de données
            return faceSnapsRepository.save(face);
        } else {
            throw new RuntimeException("FaceSnap not found with id " + id); // Gérer l'erreur si l'id est invalide
        }
    }
}
