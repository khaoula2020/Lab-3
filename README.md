# Product API - Spring Boot

## Présentation

Ce projet consiste à développer une API REST de gestion des produits avec Spring Boot.

L'API permet de créer, consulter, modifier et supprimer des produits. Les données sont stockées temporairement en mémoire.

## Technologies utilisées

- Java
- Spring Boot
- Maven
- Spring Web
- Jakarta Bean Validation
- Postman

## Structure du projet

- controller : gestion des requêtes HTTP.
- service : logique métier.
- repository : stockage des données en mémoire.
- model : classe Product.
- dto : objets de transfert de données.
- exception : gestion des erreurs.

## Lancement du projet

1. Ouvrir le projet dans IntelliJ IDEA.
2. Vérifier que Java et Maven sont installés.
3. Lancer la classe `Lab2Application`.
4. Le serveur démarre sur le port 8080.

URL de base :

`http://localhost:8080/api/products`

## Endpoints disponibles

| Méthode | URL | Description |
|---|---|---|
| POST | /api/products | Ajouter un produit |
| GET | /api/products | Consulter tous les produits |
| GET | /api/products/{id} | Consulter un produit |
| PUT | /api/products/{id} | Modifier un produit |
| DELETE | /api/products/{id} | Supprimer un produit |
| GET | /api/products/search?name=... | Rechercher un produit |

## Tests

Les endpoints peuvent être testés avec Postman.

La collection Postman est fournie avec le projet.

## Remarque

Les données sont stockées en mémoire avec HashMap. Elles sont donc perdues lorsque l'application est arrêtée.