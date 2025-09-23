-- Database initialization script for ToDoList Collaborative Application
-- This script creates the database schema with 1-to-Many relationships

-- Create database if not exists
CREATE DATABASE IF NOT EXISTS todolist_db;
USE todolist_db;

-- Table: Utilisateur (Users)
CREATE TABLE IF NOT EXISTS utilisateur (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'MEMBRE') DEFAULT 'MEMBRE',
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_modification TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_email (email),
    INDEX idx_role (role)
);

-- Table: Projet (Projects)
CREATE TABLE IF NOT EXISTS projet (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(200) NOT NULL,
    description TEXT,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_modification TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    id_createur BIGINT NOT NULL,
    FOREIGN KEY (id_createur) REFERENCES utilisateur(id) ON DELETE CASCADE,
    INDEX idx_createur (id_createur),
    INDEX idx_nom (nom)
);

-- Table: Tache (Tasks) - Relation 1-to-Many avec Utilisateur et Projet
CREATE TABLE IF NOT EXISTS tache (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(300) NOT NULL,
    description TEXT,
    statut ENUM('A_FAIRE', 'EN_COURS', 'TERMINE') DEFAULT 'A_FAIRE',
    priorite ENUM('BASSE', 'NORMALE', 'HAUTE', 'URGENTE') DEFAULT 'NORMALE',
    date_limite DATETIME,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_modification TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    id_projet BIGINT NOT NULL,
    id_utilisateur_assigné BIGINT NOT NULL,
    FOREIGN KEY (id_projet) REFERENCES projet(id) ON DELETE CASCADE,
    FOREIGN KEY (id_utilisateur_assigné) REFERENCES utilisateur(id) ON DELETE CASCADE,
    INDEX idx_projet (id_projet),
    INDEX idx_utilisateur (id_utilisateur_assigné),
    INDEX idx_statut (statut),
    INDEX idx_priorite (priorite),
    INDEX idx_date_limite (date_limite)
);

-- Table: Projet_Membre (Project Members) - Many-to-Many relationship
CREATE TABLE IF NOT EXISTS projet_membre (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_projet BIGINT NOT NULL,
    id_utilisateur BIGINT NOT NULL,
    role_projet ENUM('CREATEUR', 'ADMIN', 'MEMBRE') DEFAULT 'MEMBRE',
    date_ajout TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_projet) REFERENCES projet(id) ON DELETE CASCADE,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id) ON DELETE CASCADE,
    UNIQUE KEY unique_projet_utilisateur (id_projet, id_utilisateur),
    INDEX idx_projet_membre (id_projet),
    INDEX idx_utilisateur_membre (id_utilisateur)
);

-- Insert sample data
INSERT INTO utilisateur (nom, email, mot_de_passe, role) VALUES
('Admin User', 'admin@todolist.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDi', 'ADMIN'),
('John Doe', 'john.doe@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDi', 'MEMBRE'),
('Jane Smith', 'jane.smith@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDi', 'MEMBRE'),
('Bob Wilson', 'bob.wilson@example.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDi', 'MEMBRE');

INSERT INTO projet (nom, description, id_createur) VALUES
('Projet Web Application', 'Développement d\'une application web collaborative', 1),
('Projet Mobile App', 'Création d\'une application mobile', 2),
('Projet Documentation', 'Rédaction de la documentation technique', 3);

INSERT INTO projet_membre (id_projet, id_utilisateur, role_projet) VALUES
(1, 1, 'CREATEUR'),
(1, 2, 'ADMIN'),
(1, 3, 'MEMBRE'),
(2, 2, 'CREATEUR'),
(2, 4, 'MEMBRE'),
(3, 3, 'CREATEUR'),
(3, 1, 'ADMIN');

INSERT INTO tache (titre, description, statut, priorite, date_limite, id_projet, id_utilisateur_assigné) VALUES
('Setup Backend', 'Configuration du projet Spring Boot', 'TERMINE', 'HAUTE', '2024-01-15 18:00:00', 1, 1),
('Setup Frontend', 'Configuration du projet Angular', 'EN_COURS', 'HAUTE', '2024-01-20 18:00:00', 1, 2),
('Database Design', 'Conception du schéma de base de données', 'TERMINE', 'NORMALE', '2024-01-10 18:00:00', 1, 3),
('API Documentation', 'Documentation des endpoints REST', 'A_FAIRE', 'NORMALE', '2024-01-25 18:00:00', 1, 1),
('UI Design', 'Conception de l\'interface utilisateur', 'A_FAIRE', 'HAUTE', '2024-01-22 18:00:00', 2, 2),
('Mobile Testing', 'Tests sur différents appareils mobiles', 'A_FAIRE', 'NORMALE', '2024-02-01 18:00:00', 2, 4),
('Technical Writing', 'Rédaction des guides techniques', 'EN_COURS', 'NORMALE', '2024-01-30 18:00:00', 3, 3),
('Review Process', 'Processus de révision des documents', 'A_FAIRE', 'BASSE', '2024-02-05 18:00:00', 3, 1);
