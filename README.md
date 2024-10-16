# Développement d'une API Rest

Compétences abordées :
- développement de "endpoint" pour en utilisant Spring
- gestion des erreurs
- gestion des code http de retour

## Démarrer le projet

Le plugin `spring-boot-maven-plugin` ajouté au fichier `pom.xml` permet de bénéficier du "goal" `run`.

Extrait de fichier de configuration `pom.xml` intégrant le plugin en question :
```xml
<plugin>
<groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

Ce "goal" est très pratique puisqu'il vous permet de démarrer un serveur Tomcat et de déployer l'application en cours de développement automatiquement.

En ligne de commande vous pourrez démarrer le serveur avec l'instruction suivante :
```bash
mvn spring-boot:run
```

A partir de votre IDE il vous suffira de cliquer sur "run" à partir des ordres maven.
    
## Test de l'API

Afin de tester votre API vous pourrez utiliser client http tel que :
- [Insomnia](https://insomnia.rest/)
- [Postman](https://www.postman.com/)
- [curl](https://curl.se/)

## Marche à suivre

Vous allez compléter le projet en suivant une démarche TDD :
1. Complétez les TODO de façon à répondre aux attentes
2. Testez dès que vous le pouvez (lancez les tests unitaires et faites des tests fonctionnels)

N'oubliez pas de poussez régulièrement votre travail !

