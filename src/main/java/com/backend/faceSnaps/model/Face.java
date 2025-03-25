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
    private String imageUrl;
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
    public Face(String title, String description, String imageUrl, Date createdAt, int snaps) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
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
                ", createdAt=" + createdAt +
                ", snaps=" + snaps +
                '}';
    }
}
