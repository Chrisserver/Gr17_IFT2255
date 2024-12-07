# Feedback
 - Le contenu de votre rapport dépasse la taille de l'écran, ce qui entraîne un affichage incomplet 
 -  ATTENTION: Mauvaise version remise! Je corrige votre devoir comme suivant:
  - La partie analyse est incluse dans la version remise.
  - Les diagrammes de classes et de séquences se trouvent sur la page du livrable.
  - Veuillez y prêter attention la prochaine fois, car je risque d’omettre certaines parties de votre travail et je ne peux pas garantir de les rechercher comme je l’ai fait cette fois-ci.

## Architecture 

- Les utilisateurs sont bien identifiés : Oui
 - Ce serait préférable de séparer les deux type d'utilisateur
- Linteraction entre utilisateur et système est bien identifié : 
  - Non , pas clair. Il manque un descriptif sur la relation avec Application MaVille
- La frontière du système est claire et permet de distinguer les composantes du système des dépendances externes : Non
- La composantes principales sont bien identifiés :
  - Manque de détails dans la description du REST API (principales routes, type de traitement...)
- Les relations entre composantes sont bien identifiées. 
 - Il faut être plus explicite et descriptif sur les relations (appels et reponses)
- Les services externes sont bien identifiés : Pas clair
- Les relations entre services externes et système sont bien identifiés : Partiellement

- Veuillez consulter la correction du professeur (demo 8) pour apporter des modifications à votre architecture.

-   Architecture décrit partiellement textuelle: Il y a trop de textes, privilégiez davantage les diagrammes pour décrire votre système.

## Diagramme de classe 

### Identification des entités 

- Classes
  - Pas de point d'entrée dans l'application. C.a.d une classe qui contient le méthode main().
  - Il y a trop de classes ou d’ensembles de classes "orphelins", c’est-à-dire des classes qui sont isolées et ne sont pas connectées aux autres classes.
- Attributs (pertinence et type)
- Méthodes (pertinence et signature)

### Identification des relations 

- Type de relation (ex: pertinence de la composition plutôt qu'une simple association)
  - Certaines relations auraient besoin une agrrégation plutôt qu'une simple association
  - Certaintes relations manquantes par exemple Messagerie et RequeteTravail(agrégations)
- Relation inappropriée ou absente
  - Mauvais sens pour les généralisations

- Multiplicité non identifiée pour le diagramme
- Vous devez consulter la correction du prof pour corriger les relations dans votre diagramme


### Cohésion et couplage 
 - Forte cohésion
 - Maville et Menu interagissent avec de nombreuses autres classes. L'utilisation d'interfaces pourrait contribuer à réduire ce couplage.

### Formalisme 

- Type des attributs absent: Non
- Signature des méthodes absente: Non
- Relation illégale
 - Je remarque que vous avez séparé votre application en trois parties (M-V-C) et les avez liées par une relation, ce qui n’a pas de sens.
 - Vous devez faire directement la relation entre de classe, référez-vous à la correction du prof(démo 8) pour avoir plus de détails.
- Nommage portant à confusion ou éloigné des concepts de l'énoncé: Non

## Diagramme de séquence 

- Il serait préférable de revoir l'ordre des classes disposées de gauche à droite, car il est difficile de suivre le flux.
- Il faudrait refaire ces diagrammes, vous pouvez consulter la correction du prof pour avoir une idée.

### Formalisme et cohérence 

-  Bonne définition des objets et lignes de vie: Oui
-  Bon usage des flèches de message: Non, les messages de retour n’ont parfois pas de flèches en pointillés.
-  Bon usage des fragments: Oui, partiellement
-  Méthode appelée existe : Non, certaines classes utilisées n’existent pas, par exemple BD Requetes, ce qui implique que les méthodes associées n’existent pas non plus.
-  Méthode appelée présente la même signature (params + type de retour) : Non

### Consulter les entraves 

-  Flux général est cohérent et représentatif du CU: 
  - L'ordre des méthodes n'est pas clair et cause des confusions : les numérotations 1.1, 1.2, puis 1.3 ne suivent pas une logique cohérente.
-  Récupération des entraves
-  Filtre des entraves (optionnel): Oui, partiellement. Je ne comprends pas pourquoi vous avez séparé cette partie dans un autre diagramme.


### Soumettre une requête de travail 

-  Flux général est cohérent et représentatif du CU: Partiellement
-  Entrée de données: Oui
-  Validation et traitement erreur: Partiellement
-  Suivi d'une requête de travail: Non
- Plusieurs message de retour manquants

### Consulter la liste des requêtes de travail 

-  Flux général est cohérent et représentatif du CU: Partiellement
-  Voir la liste des requêtes de travail: Oui, partiellement
-  Accès à une requête de travail: Oui, mais c'est assez flou
-  Soumettre sa candidature: Non

- Que représente la méthode FindPWork() ?

## Discussion design 

-  considérations prises dans le design (abstraction, couplage et cohésion, encapsulation) pour favoriser l'évolution 
 - Vous avez abordé la cohésion et le couplage, mais de manière trop générale. Il serait nécessaire d’ajouter davantage de détails, en précisant les classes ou modules concernés, par exemple.
 - Il serait également pertinent de discuter de vos propres choix plutôt que de simplement fournir des définitions. Par exemple, quelles méthodes ou classes illustrent clairement l'encapsulation/l'abstraction dans votre design ? Pourquoi avez-vous choisi cette approche plutôt que d'autres options ?
-  lien avec l'architecture ou style d'architecture (ex: MVC) et avantages de celles-ci : Vous avez appliqué MVC mais vous avez oublié de parler de cette architecture.
-  intégration de l'application (modularité, flexibilité, interopérabilité): Pas clair
  