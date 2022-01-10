# CAR - JEE
## 01/05/2017
### Travail réalisé par: 
- ADANSAR MOHAMED


## Introduction :

    L'objectif de ce TP est de réaliser une application web de gestion des commandes des livres en ligne avec la technologie JEE.

## Structure

    L'implémentation est séparée en 2 parties:
    
        - car.tp4.entity : contenant les fichiers Bean (EJB) utilisés pour l'application web.
        - car.tp4.servlet : contenant les servlets utilisés pour l'application web.
        - src.main.webapp.jsp : contenant les JSP utilisés pour l'application web.
        - src.main.webapp : contenant l'index.jsp qui est la page d'acceuil de notre site web.

## Book & Panier EJB:

	Ce projet contient les deux objets fondamentaux dans la gestion du site de commande :
        - Book : livre représenté par un id unique autoIncremet, le nom de l'auteur, le titre du livre, la date de parution du livre et sa quantité.
        - Panier : panié validé ou commande représentée par un id unique autoIncremet, l'identifiant du client auquel appartient le panier et un HashMap avec l'identifiant du livre comme clé et sa quantité comme valeur.
    Ces classes proposent les getters et setters nécessaires à leur utilisation dans le système.

    Pour manipuler les Book et Panier en SGBD, on a créer des Bean Entity EJB Statless :
        - BookBean : gérant les instances de Book en base de données
        - PanierBean : gérant les instances de Panier en base de données

## Book & Panier Servlet :

	Pour réaliser le projet, on a créer des servlets qui se trouvent dans le package car.tp4.servlet qui répondent aux requêtes envoyé par le navigateur.

	Les différentes servlets développées pour ce projet sont les suivantes:

        - AddPanier : Servlet utilisé pour ajouter un livre au panier electronique.
        - AfficherCommandes : Servlet utilisé pour récupérer les commande validées par le client.
        - AfficherPanier : Servlet utilisé pour récupérer le panier du client en cours.
        - AuthorsServlet : Servlet utilisé pour récupérer tous les auteurs existants dans la base de données.
        - BookServlet : Servlet utilisé pour faire l'enregistrement d'un livre dans la base de données et récupérer les livres existants dans la base de données au même temps.
        - ChercheLivre : Servlet utilisé pour récupérer un livre recherché par le client de la base de données.
        - ChercheLivreParAuteur : Servlet utilisé pour récupérer tous les livres d'un auteur de la base de données.
        - InitServlet : Servlet utilisé pour ajouter 5 livres à la base de données.
        - RetirerPanier : Servlet utilisé pour enlever un livre du panier electronique.
        - SortBooks : Servlet utilisé pour trier les livres par leurs année de parution .
        - ValiderPanier : Servlet utilisé pour valider le panier et passer la commande.

## Book & Panier Servlet :

	Pour afficher les résultats et les retours de la partie serveur, on a utilisé des pages JSP qui se trouvent dans le répértoire webapp, et bien précisement dans le dossier jsp.

	Les différentes page Jsp utilisées dans notre projet sont les suivantes:

        - index.jsp : Page utilisé pour afficher un formulaire de saisie de livre.

        - jsp/addbook.jsp : Page utilisé pour afficher le récapitulatif du livre saisi par l'utilisateur.

        - jsp/authors.jsp : Page utilisé pour afficher les auteurs envoyés par la servlet.

        - jsp/book.jsp : Page utilisé pour afficher les livres envoyés par la servlet, et qui permet de les ajouter au panier.

        - jsp/commandes.jsp : Page utilisé pour afficher les commandes envoyées par la servlet.

        - jsp/panier.jsp : Page utilisé pour afficher le panier, ou plutôt les livres existants au panier.


## Fonctionnalités :

	--> Enregistrement des livres en ligne.

	--> Affichage des livres disponibles et leurs détails.

	--> Affichage de tous les auteurs.

	--> Initialisation de la base de données avec 5 livres prédéfinis.

	--> Ajout d'un ou plusieurs livres au panier électronique.

	--> Enlèvement d'un ou plusieurs livres du panier électronique.

	--> Visualisation du panier.

	--> Validation du panier électronique sous la forme d'une commande.

	--> Gestion des stocks des livres.

	--> Recherche d'un livre avec une partie de son titre, ou avec un mot avec des accents ressemblant à une partie du titre du livre.

	--> Affichage des livres appartenant à un auteur.

	--> Trie des livres par année de parution.

	--> Affichage des anciennes commandes passées par le client.
