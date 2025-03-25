package com.backend.faceSnaps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.faceSnaps.model.Face;
import com.backend.faceSnaps.repository.FaceSnapsRepository;

@Service
public class FaceSnapService {

    @Autowired
    private FaceSnapsRepository faceSnapRepository;

    // Méthode pour mettre à jour le nombre de snaps
    public Face updateFaceSnap(String id, Face faceSnap) {
        Face existingFaceSnap = faceSnapRepository.findById(id).orElseThrow(() -> new RuntimeException("FaceSnap non trouvé"));
        existingFaceSnap.setSnaps(faceSnap.getSnaps()); // Met à jour le nombre de snaps
        return faceSnapRepository.save(existingFaceSnap); // Sauvegarde les modifications
    }
}
