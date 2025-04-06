# 📸 FaceSnaps Backend

Bienvenue dans **FaceSnaps**, une application backend développée en **Spring Boot** avec **MongoDB**.  
Ce projet sert d'API pour gérer des "FaceSnaps", permettant de créer, récupérer et mettre à jour les données des utilisateurs.

## 🚀 Fonctionnalités

- 📌 **Gestion complète des FaceSnaps** :
  - Création
  - Récupération (tous / par ID)
  - Mise à jour complète
  - Suppression
- 🔄 **Mise à jour dynamique des données**
- 🌍 **CORS activé** : Interaction fluide avec un frontend Angular (port 4200)

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

## 📡 API Endpoints

| Méthode | Endpoint                | Description                                 |
|---------|-------------------------|---------------------------------------------|
| `GET`   | `/api/facesnaps`        | 🔍 Récupérer tous les FaceSnaps              |
| `GET`   | `/api/facesnaps/{id}`   | 🔍 Récupérer un FaceSnap par son ID          |
| `POST`  | `/api/facesnaps`        | ➕ Créer un nouveau FaceSnap                 |
| `PUT`   | `/api/facesnaps/{id}`   | ✏️ Mettre à jour un FaceSnap existant        |
| `DELETE`| `/api/facesnaps/{id}`   | 🗑️ Supprimer un FaceSnap par son ID          |

## 🔧 Configuration et Lancement

### 🗄️ Configurer la base de données  
Assurez-vous d'avoir **MongoDB** en cours d'exécution.

### 🚀 Lancer l’application  
```
mvn spring-boot:run
```

### 🌍 Accéder à l'API
L’API est disponible sur : http://localhost:8080/api/facesnaps
