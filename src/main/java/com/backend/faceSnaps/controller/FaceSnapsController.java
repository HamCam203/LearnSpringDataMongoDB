package com.backend.faceSnaps.controller;

import com.backend.faceSnaps.model.Face;
import com.backend.faceSnaps.repository.FaceSnapsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    // Endpoint pour récupérer un FaceSnap par ID
    @GetMapping("/{id}")
    public ResponseEntity<Face> getFaceSnapById(@PathVariable("id") String id) {
        Optional<Face> face = faceSnapsRepository.findById(id);
        if (face.isPresent()) {
            return ResponseEntity.ok(face.get());  // Retourne une réponse 200 avec l'objet Face
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);  // Retourne une erreur 404 si le FaceSnap n'est pas trouvé
        }
    }

    // Endpoint pour mettre à jour un FaceSnap par ID
    @PutMapping("/{id}")
    public ResponseEntity<Face> updateFaceSnap(@PathVariable("id") String id, @RequestBody Face updatedFace) {
        Optional<Face> existingFaceSnap = faceSnapsRepository.findById(id);
        
        if (existingFaceSnap.isPresent()) {
            Face face = existingFaceSnap.get();
            
            // Mettre à jour uniquement le nombre de snaps
            face.setSnaps(updatedFace.getSnaps());
            faceSnapsRepository.save(face);  // Sauvegarde de la photo mise à jour
            
            return ResponseEntity.ok(face);  // Retourne l'objet Face mis à jour avec une réponse 200
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);  // Retourne une erreur 404 si le FaceSnap n'est pas trouvé
        }
    }

    // Endpoint pour créer un nouveau FaceSnap
    @PostMapping
    public ResponseEntity<Face> createFaceSnap(@RequestBody Face newFace) {
        // Assurez-vous que MongoDB gère l'ID automatiquement
        newFace.setId(null); // L'ID doit être null lors de la création du document
        newFace.setCreatedAt(new Date());  // Définir la date de création
        
        Face savedFace = faceSnapsRepository.save(newFace);  // Sauvegarde le nouveau FaceSnap
        return ResponseEntity.status(HttpStatus.CREATED)  // Retourne un code 201 pour la création
                .body(savedFace);  // Retourne le FaceSnap créé
    }

    // Endpoint pour supprimer un FaceSnap par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaceSnap(@PathVariable("id") String id) {
        Optional<Face> face = faceSnapsRepository.findById(id);
        
        if (face.isPresent()) {
            faceSnapsRepository.delete(face.get());  // Supprimer le FaceSnap trouvé
            return ResponseEntity.status(HttpStatus.NO_CONTENT)  // Code 204 pour suppression réussie sans contenu
                    .body("FaceSnap supprimé avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)  // Retourne une erreur 404 si le FaceSnap n'est pas trouvé
                    .body("FaceSnap non trouvé avec l'id " + id);
        }
    }
}
