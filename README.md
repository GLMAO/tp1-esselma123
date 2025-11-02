[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/t19xNtmg)
# TP 1 : Le Design Pattern Observer

**Groupe :** IASD  
**Numéro :** 021

### (a) Récupérer le code source
Le code source fourni a été récupéré et intégré dans un projet Java via un IDE préféré (IntelliJ IDEA).

### (b) Ouvrir le code obtenu en utilisant votre IDE préféré
Le projet est constitué de trois modules : une interface définissant le service `TimerService` ainsi que deux interfaces (`TimerChangeListener` et `TimeChangeProvider`) permettant d'implémenter le mécanisme de l'observer. Une implémentation de base `DummyTimerServiceImpl` de ce service a été octroyée.

### (c) Compléter le code de la classe `Horloge` afin qu'elle affiche sur console l'heure à chaque seconde
Pour y parvenir, les modifications suivantes ont été effectuées :

1. Dans la classe amorce (`App.java`) : Instancié d'abord le `TimerService` avec `DummyTimeServiceImpl`, puis injecté l'instance dans une instance de `Horloge` après avoir modifié son constructeur.
2. Dans `Horloge` : Assuré l'inscription en tant qu'observer du `TimerService` via `addTimeChangeListener(this)`, et implémenté la méthode `propertyChange` pour afficher sur changement de secondes.
3. Note : `Horloge` ne dépend pas de l'implémentation de `TimerService` mais uniquement de l'abstraction (interface).
4. Instancié plusieurs `Horloges` et vérifié leur fonctionnement : Affichage synchronisé en console.

### (d) Ajouter dans le module timer-service-client une classe `CompteARebours`
Classe similaire à `Horloge` mais qui prend un entier en paramètre qu'elle décrémente à chaque seconde, jusqu'à 0.

1. Instancié cette classe avec le paramètre 5 et vérifié son fonctionnement : Décompte en console.
2. Ajouté une fonctionnalité à cette classe lui permettant de se désinscrire (`removeTimeChangeListener`) lorsque le compteur arrive à 0.
3. Instancié plusieurs (10) `CompteARebours` avec des valeurs aléatoires initiales comprises entre 10 et 20.
4. L'exécution précédente engendre souvent des bogues. Pourquoi ?  
   Raison : L’accès concurrent dans la classe `DummyTimeServiceImpl`. Pendant que l’observable notifie les observers de son nouvel état, un autre processus (la désinscription de la liste des observers) modifie cette même liste, causant une `ConcurrentModificationException`.

### (e) Afin de résoudre les problèmes relatifs à notre observer, nous allons déléguer son travail à une instance de la classe `PropertyChangeSupport`
NB : Fait hériter l'interface `TimerChangeListener` de `PropertyChangeListener`.
- Dans `DummyTimeServiceImpl` : Remplacé la gestion manuelle des listeners par `PropertyChangeSupport`.
- Adapté `Horloge` et `CompteARebours` pour utiliser `PropertyChangeEvent`.  
  Avez-vous résolu le problème ? Oui, plus d'exception concurrente.

### (f) Bonus : en utilisant ce service, créer une application permettant d'afficher l'heure sur une interface graphique
Créé `HorlogeGUI` avec Swing : Fenêtre affichant l'heure mise à jour en temps réel, avec design basique (possibilité d'amélioration moderne). Instancié dans `App.java`.