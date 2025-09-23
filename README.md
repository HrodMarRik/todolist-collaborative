# ToDoList Collaborative - Application Web de Gestion de Tâches

## �� Description du Projet

Application web collaborative permettant aux équipes de projet de créer, attribuer et suivre des tâches collectives en temps réel.

## 🏗️ Architecture Technique

- **Backend**: Spring Boot 3.2.0 + Java 17
- **Frontend**: Angular 17
- **Base de données**: MySQL 8.0
- **Containerisation**: Docker & Docker Compose
- **Sécurité**: Spring Security + JWT

## 🚀 Fonctionnalités Principales

### Fonctionnalités Obligatoires
- ✅ **Gestion des utilisateurs** : Inscription/connexion des membres
- ✅ **Création de projets** : Création et invitation de membres
- ✅ **Gestion des tâches** : CRUD complet avec statuts
- ✅ **Attribution des tâches** : Relation 1-to-Many (Utilisateur ↔ Tâches)
- ✅ **Tableau de bord** : Visualisation par projet/membre/statut

### Fonctionnalités Bonus
- 🔔 Notifications en temps réel
- 📊 Historique des modifications
- 📄 Export PDF/Excel
- 🎨 Interface moderne avec Angular Material

## 🗄️ Modèle de Données

### Relations 1-to-Many
- **Utilisateur** (1) → (Many) **Tâche**
- **Projet** (1) → (Many) **Tâche**

### Tables Principales
- `utilisateur` : Gestion des utilisateurs et rôles
- `projet` : Projets collaboratifs
- `tache` : Tâches avec attribution et statuts
- `projet_membre` : Relation Many-to-Many pour les membres de projet

## 🛠️ Installation et Démarrage

### Prérequis
- Docker & Docker Compose
- Java 17+ (pour développement local)
- Node.js 18+ (pour développement local)
- Maven 3.9+ (pour développement local)

### Démarrage avec Docker (Recommandé)

```bash
# Cloner le repository
git clone <repository-url>
cd todolist-collaborative

# Démarrer tous les services
docker-compose up -d

# Vérifier le statut
docker-compose ps
```

### Accès aux Services
- **Frontend Angular**: http://localhost:4200
- **Backend Spring Boot**: http://localhost:8080
- **Base de données MySQL**: localhost:3306

### Démarrage en Mode Développement

#### Backend (Spring Boot)
```bash
cd backend
mvn spring-boot:run
```

#### Frontend (Angular)
```bash
cd frontend
npm install
npm start
```

#### Base de données MySQL
```bash
# Avec Docker
docker run -d --name mysql-todolist \
  -e MYSQL_ROOT_PASSWORD=root_password \
  -e MYSQL_DATABASE=todolist_db \
  -e MYSQL_USER=todolist_user \
  -e MYSQL_PASSWORD=todolist_password \
  -p 3306:3306 \
  mysql:8.0
```

## 📁 Structure du Projet

```
todolist-collaborative/
├── backend/                 # Spring Boot Backend
│   ├── src/main/java/       # Code source Java
│   ├── src/main/resources/  # Configuration & ressources
│   └── pom.xml             # Dépendances Maven
├── frontend/               # Angular Frontend
│   ├── src/app/            # Code source Angular
│   ├── src/assets/         # Assets statiques
│   └── package.json        # Dépendances NPM
├── database/               # Scripts SQL
│   ├── schema/             # Schéma de base de données
│   └── scripts/            # Scripts utilitaires
├── docker/                 # Configuration Docker
│   ├── mysql/              # Dockerfile MySQL
│   ├── backend/            # Dockerfile Spring Boot
│   ├── frontend/           # Dockerfile Angular
│   └── docker-compose.yml  # Orchestration des services
└── docs/                   # Documentation
    ├── api/                # Documentation API
    ├── diagrams/           # Diagrammes
    └── deployment/         # Guide de déploiement
```

## 🔧 Configuration

### Variables d'Environnement

#### Backend (application.properties)
```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/todolist_db
spring.datasource.username=todolist_user
spring.datasource.password=todolist_password

# JWT
jwt.secret=mySecretKey123456789012345678901234567890
jwt.expiration=86400000

# CORS
cors.allowed-origins=http://localhost:4200
```

#### Frontend (environment.ts)
```typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api',
  appName: 'ToDoList Collaborative'
};
```

## 🧪 Tests

### Backend Tests
```bash
cd backend
mvn test
```

### Frontend Tests
```bash
cd frontend
npm test
```

## 📊 API Endpoints

### Authentification
- `POST /api/auth/login` - Connexion
- `POST /api/auth/register` - Inscription
- `POST /api/auth/refresh` - Rafraîchir token

### Utilisateurs
- `GET /api/users` - Liste des utilisateurs
- `GET /api/users/{id}` - Détails utilisateur
- `PUT /api/users/{id}` - Modifier utilisateur

### Projets
- `GET /api/projects` - Liste des projets
- `POST /api/projects` - Créer projet
- `GET /api/projects/{id}` - Détails projet
- `PUT /api/projects/{id}` - Modifier projet
- `DELETE /api/projects/{id}` - Supprimer projet

### Tâches
- `GET /api/tasks` - Liste des tâches
- `POST /api/tasks` - Créer tâche
- `GET /api/tasks/{id}` - Détails tâche
- `PUT /api/tasks/{id}` - Modifier tâche
- `DELETE /api/tasks/{id}` - Supprimer tâche
- `PUT /api/tasks/{id}/status` - Changer statut

## 🚀 Déploiement

### Production avec Docker
```bash
# Build des images
docker-compose build

# Démarrage en production
docker-compose -f docker-compose.yml -f docker-compose.prod.yml up -d
```

### Variables d'environnement de production
- Configurer les URLs de base de données
- Changer les secrets JWT
- Configurer les domaines CORS

## 👥 Équipe de Développement

- **Backend**: Développeurs Java/Spring Boot
- **Frontend**: Développeurs Angular/TypeScript
- **DevOps**: Configuration Docker et déploiement
- **UI/UX**: Design et expérience utilisateur

## 📈 Roadmap

### Version 1.0 (Actuelle)
- [x] Authentification JWT
- [x] CRUD Utilisateurs/Projets/Tâches
- [x] Interface Angular Material
- [x] Containerisation Docker

### Version 1.1 (Prochaine)
- [ ] Notifications en temps réel
- [ ] Historique des modifications
- [ ] Export PDF/Excel
- [ ] Tests automatisés

### Version 2.0 (Future)
- [ ] Application mobile (React Native)
- [ ] Intégration calendrier
- [ ] Rapports avancés
- [ ] Intégration Slack/Discord

## �� Issues et Support

Pour signaler un bug ou demander une fonctionnalité :
1. Créer une issue sur GitHub
2. Décrire le problème de manière détaillée
3. Fournir les logs si nécessaire

## 📄 Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.

## 🤝 Contribution

Les contributions sont les bienvenues ! Merci de :
1. Fork le projet
2. Créer une branche feature (`git checkout -b feature/AmazingFeature`)
3. Commit les changements (`git commit -m 'Add some AmazingFeature'`)
4. Push vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrir une Pull Request

---

**Développé avec ❤️ par l'équipe ToDoList Collaborative**
