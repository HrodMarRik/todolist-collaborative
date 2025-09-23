# Guide de Contribution - ToDoList Collaborative

## 🚀 Comment Contribuer

### 1. Configuration Initiale

#### Fork et Clone
```bash
# Fork le repository sur GitHub
# Puis clonez votre fork
git clone https://github.com/VOTRE_USERNAME/todolist-collaborative.git
cd todolist-collaborative

# Ajoutez le repository original comme remote
git remote add upstream https://github.com/ORIGINAL_OWNER/todolist-collaborative.git
```

#### Configuration des Branches
```bash
# Créez une branche pour votre fonctionnalité
git checkout -b feature/nom-de-votre-fonctionnalite

# Ou pour un bug fix
git checkout -b bugfix/description-du-bug
```

### 2. Workflow de Développement

#### Branches Principales
- `main` : Code de production stable
- `develop` : Code de développement intégré

#### Types de Branches
- `feature/*` : Nouvelles fonctionnalités
- `bugfix/*` : Corrections de bugs
- `hotfix/*` : Corrections urgentes
- `docs/*` : Documentation uniquement

### 3. Standards de Code

#### Backend (Spring Boot)
- Utilisez Java 17+
- Suivez les conventions Spring Boot
- Ajoutez des tests unitaires
- Documentez les APIs avec JavaDoc

#### Frontend (Angular)
- Utilisez TypeScript strict
- Suivez le style guide Angular
- Ajoutez des tests unitaires
- Utilisez Angular Material pour l'UI

#### Base de Données
- Utilisez des migrations pour les changements de schéma
- Documentez les nouvelles tables/colonnes
- Testez les requêtes de performance

### 4. Processus de Pull Request

#### Avant de Soumettre
```bash
# Synchronisez avec le repository principal
git fetch upstream
git checkout develop
git merge upstream/develop

# Mettez à jour votre branche
git checkout feature/votre-branche
git rebase develop

# Testez votre code
cd backend && mvn test
cd ../frontend && npm test
```

#### Template de Pull Request
```markdown
## Description
Brève description des changements

## Type de Changement
- [ ] Bug fix
- [ ] Nouvelle fonctionnalité
- [ ] Breaking change
- [ ] Documentation

## Tests
- [ ] Tests unitaires ajoutés/mis à jour
- [ ] Tests d'intégration
- [ ] Tests manuels effectués

## Checklist
- [ ] Code conforme aux standards
- [ ] Documentation mise à jour
- [ ] Pas de conflits avec develop
```

### 5. Structure du Projet

```
todolist-collaborative/
├── backend/          # Spring Boot API
├── frontend/         # Angular Application
├── database/         # Scripts SQL
├── docker/           # Configuration Docker
├── docs/             # Documentation
└── .github/          # GitHub Actions & Templates
```

### 6. Rôles et Responsabilités

#### Backend Developer
- Développement des APIs REST
- Gestion de la sécurité (JWT)
- Optimisation des requêtes DB
- Tests unitaires et d'intégration

#### Frontend Developer
- Développement de l'interface utilisateur
- Intégration avec les APIs
- Tests unitaires Angular
- Responsive design

#### DevOps Engineer
- Configuration Docker
- CI/CD Pipeline
- Monitoring et logs
- Déploiement

#### UI/UX Designer
- Design des interfaces
- Expérience utilisateur
- Prototypes et maquettes
- Tests utilisateur

### 7. Communication

#### Channels de Communication
- **Issues GitHub** : Bugs et nouvelles fonctionnalités
- **Discussions** : Questions générales
- **Pull Requests** : Reviews de code
- **Projects** : Suivi des tâches

#### Réunions
- **Daily Standup** : 15 min chaque matin
- **Sprint Planning** : Début de chaque sprint
- **Retrospective** : Fin de chaque sprint

### 8. Outils de Développement

#### Requis
- Java 17+
- Node.js 18+
- Docker & Docker Compose
- Git
- IDE (IntelliJ IDEA / VS Code)

#### Recommandés
- Postman (API testing)
- MySQL Workbench (DB management)
- Angular DevTools
- Spring Boot DevTools

### 9. Ressources

#### Documentation
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Angular Documentation](https://angular.io/docs)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Docker Documentation](https://docs.docker.com/)

#### Tutoriels
- [Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/)
- [Angular Tutorial](https://angular.io/tutorial)
- [Docker Tutorial](https://docs.docker.com/get-started/)

### 10. Support

Pour toute question :
1. Consultez la documentation
2. Recherchez dans les issues existantes
3. Créez une nouvelle issue si nécessaire
4. Contactez l'équipe via Discussions

---

**Merci de contribuer au projet ToDoList Collaborative ! 🎉**
