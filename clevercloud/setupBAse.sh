#!/bin/bash

# Arrêter le conteneur cvxml s'il est en cours d'exécution
docker stop cvxml

# Supprimer le conteneur cvxml s'il existe
docker rm cvxml

# Construire une nouvelle image Docker avec le tag cvxml à partir du Dockerfile basecv
docker build -t cvxml -f basecv .

# Exécuter un nouveau conteneur en arrière-plan avec le nom cvxml et exposer le port 1020
docker run -d --name cvxml -p 1020:3306 cvxml
