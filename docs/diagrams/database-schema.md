# Database Schema - ToDoList Collaborative

## Entity Relationship Diagram

```
┌─────────────────┐       ┌─────────────────┐       ┌─────────────────┐
│   UTILISATEUR   │       │     PROJET      │       │      TACHE      │
├─────────────────┤       ├─────────────────┤       ├─────────────────┤
│ id (PK)         │       │ id (PK)         │       │ id (PK)         │
│ nom             │       │ nom             │       │ titre           │
│ email           │       │ description     │       │ description     │
│ mot_de_passe    │       │ date_creation   │       │ statut          │
│ role            │       │ id_createur (FK)│       │ priorite        │
│ date_creation   │       └─────────────────┘       │ date_limite     │
│ date_modification│                                 │ id_projet (FK)  │
└─────────────────┘                                 │ id_utilisateur  │
         │                                           │ _assigné (FK)   │
         │                                           │ date_creation   │
         │                                           │ date_modification│
         │                                           └─────────────────┘
         │                                                    │
         │                                                    │
         │ 1:Many                                             │
         │                                                    │
         │                                           ┌─────────────────┐
         │                                           │ PROJET_MEMBRE   │
         │                                           ├─────────────────┤
         │                                           │ id (PK)         │
         │                                           │ id_projet (FK)  │
         │                                           │ id_utilisateur  │
         │                                           │ (FK)            │
         │                                           │ role_projet     │
         │                                           │ date_ajout      │
         │                                           └─────────────────┘
         │
         │ Many:Many
         │
         └─────────────────────────────────────────────────────┘
```

## Relationships

### 1-to-Many Relationships
1. **Utilisateur → Tâche** (1:Many)
   - One user can have multiple tasks assigned
   - Foreign Key: `tache.id_utilisateur_assigné`

2. **Projet → Tâche** (1:Many)
   - One project can contain multiple tasks
   - Foreign Key: `tache.id_projet`

3. **Utilisateur → Projet** (1:Many)
   - One user can create multiple projects
   - Foreign Key: `projet.id_createur`

### Many-to-Many Relationship
1. **Utilisateur ↔ Projet** (Many:Many)
   - Users can be members of multiple projects
   - Projects can have multiple members
   - Junction table: `projet_membre`

## Table Descriptions

### UTILISATEUR
- **Purpose**: Store user information and authentication data
- **Key Fields**: 
  - `email`: Unique identifier for login
  - `role`: ADMIN or MEMBRE
  - `mot_de_passe`: Encrypted password

### PROJET
- **Purpose**: Store project information and metadata
- **Key Fields**:
  - `nom`: Project name
  - `description`: Project description
  - `id_createur`: Reference to project creator

### TACHE
- **Purpose**: Store task information and assignments
- **Key Fields**:
  - `statut`: A_FAIRE, EN_COURS, TERMINE
  - `priorite`: BASSE, NORMALE, HAUTE, URGENTE
  - `date_limite`: Task deadline
  - `id_projet`: Reference to parent project
  - `id_utilisateur_assigné`: Reference to assigned user

### PROJET_MEMBRE
- **Purpose**: Manage project membership (Many-to-Many)
- **Key Fields**:
  - `role_projet`: CREATEUR, ADMIN, MEMBRE
  - Unique constraint on (id_projet, id_utilisateur)

## Indexes
- `idx_email` on `utilisateur.email`
- `idx_projet` on `tache.id_projet`
- `idx_utilisateur` on `tache.id_utilisateur_assigné`
- `idx_statut` on `tache.statut`
- `idx_priorite` on `tache.priorite`
- `idx_date_limite` on `tache.date_limite`

## Sample Data
The database includes sample data for testing:
- 4 users (1 admin, 3 members)
- 3 projects
- 8 tasks with different statuses and priorities
- Project memberships
