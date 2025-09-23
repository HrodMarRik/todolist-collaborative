# Décisions Techniques et Architecture

## 📋 Vue d'ensemble

Ce document présente les décisions techniques prises pour le projet **ToDoList Collaborative**, justifiant le choix des technologies, versions et architectures utilisées.

---

## 🎯 Objectifs du Projet

- **Application collaborative** de gestion de tâches
- **Développement en équipe** avec plusieurs contributeurs
- **Déploiement simplifié** via Docker
- **Maintenance facilitée** avec des technologies éprouvées
- **Évolutivité** pour de futures fonctionnalités

---

## 🏗️ Architecture Générale

### **Pattern Architectural : Microservices Containerisés**

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Frontend      │    │   Backend       │    │   Database      │
│   Angular 16    │◄──►│   Spring Boot   │◄──►│   MySQL 8.0     │
│   Port 4200     │    │   Port 8080     │    │   Port 3306     │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
                    ┌─────────────────┐
                    │   Docker        │
                    │   Compose       │
                    └─────────────────┘
```

**Justification :**
- **Séparation des responsabilités** : Chaque service a un rôle défini
- **Scalabilité** : Possibilité de scaler chaque service indépendamment
- **Développement parallèle** : Les équipes peuvent travailler sur différents services
- **Déploiement simplifié** : Un seul `docker-compose up` pour tout lancer

---

## 🔧 Stack Technologique

### **Backend : Spring Boot 2.7.18**

#### **Version : 2.7.18 (LTS)**
- **Statut** : Long Term Support jusqu'en 2025
- **Stabilité** : Version éprouvée en production
- **Communauté** : Large adoption et support communautaire
- **Documentation** : Documentation complète et tutoriels abondants

#### **Java Version : 11**
- **Compatibilité** : Spring Boot 2.7.18 supporte Java 8, 11, 17
- **Adoption** : Java 11 largement utilisé en entreprise
- **Support LTS** : Support jusqu'en 2026
- **Écosystème** : Outils et bibliothèques matures

**Alternatives considérées :**
- ❌ **Java 8** : Trop ancien, manque de fonctionnalités modernes
- ❌ **Java 17** : Plus récent mais moins d'adoption en entreprise
- ❌ **Java 21** : Trop récent, incompatibilité avec Spring Boot 2.7.18

#### **Dépendances Principales**
```xml
- spring-boot-starter-web      # API REST
- spring-boot-starter-data-jpa # Persistance des données
- spring-boot-starter-security  # Authentification
- spring-boot-starter-validation # Validation des données
- mysql-connector-java         # Connecteur MySQL
```

### **Frontend : Angular 16**

#### **Version : 16.0.0**
- **Stabilité** : Version stable et éprouvée
- **Performance** : Améliorations significatives par rapport aux versions précédentes
- **TypeScript** : Support natif du TypeScript strict
- **Écosystème** : Large communauté et bibliothèques disponibles

**Alternatives considérées :**
- ❌ **Angular 15** : Version précédente, moins de fonctionnalités
- ❌ **Angular 17+** : Plus récent mais potentiels problèmes de compatibilité
- ❌ **React/Vue** : Changement de stack trop important

#### **Node.js Version : 18**
- **LTS** : Version Long Term Support
- **Compatibilité** : Parfaitement compatible avec Angular 16
- **Performance** : Améliorations significatives
- **Écosystème** : Support complet des packages npm

### **Base de Données : MySQL 8.0**

#### **Version : 8.0**
- **Performance** : Améliorations significatives par rapport à MySQL 5.7
- **Fonctionnalités** : Support des JSON, CTE, Window Functions
- **Sécurité** : Améliorations de sécurité importantes
- **Adoption** : Standard de l'industrie

**Alternatives considérées :**
- ❌ **PostgreSQL** : Excellent mais moins d'adoption en entreprise
- ❌ **MongoDB** : NoSQL, pas adapté pour une structure relationnelle
- ❌ **SQLite** : Trop limité pour une application collaborative

---

## 🐳 Containerisation : Docker

### **Docker Compose**
- **Orchestration** : Gestion simplifiée des services multiples
- **Développement** : Environnement de développement reproductible
- **Déploiement** : Déploiement simplifié en production
- **Isolation** : Chaque service dans son propre conteneur

### **Images Docker Utilisées**
```dockerfile
# Backend
FROM maven:3.8.6-openjdk-11    # Build
FROM openjdk:11-jdk-slim        # Runtime

