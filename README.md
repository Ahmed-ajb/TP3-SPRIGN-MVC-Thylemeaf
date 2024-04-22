

# TP3-SpringMVC-SpringDataJPA-Thymeleaf

Projet réalisé par Ajebli Ahmed


## Description

Ce projet démontre la mise en œuvre d'une application web Spring MVC utilisant Spring Data JPA et Thymeleaf comme moteur de templating.

## Technologies Utilisées

- Spring MVC
- Spring Data JPA
- Thymeleaf

## Démarrage

### Installation

1. Clonez le dépôt : `(https://github.com/Ahmed-ajb/TP3-SPRIGN-MVC-Thylemeaf.git)`
2. Importez le projet dans votre IDE :
   - IntelliJ IDEA : Ouvrez IntelliJ IDEA, sélectionnez "Importer un projet", et choisissez le fichier pom.xml du dépôt cloné.
   - Eclipse : Ouvrez Eclipse, allez à Fichier -> Importer -> Maven -> Projets Maven Existants, et sélectionnez le répertoire racine du dépôt cloné.
   
### Configuration de la Base de Données

- Mettez à jour le fichier `application.properties` avec vos identifiants de base de données (URL, nom d'utilisateur, mot de passe) et dialecte (par exemple, `spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect`).

### Exécution de l'Application

- Serveur Intégré : Cliquez avec le bouton droit sur la classe principale de l'application et sélectionnez "Exécuter", ou utilisez les configurations d'exécution intégrées de votre IDE.
- Serveur Externe : Générez un fichier WAR en utilisant Maven (`mvn clean package`) et déployez-le sur un serveur web tel que Tomcat ou Jetty.



## Captures d'écran
Affichage Admin : 
![image](https://github.com/Ahmed-ajb/TP3-SPRIGN-MVC-Thylemeaf/assets/78688533/c61135ac-08e5-4442-a336-b2731ee2a926)

l'ajout des patients : 
![image](https://github.com/Ahmed-ajb/TP3-SPRIGN-MVC-Thylemeaf/assets/78688533/0feb9b9c-bd04-4fd4-af79-4610029a21fa)

Affichage USER : 
![image](https://github.com/Ahmed-ajb/TP3-SPRIGN-MVC-Thylemeaf/assets/78688533/f7ca65ae-1e94-496b-9afb-d257de900fc8)

Pagination : 
![image](https://github.com/Ahmed-ajb/TP3-SPRIGN-MVC-Thylemeaf/assets/78688533/9fdcdfac-bf33-4760-92cc-ea1bc1ba3304)


Securité: 
![image](https://github.com/Ahmed-ajb/TP3-SPRIGN-MVC-Thylemeaf/assets/78688533/f599925c-73f3-4d1d-9e88-431869cff36b)



