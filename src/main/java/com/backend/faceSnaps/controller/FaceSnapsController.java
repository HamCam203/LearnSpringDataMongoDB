package com.backend.faceSnaps.controller;

import com.backend.faceSnaps.model.Face;
import com.backend.faceSnaps.repository.FaceSnapsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
