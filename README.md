# Gestionnaire de clients
[![Java Version](https://img.shields.io/badge/Java-22.0.1+-blue.svg)](https://www.oracle.com/java/technologies/downloads/)
[![Maven Version](https://img.shields.io/badge/Maven-3.9.6+-red.svg)](https://maven.apache.org/download.cgi)
[![JUnit Version](https://img.shields.io/badge/JUnit-5.10+-green.svg)](https://junit.org/junit5/docs/current/user-guide/)

Application console de gestion de clients simple en Java.

---

## Architecture et choix techniques

* **Modélisation de données (Java `record`)** : La classe `Client` est implémentée en tant que `record` Java, une approche moderne pour créer des objets de données immuables, concis et sécurisés.
* **Design Pattern Factory** : Un **Factory** est utilisé pour centraliser la logique de création des objets `Client`. Cela permet de garantir que chaque `Client` est créé avec un ID unique et que les données d'entrée sont validées, ce qui rend le code plus robuste et facile à maintenir.
* **Tests unitaires (JUnit 5)** : Le projet inclut une couverture de tests exhaustive pour valider la logique de la `ClientFactory` (y compris les cas d'exceptions) et les fonctionnalités de base du `record Client` (`equals()`, `hashCode()`, etc.).
* **Gestion de dépendances (Maven)** : **Maven** est utilisé pour standardiser la structure du projet, automatiser le processus de build et gérer les dépendances de manière efficace.

---


## Lancer le projet
1. Assurez-vous d'avoir Java 22 et Maven installés.
2. Clonez ce dépôt.
3. Exécutez le projet en utilisant votre IDE ou via la ligne de commande avec la commande Maven appropriée (par exemple, `mvn test` pour exécuter les tests).
