package com.backend.faceSnaps.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "facesnaps")
public class Face {

    @Id
    private String id;
    private String title;
    private String description;
    private String imageUrl; // URL de l'image (optionnel)
    private String imageBase64; // Image en base64 (optionnel)
    private Date createdAt;
    private int snaps;

    // 🛠 Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getSnaps() {
        return snaps;
    }

    public void setSnaps(int snaps) {
        this.snaps = snaps;
    }

    // 🎯 Constructeur par défaut
    public Face() {}

    // 🎯 Constructeur avec paramètres
    public Face(String title, String description, String imageUrl, String imageBase64, Date createdAt, int snaps) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.imageBase64 = imageBase64;
        this.createdAt = createdAt;
        this.snaps = snaps;
    }

    // Méthode toString() pour affichage
    @Override
    public String toString() {
        return "FaceSnaps{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageBase64='" + imageBase64 + '\'' +
                ", createdAt=" + createdAt +
                ", snaps=" + snaps +
                '}';
    }
}
