# 📸 FaceSnaps Backend

Bienvenue dans **FaceSnaps**, une application backend développée en **Spring Boot** avec **MongoDB**.  
Ce projet sert d'API pour gérer des "FaceSnaps", permettant de créer, récupérer et mettre à jour les données des utilisateurs.

## 🚀 Fonctionnalités

- 📌 **Gestion des FaceSnaps** : Récupération et mise à jour des snaps.
- 🔄 **Mise à jour des snaps** : Incrémentation du nombre de snaps d’un FaceSnap.
- 🌍 **CORS configuré** : Communication fluide entre Angular (frontend) et Spring Boot (backend).

## 📂 Structure du projet
```
faceSnaps-backend/
│── src/
│   ├── main/
│   │   ├── java/com/backend/faceSnaps/
│   │   │   ├── config/                
│   │   │   │   ├── CorsConfig.java
│   │   │   ├── controller/            
│   │   │   │   ├── FaceSnapsController.java
│   │   │   ├── model/                 
│   │   │   │   ├── Face.java
│   │   │   ├── repository/            
│   │   │   │   ├── FaceSnapsRepository.java
│   │   │   ├── services/              
│   │   │   │   ├── FaceSnapService.java
│   │   │   ├── FaceSnapsApplication.java  
│   ├── resources/
│   │   ├── application.properties     
```

## 🛠 Technologies utilisées

- **Java 17** avec **Spring Boot**
- **MongoDB** pour la base de données
- **Maven** pour la gestion des dépendances
- **Spring Data MongoDB** pour les opérations CRUD
- **Spring Web** pour les APIs REST


## 📡 Endpoints API

| Méthode | Endpoint               | Description                      |
|---------|------------------------|----------------------------------|
| `GET`   | `/api/facesnaps`       | Récupérer tous les FaceSnaps    |
| `PUT`   | `/api/facesnaps/{id}`  | Mettre à jour un FaceSnap       |

## 🔧 Configuration et Lancement

### 🗄️ Configurer la base de données  
Assurez-vous d'avoir **MongoDB** en cours d'exécution.

### 🚀 Lancer l’application  
```
mvn spring-boot:run
```

### 🌍 Accéder à l'API
L’API est disponible sur : http://localhost:8080/api/facesnaps
