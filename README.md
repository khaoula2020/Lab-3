\# Lab 3 - Persistance avec Spring Data JPA, Hibernate et MySQL



Application REST de gestion de produits, catégories et commandes, avec persistance des données dans MySQL.

Ce projet est la suite du Lab 2 (gestion de produits en mémoire).



\*\*Auteure :\*\* Khaoula Bahloul

\*\*Module :\*\* M10 - Développement Backend (Master IAIDDWM)



\## Technologies



\- Java 21

\- Spring Boot 3.2.0 (Spring Web, Spring Data JPA, Validation)

\- Hibernate

\- MySQL (via XAMPP) et driver `mysql-connector-j`

\- Lombok

\- Maven

\- Postman pour les tests



\## Structure du projet



```

Lab-3/

├── README.md

├── .gitignore

├── postman/

│   └── Lab3-API.postman\_collection.json

└── lab3-jpa/

&#x20;   ├── pom.xml

&#x20;   └── src/main/

&#x20;       ├── java/com/example/lab3/

&#x20;       │   ├── Lab3JpaApplication.java

&#x20;       │   ├── controller/   ProductController, CategoryController, OrderController

&#x20;       │   ├── dto/          ProductDto, CategoryDto, OrderDto, OrderItemDto

&#x20;       │   ├── entity/       Product, Category, Order, OrderItem

&#x20;       │   ├── repository/   ProductRepository, CategoryRepository, OrderRepository, OrderItemRepository

&#x20;       │   └── service/      ProductService, CategoryService, OrderService

&#x20;       └── resources/

&#x20;           ├── application.properties

&#x20;           └── db/           create\_db.sql, insert\_data.sql

```



Le projet suit une architecture en couches : \*\*controller → service → repository → base de données\*\*, avec des \*\*DTO\*\* pour les échanges JSON.



\## Lancer le projet



1\. Démarrer MySQL (module MySQL de XAMPP).

2\. Créer la base `lab3\_db` (script `lab3-jpa/src/main/resources/db/create\_db.sql`).

3\. Vérifier la connexion dans `lab3-jpa/src/main/resources/application.properties` (utilisateur `root`, mot de passe vide avec XAMPP).

4\. Lancer la classe `Lab3JpaApplication`. Hibernate crée les tables automatiquement (`ddl-auto=update`).

5\. Facultatif : exécuter `insert\_data.sql` pour charger des données de test.



L'application démarre sur `http://localhost:8080`.



\## Endpoints



| Méthode | URL | Description |

|---|---|---|

| POST | `/api/categories` | Créer une catégorie |

| GET | `/api/categories` | Lister les catégories |

| GET | `/api/categories/{id}` | Lire une catégorie |

| POST | `/api/products` | Créer un produit |

| GET | `/api/products?page=0\&size=5\&sort=name` | Lister les produits (pagination et tri) |

| GET | `/api/products/{id}` | Lire un produit |

| PUT | `/api/products/{id}` | Modifier un produit |

| DELETE | `/api/products/{id}` | Supprimer un produit |

| POST | `/api/orders` | Créer une commande avec ses lignes |

| GET | `/api/orders/{id}` | Lire une commande |



\## Tests



La collection Postman `postman/Lab3-API.postman\_collection.json` regroupe les requêtes de test : création d'une catégorie, création d'un produit, lecture et suppression.

Les données peuvent être vérifiées dans phpMyAdmin avec par exemple `SELECT \* FROM products;`.

