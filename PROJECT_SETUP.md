# Configuration du Projet GitHub - ToDoList Collaborative

## 🚀 Étapes pour Configurer le Repository GitHub

### 1. Créer le Repository sur GitHub

1. Allez sur [GitHub.com](https://github.com)
2. Cliquez sur "New repository"
3. Nom du repository : `todolist-collaborative`
4. Description : `Application web collaborative de gestion de tâches avec Spring Boot, Angular et MySQL`
5. Visibilité : **Public** (pour la collaboration)
6. **Ne pas** initialiser avec README (nous avons déjà notre structure)

### 2. Connecter le Repository Local

```bash
# Ajouter le remote GitHub
git remote add origin https://github.com/VOTRE_USERNAME/todolist-collaborative.git

# Pousser les branches
git push -u origin main
git push -u origin develop
```

### 3. Configuration des Branches

#### Protection des Branches
1. Allez dans **Settings** > **Branches**
2. Ajoutez une règle pour `main` :
   - ✅ Require pull request reviews before merging
   - ✅ Require status checks to pass before merging
   - ✅ Require branches to be up to date before merging
3. Ajoutez une règle pour `develop` :
   - ✅ Require pull request reviews before merging

### 4. Inviter les Collaborateurs

#### Méthode 1 : Via GitHub Interface
1. Allez dans **Settings** > **Manage access**
2. Cliquez sur **Invite a collaborator**
3. Entrez l'email ou username GitHub
4. Choisissez le niveau d'accès :
   - **Read** : Consultation uniquement
   - **Triage** : Gestion des issues
   - **Write** : Push et pull requests
   - **Maintain** : Administration du repository
   - **Admin** : Accès complet

#### Méthode 2 : Via Invitation Email
1. Envoyez le lien : `https://github.com/VOTRE_USERNAME/todolist-collaborative/invitations`
2. Les collaborateurs peuvent accepter l'invitation

### 5. Configuration des Projets GitHub

#### Créer un Project Board
1. Allez dans l'onglet **Projects**
2. Cliquez sur **New project**
3. Nom : `ToDoList Collaborative - Sprint Planning`
4. Template : **Basic kanban**

#### Colonnes du Board
- **Backlog** : Tâches à faire
- **To Do** : Tâches assignées
- **In Progress** : En cours de développement
- **Review** : En attente de review
- **Done** : Terminées

### 6. Configuration des Labels

#### Labels Recommandés
- `bug` : Corrections de bugs
- `enhancement` : Nouvelles fonctionnalités
- `documentation` : Documentation
- `good first issue` : Bon pour débuter
- `help wanted` : Besoin d'aide
- `priority: high` : Priorité haute
- `priority: medium` : Priorité moyenne
- `priority: low` : Priorité basse
- `backend` : Backend Spring Boot
- `frontend` : Frontend Angular
- `database` : Base de données
- `devops` : Docker et déploiement

### 7. Configuration des Milestones

#### Milestones du Projet
- **Sprint 1** : Setup et authentification
- **Sprint 2** : CRUD Utilisateurs et Projets
- **Sprint 3** : CRUD Tâches et attribution
- **Sprint 4** : Interface utilisateur
- **Sprint 5** : Tests et optimisation
- **Sprint 6** : Documentation et déploiement

### 8. Configuration des Discussions

1. Allez dans **Settings** > **General**
2. Activez **Discussions**
3. Créez des catégories :
   - **General** : Discussions générales
   - **Q&A** : Questions et réponses
   - **Ideas** : Nouvelles idées
   - **Show and tell** : Partage de réalisations

### 9. Configuration des Actions GitHub

Le fichier `.github/workflows/ci.yml` est déjà configuré pour :
- Tests automatiques du backend
- Tests automatiques du frontend
- Build des images Docker
- Tests d'intégration

### 10. Configuration des Notifications

#### Pour les Collaborateurs
1. Allez dans **Settings** > **Notifications**
2. Configurez les notifications pour :
   - Issues et Pull Requests
   - Actions GitHub
   - Discussions

### 11. Template de Pull Request

Le fichier `.github/pull_request_template.md` sera automatiquement utilisé pour les PR.

### 12. Code of Conduct

Ajoutez un fichier `CODE_OF_CONDUCT.md` pour définir les règles de collaboration.

## 📋 Checklist de Configuration

- [ ] Repository créé sur GitHub
- [ ] Repository local connecté
- [ ] Branches protégées configurées
- [ ] Collaborateurs invités
- [ ] Project board créé
- [ ] Labels configurés
- [ ] Milestones créés
- [ ] Discussions activées
- [ ] Actions GitHub configurées
- [ ] Templates configurés

## 👥 Rôles Recommandés

### Project Owner (Vous)
- Administration complète du repository
- Gestion des releases
- Décisions architecturales

### Backend Developers
- Accès **Write** au repository
- Responsables du code Spring Boot
- Review des PR backend

### Frontend Developers
- Accès **Write** au repository
- Responsables du code Angular
- Review des PR frontend

### DevOps Engineer
- Accès **Maintain** au repository
- Configuration CI/CD
- Gestion des déploiements

### UI/UX Designer
- Accès **Triage** au repository
- Gestion des issues design
- Review des interfaces

## 🔗 Liens Utiles

- **Repository** : `https://github.com/VOTRE_USERNAME/todolist-collaborative`
- **Issues** : `https://github.com/VOTRE_USERNAME/todolist-collaborative/issues`
- **Projects** : `https://github.com/VOTRE_USERNAME/todolist-collaborative/projects`
- **Discussions** : `https://github.com/VOTRE_USERNAME/todolist-collaborative/discussions`
- **Actions** : `https://github.com/VOTRE_USERNAME/todolist-collaborative/actions`

---

**Une fois cette configuration terminée, votre équipe pourra collaborer efficacement sur le projet ! 🎉**
