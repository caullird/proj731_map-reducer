📝 Map Reducer w/ Multi-thread


[![forthebadge](http://forthebadge.com/images/badges/built-with-love.svg)](http://forthebadge.com)  [![forthebadge](http://forthebadge.com/images/badges/powered-by-electricity.svg)](http://forthebadge.com)


L'objectif du projet et de permettre de passer un fichier en paramètre, et d'analyse la récurrence des mots dans le programme.
Le principe de création de map et de reducer se base sur le concept du multithreading. 

## Objectif du projet
1. Lire le fichier et permettre une récupération rapide des données
2. Analyser le texe pour donner un nombre optimal de multithreads
3. Implémenter les multithread pour générer des maps en parralèle 
4. Génrer la réception et l'attente de la récéption des threads 
5. Générer des threads pour le map reduce

## Déroulement de notre programme 

![image](https://user-images.githubusercontent.com/54810120/143560608-373ad9fe-a0e8-44c9-a0c7-33b8ce053ba3.png)

![image](https://user-images.githubusercontent.com/54810120/143560676-0431fc38-bb88-4dc7-84b3-3bf0c236e1aa.png)

## Comment installer le programme ?

```sh
git clone git@github.com:caullird/proj731_map-reducer.git
```

## Comment utiliser le programme ? 

Ajouter le texte que vous souhaitez utiliser dans le fichier :  **data/initial_data** 

Dans la classe **MapReduceFile.java** modifier : 

```java
// Modifier le nom de votre fichier
String freqFile = "yourFile.txt";

// Choisisez le nombre de thread maximum pour votre programme
int nbThreadMax = 7;
```

Démarrez votre programme, est voici le résultat ! 

##  Fait avec

* [Java](https://www.java.com/fr/)
* [Eclipse](https://www.eclipse.org/) - Java IDE

## Versions

**Latest stable release :** 1.0
**Latest release** 1.0


## Autheurs

* **CAULLIREAU Dorian** _alias_ [@caullird](https://github.com/caullird)
* **PERROLLAZ Maverick** _alias_ [@M4verickFr](https://github.com/M4verickFr)





