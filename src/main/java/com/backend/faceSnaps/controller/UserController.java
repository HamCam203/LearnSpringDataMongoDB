package com.backend.faceSnaps.controller;
import com.backend.faceSnaps.model.User;
import com.backend.faceSnaps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Enregistrement d'un nouvel utilisateur
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        // Vérifie si l'email est déjà utilisé
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        user.setCreatedAt(new Date(System.currentTimeMillis()));
        // 💡 Ajouter le hashage du mot de passe ici
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // Connexion d'un utilisateur (très simplifiée ici)
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());

        if (foundUser.isPresent() && foundUser.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(foundUser.get());
        } else {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

