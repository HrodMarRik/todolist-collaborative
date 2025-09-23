# ToDoList Collaborative

Une application de gestion de tâches collaboratives développée avec Spring Boot, Angular et MySQL, le tout containerisé avec Docker.

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
├── backend/                 # API Spring Boot
│   ├── src/main/java/      # Code source Java
│   └── pom.xml             # Configuration Maven
├── frontend/               # Application Angular
│   ├── src/app/            # Code source Angular
│   └── package.json        # Configuration npm
├── database/               # Scripts de base de données
│   └── schema/             # Schéma SQL
├── docker/                 # Configuration Docker
│   ├── backend/            # Dockerfile backend
│   ├── frontend/           # Dockerfile frontend
│   └── mysql/              # Dockerfile MySQL
└── docker-compose.yml      # Orchestration Docker
```

## 🛠️ Développement

### Backend (Spring Boot)
- **Port** : 8080
- **Base de données** : MySQL (todolist_db)
- **API** : REST avec Spring Boot 2.7.18
- **Sécurité** : Spring Security + JWT

### Frontend (Angular)
- **Port** : 4200
- **Framework** : Angular 16
- **Build** : Nginx pour la production

### Base de données (MySQL)
- **Port** : 3306
- **Base** : todolist_db
- **Utilisateur** : todolist_user
- **Mot de passe** : todolist_password

## 🔧 Configuration

### Variables d'environnement

Les variables sont configurées dans `docker-compose.yml` :

```yaml
environment:
  SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/todolist_db
  SPRING_DATASOURCE_USERNAME: todolist_user
  SPRING_DATASOURCE_PASSWORD: todolist_password
```

### Base de données

La base de données est initialisée automatiquement avec le script `database/schema/init.sql`.

## 📝 API Endpoints

### Health Check
- `GET /api/health` - Vérification de l'état de l'API

## 🤝 Contribution

1. Fork le projet
2. Créer une branche feature (`git checkout -b feature/nouvelle-fonctionnalite`)
3. Commit les changements (`git commit -m 'Ajouter nouvelle fonctionnalité'`)
4. Push vers la branche (`git push origin feature/nouvelle-fonctionnalite`)
5. Ouvrir une Pull Request

## 📋 Prochaines étapes

- [ ] Implémenter l'authentification JWT
- [ ] Créer les modèles de données (User, Project, Task)
- [ ] Développer l'API REST complète
- [ ] Créer l'interface utilisateur Angular
- [ ] Ajouter les tests unitaires et d'intégration
- [ ] Configurer CI/CD avec GitHub Actions

## 🐛 Dépannage

### Problèmes courants

1. **Port déjà utilisé**
   ```bash
   # Vérifier les ports utilisés
   netstat -tulpn | grep :8080
   # Arrêter les services Docker
   docker-compose down
   ```

2. **Erreur de build**
   ```bash
   # Nettoyer et reconstruire
   docker-compose down
   docker-compose build --no-cache
   docker-compose up -d
   ```

3. **Problème de base de données**
   ```bash
   # Supprimer le volume et redémarrer
   docker-compose down -v
   docker-compose up -d
   ```

## 📄 Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.

## 👥 Équipe

- **Backend** : [Votre nom]
- **Frontend** : [Votre nom]
- **DevOps** : [Votre nom]

---

**Note** : Ce projet est actuellement en phase de développement initial. La base de données est vide et prête pour le développement.
