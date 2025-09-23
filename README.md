# ToDoList Collaborative

## 🎯 Description

Application de gestion de tâches collaboratives développée avec Spring Boot, Angular et MySQL, containerisée avec Docker.

## 🚀 Démarrage rapide

### Prérequis
- Docker et Docker Compose
- Git

### Installation
```bash
git clone https://github.com/VOTRE_USERNAME/todolist-collaborative.git
cd todolist-collaborative
docker-compose up -d
```

### Accès
- **Frontend** : http://localhost:4200
- **Backend API** : http://localhost:8080/api/health
- **Base de données** : localhost:3306

## 🛠️ Technologies

- **Backend** : Spring Boot 2.7.18, Java 11, Spring Security, MySQL
- **Frontend** : Angular 16, TypeScript, CSS3
- **Base de données** : MySQL 8.0
- **Containerisation** : Docker, Docker Compose

## 📁 Structure

```
todolist-collaborative/
├── backend/          # Spring Boot API
├── frontend/         # Angular Application  
├── database/         # Scripts MySQL
├── docker/           # Configuration Docker
└── docker-compose.yml
```

## 🚀 Prochaines étapes

1. Créer les modèles de données (User, Project, Task)
2. Implémenter les contrôleurs REST
3. Développer l'interface utilisateur
4. Ajouter l'authentification JWT
5. Implémenter les fonctionnalités collaboratives

## �� Contribution

1. Fork le projet
2. Créer une branche feature (`git checkout -b feature/nouvelle-fonctionnalite`)
3. Commit les changements
4. Push vers la branche
5. Créer une Pull Request

---

**Projet prêt pour le développement collaboratif ! 🎉**