# Frontend  
FROM node:18-alpine             # Build
FROM nginx:alpine               # Runtime

# Database
FROM mysql:8.0                 # Runtime
```

**Justification des images :**
- **Maven 3.8.6** : Version stable et compatible avec Java 11
- **Node 18 Alpine** : Image légère et performante
- **Nginx Alpine** : Serveur web léger et sécurisé
- **MySQL 8.0** : Version officielle avec toutes les fonctionnalités

---

## 🔒 Sécurité

### **Spring Security**
- **Authentification** : Gestion des utilisateurs et sessions
- **Autorisation** : Contrôle d'accès basé sur les rôles
- **Protection** : Protection contre les attaques courantes (CSRF, XSS)

### **JWT (JSON Web Tokens)**
- **Stateless** : Pas de session côté serveur
- **Scalabilité** : Facilite la montée en charge
- **Sécurité** : Tokens signés et vérifiés

---

## 🚀 CI/CD Pipeline

### **GitHub Actions**
- **Intégration** : Tests automatiques à chaque push
- **Qualité** : Validation du code avant merge
- **Déploiement** : Possibilité de déploiement automatique
- **Collaboration** : Feedback immédiat aux contributeurs

### **Pipeline en 3 étapes**
1. **Backend Tests** : Tests unitaires et d'intégration
2. **Frontend Tests** : Tests Angular et build
3. **Docker Build** : Validation des conteneurs

---

## 📊 Métriques et Monitoring

### **Health Checks**
- **Backend** : Endpoint `/api/health` pour vérifier l'état
- **Database** : Health check MySQL dans Docker Compose
- **Frontend** : Vérification de la disponibilité du serveur

### **Logs**
- **Centralisés** : Logs Docker Compose pour tous les services
- **Structured** : Format JSON pour faciliter l'analyse
- **Rotation** : Rotation automatique des logs

---

## 🔄 Évolutivité

### **Extensions Possibles**
- **Cache Redis** : Pour améliorer les performances
- **Load Balancer** : Pour la montée en charge
- **Message Queue** : Pour les tâches asynchrones
- **Monitoring** : Prometheus + Grafana

### **Migration Future**
- **Spring Boot 3.x** : Migration vers Java 17/21
- **Angular 17+** : Mise à jour du frontend
- **Microservices** : Séparation en services plus petits

---

## 📈 Avantages de cette Architecture

### **Pour les Développeurs**
- ✅ **Environnement reproductible** : `docker-compose up`
- ✅ **Développement local** : Pas de configuration complexe
- ✅ **Tests automatisés** : CI/CD intégré
- ✅ **Documentation** : Technologies bien documentées

### **Pour l'Équipe**
- ✅ **Collaboration facilitée** : Chaque membre peut contribuer
- ✅ **Code review** : Processus de validation automatique
- ✅ **Déploiement simplifié** : Un seul commande pour déployer
- ✅ **Maintenance** : Technologies éprouvées et stables

### **Pour le Projet**
- ✅ **Évolutivité** : Architecture modulaire
- ✅ **Performance** : Technologies optimisées
- ✅ **Sécurité** : Bonnes pratiques intégrées
- ✅ **Coût** : Technologies open-source

---

## 🎯 Conclusion

Cette architecture a été choisie pour :

1. **Faciliter la collaboration** entre les membres de l'équipe
2. **Assurer la stabilité** avec des technologies éprouvées
3. **Permettre l'évolutivité** pour de futures fonctionnalités
4. **Simplifier le déploiement** et la maintenance

Les choix techniques privilégient la **stabilité** et la **facilité d'adoption** plutôt que les dernières technologies, garantissant ainsi un projet robuste et maintenable.

---

**Document rédigé le :** 23 Septembre 2024  
**Version :** 1.0  
**Auteur :** Équipe ToDoList Collaborative
