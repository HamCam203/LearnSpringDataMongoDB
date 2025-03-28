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
    // Endpoint pour récupérer tous les FaceSnaps
    @GetMapping
    public List<Face> getAllFaceSnaps() {
        return faceSnapsRepository.findAll();
    }

    // Endpoint pour récupérer un FaceSnap par ID
    @GetMapping("/{id}")
    public Face getFaceSnapById(@PathVariable("id") String id) {
        Optional<Face> face = faceSnapsRepository.findById(id);
        if (face.isPresent()) {
            return face.get();  // Renvoie l'objet Face si trouvé
        } else {
            throw new RuntimeException("FaceSnap not found with id " + id);  // Gérer l'erreur si l'id est invalide
        }
    }

    @PutMapping("/{id}")
    public Face updateFaceSnap(@PathVariable("id") String id, @RequestBody Face updatedFace) {
        Optional<Face> existingFaceSnap = faceSnapsRepository.findById(id);
    
        if (existingFaceSnap.isPresent()) {
            Face face = existingFaceSnap.get();
    
            // Utiliser directement la valeur envoyée par Angular
            face.setSnaps(updatedFace.getSnaps());
    
            return faceSnapsRepository.save(face);
        } else {
            throw new RuntimeException("FaceSnap not found with id " + id);
        }
    }
    
    
}
