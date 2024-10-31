# Barème de correction

## Glossaire

### Termes importants

- Application MaVille: Non
- Code de la ville: Non
- Info Entraves et Travaux: Non
- Planification participative: Oui. Votre description est partiellement correcte, les résidents peuvent fournir des plages horaires où ils préfèreraient avoir des travaux dans leur quartier, veuillez ajouter plus de détails pour ce terme.
- Type de travaux, Travaux: Non
- Type de problème, Signaler un problème: Non
  - Il vous manque plusieurs termes importants pour le projet.

## Diagramme de cas d'utilisation

### Identification des acteurs

- Intervenant : Vous avez peut-être raison concernant l'intervenant, mais dans le contexte de ce projet, l'intervenant est un acteur qui travaille pour la ville et devrait être considéré comme un acteur principal. Référez-vous à la correction du prof pour corriger vos erreurs.
- La présence de deux Utilisateurs dans votre diagramme est incorrecte. Il faudrait noter que tous les utilisateurs du système peuvent se connecter et modifier leur compte (et d'autres actions en commun). Une seule classe pour l’utilisateur est donc suffisante; le reste dépendra de la manière dont vous organisez votre code.

### Cas d'utilisation
    - Quelle est exactement la relation entre Afficher les notification et Envoyer une notification? Relation "extend" ou "include" ou "Autre"?
    - Il faudrait avoir une relation entre S'incription comme intervenant avec la Ville. Vous pouvez consulter cette idée dans la correction du prof.

- Il y a des CU que vous avez omis:
  - Réponse à une candidature
  - Recherche un travail
  - Filtrer des travaux
  - S'abonner à un projet
  - Modifier ses préférences: pour recevoir des notifications personnalisées

## Scenarios
- Il est à noter que, une fois que vous ajoutez une précondition l'utilisateur doit se connecter à l'application, vous n'aurez plus besoin de répéter cette étape dans le scénario principal.
  - La notation est incorrecte pour le scénario principal dans le cas "Accepter une requête de travail"
  - Plusieurs scénarios ne respectent pas d'alternance entre acteur et système (max 2 étapes successives de la meme source)
  -  Certaines scénarios étaient trop courts(moins de 5-10 étapes)
  - Rechercher les travaux: Je trouve ce CU dans votre scénario, mais vous avez oublié dans votre diagramme CU
  - Montrer une carte des chantiers de travaux: Vous avez omis ce CU
  - Consulter les travaux envoyés: Vous avez omis ce CU
  - Modifier son profil: Vous avez omis ce CU
  - Afficher les notifications: Vous avez omis ce CU
  - Signaler un problème: il vous manque le scénario pour le cas include dans votre diagramme
  - S'inscrire comme résident: Manque la précondition que l'utilisateur devrait avoir au moins 16 ans
  - Soumettre un nouveau projet: Scénario pour le cas include dans votre diagramme ?
  - Commentez sur les projets:  Scénario pour le cas include dans votre diagramme ?
  - Envoyer une notification: Vous avez omis ce CU
  - Approuver et répondre aux requêtes de travail: Scénario pour le cas include dans votre diagramme ?
  - MAJ l'état des travaux: Scénario pour le cas include dans votre diagramme ?
  - S'inscrire comme intervenant: Vous avez oublié de mentionner le code fourni par la ville

  - Il faudrait de noter que vous devez écrire un scénario pour les cas d'utilisation "extend" et "include," même si vous les avez déjà mentionnés dans le scénario principal d'un autre CU
  - Je constate que dans vos scénarios, vous avez bien travaillé, en particulier pour la distinction entre les acteurs secondaires et principaux, ce qui compense en grande partie les éléments omis dans votre diagramme.

## Diagramme d'activités

  - Je comprends votre idée, mais effectuer deux fois la validation serait quelque peu redondant, un seul nœud de décision pour vérifier la conformité des données est suffisant. Veuillez porter les modifications pour le dm2.
  - Ce serait mieux d'aller un peu plus loin, pensez à l'utilisation des noeuds d'objets.

  CU manquants:
  - Modifier son profil
  - Envoyer une notification
  - Afficher les notifications

## Analyse
- Excellent analyse!

### Risques

  - Vraiment excellent vos riques

### Besoins non fonctionnels
  - Très bien!

### Besoins matériels, solution de stockage et solution d'intégration

- Matériels nécessaires

  - Considération pour le déploiement du programme : Vous avez manqué ce critère. Comment l'application sera-t-elle déployée ? Par exemple, sera-t-elle distribuée via des installateurs, via un accès à un site web, ou via des stores? Automatiser les déploiements et les mises à jour ? Y aura-t-il des mises à jour automatiques ?
  - Matériel et interface utilisateur : Oui, mais j'aimerais avoir un peu plus d'information sur l'interface utilisateur de votre application.

- Solutions de stockage
  - Architecture de stockage (partagée, distribuée, etc.) : Vous devriez préciser si votre solution de stockage sera centralisée (un seul serveur), partagée ou distribuée (répartition des données sur plusieurs serveurs).
  - Sécurité des données ou autre considérations : Oui, ce serait mieux si vous rementionnez explicitement la sécurité des données

## Prototype
- Avec .jar file

## Git

- Très bien

## Rapport
- Votre description du projet était un peu courte. Cela devrait contenir le contexte, problèmes à résoudre, et des propositions.

## Bonus

- 5 CUs implémentés (3 points) : Vous avez implémenté: Rechercher les travaux selon quartier, Signaler un problème à la ville, Soumettre une requête de travail, Soumettre un nouveau projet de travaux, Mettre à jour les informations d'un chantier (encore bugs mais ok)
