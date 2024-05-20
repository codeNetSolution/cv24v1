CREATE DATABASE IF NOT EXISTS cv_base;
USE cv_base;

-- Table pour les CVs généraux
CREATE TABLE IF NOT EXISTS cvs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    genre VARCHAR(10),
    prenom VARCHAR(50),
    nom VARCHAR(50),
    telephone VARCHAR(15),
    email VARCHAR(255),
    cv_data LONGTEXT NOT NULL DEFAULT '', -- Ajout d'une valeur par défaut
    UNIQUE KEY unique_person (genre, nom, prenom, telephone)
);

-- Table pour les objectifs
CREATE TABLE IF NOT EXISTS objectifs (
    cv_id INT,
    intitule VARCHAR(255),
    type_contrat VARCHAR(100),
    FOREIGN KEY (cv_id) REFERENCES cvs(id)
);

-- Table pour les expériences professionnelles
CREATE TABLE IF NOT EXISTS experiences (
    cv_id INT,
    detail TEXT,
    datedeb DATE,
    datefin DATE,
    titre VARCHAR(255),
    FOREIGN KEY (cv_id) REFERENCES cvs(id)
);

-- Table pour les compétences
CREATE TABLE IF NOT EXISTS competences (
    id INT AUTO_INCREMENT PRIMARY KEY,
    competences_list_id INT,
    datedeb DATE,
    datefin DATE,
    cv_id INT,
    titre VARCHAR(255),
    FOREIGN KEY (cv_id) REFERENCES cvs(id)
);

-- Table pour les diplômes
CREATE TABLE IF NOT EXISTS diplomes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    intitule VARCHAR(255),
    niveau INT,
    date DATE,
    institut VARCHAR(255),
    cv_id INT,
    FOREIGN KEY (cv_id) REFERENCES cvs(id)
);

-- Table pour les certifications
CREATE TABLE IF NOT EXISTS certifications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    certifs_id INT,
    datedeb DATE,
    datefin DATE,
    cv_id INT,
    titre VARCHAR(255),
    FOREIGN KEY (cv_id) REFERENCES cvs(id)
);

-- Table pour les langues
CREATE TABLE IF NOT EXISTS langues (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cv_id INT,
    langue VARCHAR(50),
    certification VARCHAR(50),
    score_toeic INT,
    niveau_cles VARCHAR(10),
    nivs INT DEFAULT 0, -- Ajout d'une valeur par défaut
    FOREIGN KEY (cv_id) REFERENCES cvs(id)
);

-- Table pour professions
CREATE TABLE IF NOT EXISTS professions (
    cv_id INT AUTO_INCREMENT PRIMARY KEY,
    titre TEXT,
    detail TEXT,
    datedeb TEXT,
    datefin TEXT,
    FOREIGN KEY (cv_id) REFERENCES cvs(id)
);

-- Table pour autres informations
CREATE TABLE IF NOT EXISTS divers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cv_id INT,
    contenu TEXT,
    comment TEXT,
    autre_id INT,
    FOREIGN KEY (cv_id) REFERENCES cvs(id)
);

-- Table pour autre informations
CREATE TABLE IF NOT EXISTS autre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    divers_id INT,
    FOREIGN KEY (divers_id) REFERENCES divers(id)
);

-- Ajouter la clé étrangère pour divers_id après avoir créé les tables
ALTER TABLE divers
ADD CONSTRAINT fk_autre_id FOREIGN KEY (autre_id) REFERENCES autre(id);
