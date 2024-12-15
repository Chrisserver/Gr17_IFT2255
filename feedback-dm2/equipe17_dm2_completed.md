# Feedback

 - ATTENTION: Mauvaise version remise! Je corrige votre devoir comme suivant:
  - La partie analyse est incluse dans la version remise.
  - Les diagrammes de classes et de séquences se trouvent sur la page du livrable.
  - Veuillez y prêter attention la prochaine fois, car je risque d’omettre certaines parties de votre travail et je ne peux pas garantir de les rechercher comme je l’ai fait cette fois-ci.

## Révision 

- Échéancier mis à jour : Oui

- Diagrammes CU mis à jour 
  - Nouvel acteur: API de la ville : Non
  - Nouveau CU 
    - Consulter ou Chercher les entraves routières : Non
  - CU abandonné:  
    - Signaler un problème : Non, vous n'avez pas enlevé ce CU
    - Partager son avis sur les travaux : Non, "Commenter sur les projets" n'a pas été enlevé
  - Corrections : Très bien
    Petit note: Désolée, je viens de remarquer que c'était une erreur de ma part concernant la correction du dm1. Ce n'est pas "Réponse à une candidature", mais bien "Répondre à une candidature". 

- Diagrammes d'activités mis à jour 
  - Envoyer/Afficher notifications: Il serait préférable de séparer ces deux actions en deux diagrammes distincts, car il s'agit de deux flux complètement différents. Cela rendrait le tout plus logique et cohérent. Je vous accorde la note complète cette fois-ci pour cette partie, mais il serait préférable d'apporter la modification pour le prochain devoir, svp.

- Analyse mis à jour 
  - Non, pas de modification à faire

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

-  (-1) Architecture décrit partiellement textuelle: Il y a trop de textes, privilégiez davantage les diagrammes pour décrire votre système.

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
  
# Implémentation 

## Fonctionnalités 

- [ ] Se connecter comme résident et intervenant  : Oui

- [ ] Consulter les travaux en cours ou à venir   : Très bien
- [ ] Consulter les entraves                      : Très bien

- [ ] Soumettre une requête de travail            
  - [ ] Formulaire complet                        : Oui
  - [ ] Validation des données                    : Partiellement
  - [ ] Message d'erreur                          : Oui, mais ce n'est pas très clair quelle erreur l'utilisateur a commise.
      Soumettre une requête de travail:
      Titre: my work
      Description: my work
      Quel Type de travaux?
      Travaux routiers
      Date debut (YYYY-MM-DD):
      2024-11-29
      Erreur lors de la soumission de la requête.

- [ ] Consulter la liste des requêtes de travail  : Requete prédéfini oui, mais pas sur pour les nouvelles requete
  - Il manque une requête prédéfinie.

## Robustesse & Utilisabilité 
  - Très bien

- [ ] Application ne *crash* pas lors de mauvaises entrées : Non
- [ ] Navigation et interaction intuitive 
- [ ] Possibilité de revenir en arrière : Oui
- [ ] Informations présentées facile à lire :Oui

## Code 

- [ ] Code n'est pas complètement différent de la conception : Oui
- [X] Code est réparti à travers plusieurs classes et facile à maintenir 
  - Vos classes sont toutes regroupées dans un seul package, ce qui rend le projet difficile à maintenir. Elles ne sont pas organisées par responsabilité ou domaine fonctionnel, ce qui nuit à la lisibilité, à l'organisation globale et ne respecte pas pleinement les principes de la OOP.
- [ ] Code est facile à lire et comprendre 

## Tests unitiaire  
- 3 membres, 9 tests

Pour chaque test:

- Test unitaire 
  - [X ] Test passe : Non, test ne fonctionne pas
  - [ ] Test pertinent pour la fonction 
  - [X] Test distinct 
    - Vous avez effectué plusieurs tests distincts, mais ils portent tous sur une seule et même fonction.
  - [ ] Test bien nommé et structuré 
  - [ ] Assertion pertinente 

## Rapport et Git 

- Structure du rapport:
   - Le contenu de votre rapport dépasse la taille de l'écran, ce qui entraîne un affichage incomplet
- Échéancier clair (distribution des tâches) et mis à jour
- images s'affichant directement dans le rapport
  - Non
- Lien Git et VPP fonctionnel: Oui
  - Vous n'avez pas inclus de VPP cette fois-ci, mais cela me convient pour cette fois. Veuillez ne pas l'oublier pour le prochain devoir.
- Release créé pour le devoir 2: Oui

## Bonus 1: Exploitation de Git 

- Commits réguliers et descriptifs de chaque membre. : Non
- Gestion de projet par les tickets. : Oui
- Usage d'une branche pour le développement du code source. : Oui

## Bonus 2: Architecture REST 
Non