# Guide de Contribution - ToDoList Collaborative

## 🚀 Comment Contribuer

### 1. Configuration Initiale
```bash
# Fork et clone
git clone https://github.com/VOTRE_USERNAME/todolist-collaborative.git
cd todolist-collaborative

# Créer une branche
git checkout -b feature/nom-de-votre-fonctionnalite
```

### 2. Workflow de Développement

#### Branches
- `main` : Code de production stable
- `develop` : Code de développement intégré
- `feature/*` : Nouvelles fonctionnalités
- `bugfix/*` : Corrections de bugs

### 3. Standards de Code

#### Backend (Spring Boot)
- Java 11+
- Conventions Spring Boot
- Tests unitaires
- Documentation JavaDoc

#### Frontend (Angular)
- TypeScript strict
- Style guide Angular
- Tests unitaires
- Angular Material pour l'UI

### 4. Processus de Pull Request

#### Avant de Soumettre
```bash
# Synchroniser avec le repository principal
git fetch upstream
git checkout develop
git merge upstream/develop

# Mettre à jour votre branche
git checkout feature/votre-branche
git rebase develop

# Tester
docker-compose up -d
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
```

### 5. Rôles et Responsabilités

#### Backend Developer
- APIs REST Spring Boot
- Sécurité (JWT)
- Optimisation DB
- Tests unitaires

#### Frontend Developer
- Interface Angular
- Intégration APIs
- Tests Angular
- Responsive design

#### DevOps Engineer
- Configuration Docker
- CI/CD Pipeline
- Monitoring
- Déploiement

### 6. Communication

- **Issues GitHub** : Bugs et nouvelles fonctionnalités
- **Discussions** : Questions générales
- **Pull Requests** : Reviews de code
- **Projects** : Suivi des tâches

### 7. Outils Requis

- Java 11+
- Node.js 18+
- Docker & Docker Compose
- Git
- IDE (IntelliJ IDEA / VS Code)

---

**Merci de contribuer au projet ToDoList Collaborative ! 🎉**
