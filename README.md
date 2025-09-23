# ToDoList Collaborative - Projet Vide Prêt pour le Développement

## 🎯 Description

Ce projet est une application de gestion de tâches collaboratives développée avec Spring Boot, Angular et MySQL, le tout containerisé avec Docker. Le projet est configuré comme un template vide prêt pour le développement en équipe.

## 🚀 Démarrage rapide

### Prérequis
- Docker et Docker Compose installés
- Git

### Installation et lancement

1. **Cloner le projet**
   ```bash
   git clone https://github.com/VOTRE_USERNAME/todolist-collaborative.git
   cd todolist-collaborative
   ```

2. **Lancer l'application avec Docker**
   ```bash
   docker-compose up -d
   ```

3. **Accéder à l'application**
   - Frontend Angular : http://localhost:4200
   - Backend API : http://localhost:8080
   - Base de données MySQL : localhost:3306

### Commandes utiles

```bash
# Démarrer tous les services
docker-compose up -d

# Voir les logs
docker-compose logs -f

# Arrêter tous les services
docker-compose down

# Reconstruire les images
docker-compose build --no-cache

# Accéder à la base de données
docker exec -it todolist-mysql mysql -u todolist_user -p todolist_db
```

## 📁 Structure du projet

```
todolist-collaborative/
├── backend/                 # Spring Boot Backend
│   ├── src/main/java/com/todolist/
│   │   ├── TodolistCollaborativeApplication.java
│   │   ├── controller/
│   │   │   └── HealthController.java
│   │   └── config/
│   │       └── SecurityConfig.java
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   ├── application-dev.properties
│   │   └── application-prod.properties
│   └── pom.xml
├── frontend/                # Angular Frontend
│   ├── src/
│   │   ├── app/
│   │   │   ├── app.component.ts
│   │   │   └── app.module.ts
│   │   ├── assets/
│   │   ├── styles.css
│   │   ├── index.html
│   │   └── main.ts
│   ├── angular.json
│   ├── package.json
│   ├── tsconfig.json
│   ├── tsconfig.app.json
│   └── tsconfig.spec.json
├── database/                # Scripts de base de données
│   └── schema/
│       └── init.sql
├── docker/                  # Configuration Docker
│   ├── mysql/
│   │   └── Dockerfile
│   ├── backend/
│   │   └── Dockerfile
│   └── frontend/
│       ├── Dockerfile
│       └── nginx.conf
├── docker-compose.yml       # Orchestration des services
├── README.md
└── .gitignore
```

## 🛠️ Technologies utilisées

- **Backend**: Spring Boot 2.7.18, Java 11, Spring Security, Spring Data JPA, MySQL Connector
- **Frontend**: Angular 16, TypeScript, CSS3
- **Base de données**: MySQL 8.0
- **Containerisation**: Docker, Docker Compose
- **Serveur web**: Nginx (pour le frontend)

## 🔧 Configuration

### Variables d'environnement

Les variables d'environnement sont configurées dans `docker-compose.yml` :

- **MySQL**:
  - `MYSQL_ROOT_PASSWORD`: root_password
  - `MYSQL_DATABASE`: todolist_db
  - `MYSQL_USER`: todolist_user
  - `MYSQL_PASSWORD`: todolist_password

- **Spring Boot**:
  - `SPRING_DATASOURCE_URL`: jdbc:mysql://mysql:3306/todolist_db
  - `SPRING_DATASOURCE_USERNAME`: todolist_user
  - `SPRING_DATASOURCE_PASSWORD`: todolist_password

### Ports

- **Frontend**: 4200
- **Backend**: 8080
- **MySQL**: 3306

## 📝 Développement

### Backend (Spring Boot)

Le backend est configuré avec :
- Un endpoint de santé : `GET /api/health`
- Configuration de sécurité basique
- Connexion à MySQL configurée
- Structure prête pour l'ajout de modèles, contrôleurs et services

### Frontend (Angular)

Le frontend est configuré avec :
- Une page d'accueil simple
- Styles CSS de base
- Configuration Angular prête pour le développement
- Proxy configuré pour les appels API

### Base de données

La base de données MySQL est initialisée avec un script vide (`init.sql`) prêt pour l'ajout de tables.

## 🚀 Prochaines étapes

1. **Créer les modèles de données** (User, Project, Task)
2. **Implémenter les contrôleurs REST**
3. **Développer l'interface utilisateur Angular**
4. **Ajouter l'authentification JWT**
5. **Implémenter les fonctionnalités collaboratives**

## 🤝 Contribution

1. Fork le projet
2. Créer une branche feature (`git checkout -b feature/nouvelle-fonctionnalite`)
3. Commit les changements (`git commit -am 'Ajouter nouvelle fonctionnalité'`)
4. Push vers la branche (`git push origin feature/nouvelle-fonctionnalite`)
5. Créer une Pull Request

## 📞 Support

Pour toute question ou problème, créer une issue sur GitHub.

---

**Projet prêt pour le développement collaboratif ! 🎉**
