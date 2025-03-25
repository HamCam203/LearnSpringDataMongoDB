package com.backend.faceSnaps;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.backend.faceSnaps.model.Face;
import com.backend.faceSnaps.repository.FaceSnapsRepository;

@SpringBootApplication
public class FaceSnapsApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(FaceSnapsApplication.class);

    @Autowired
    private FaceSnapsRepository faceSnapsRepository;

    public static void main(String[] args) {
        SpringApplication.run(FaceSnapsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Application started!");

        // Récupérer tous les FaceSnaps
        List<Face> allFaceSnaps = faceSnapsRepository.findAll();

        // Afficher les titres des FaceSnaps
        allFaceSnaps.forEach(faceSnap -> logger.info(faceSnap.getTitle()));
    }
}
