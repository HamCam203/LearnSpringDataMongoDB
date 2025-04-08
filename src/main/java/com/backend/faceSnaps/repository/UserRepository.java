package com.backend.faceSnaps.repository;

import com.backend.faceSnaps.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    // Méthode pour trouver un utilisateur par son email
    Optional<User> findByEmail(String email);

    // Méthode pour trouver un utilisateur par son nom d'utilisateur
    Optional<User> findByUsername(String username);

    // Méthode pour trouver un utilisateur par son ID
    Optional<User> findById(String id);

    // Méthode pour supprimer un utilisateur par son ID
    void deleteById(String id);

    // Méthode pour récupérer tous les utilisateurs
    List<User> findAll();

    // Méthode pour enregistrer ou mettre à jour un utilisateur
    User save(User user);

}
