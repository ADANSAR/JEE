# CAR - JEE
## 01/05/2017
### Travail r�alis� par: 
- ADANSAR MOHAMED


## Introduction :

    L'objectif de ce TP est de r�aliser une application Web de gestion des commandes des livres en ligne avec la technologie JEE.

## Structure

    L'impl�mentation est s�par�e en 2 parties:
    
        - car.tp4.entity : contenant les fichiers Bean (EJB) utilis�s pour l'application web.
        - car.tp4.servlet : contenant les servlets utilis�s pour l'application web.
        - src.main.webapp.jsp : contenant les JSP utilis�s pour l'application web.
        - src.main.webapp : contenant l'index.jsp qui est la page d'acceuil de notre site web.

## Book & Panier EJB:

	Ce projet contient les deux objets fondamentaux dans la gestion du site de commande :
        - Book : livre repr�sent� par un id unique autoIncremet, le nom de l'auteur, le titre du livre, la date de parution du livre et sa quantit�.
        - Panier : pani� valid� ou commande repr�sent�e par un id unique autoIncremet, l'identifiant du client auquel appartient le panier et un HashMap avec l'identifiant du livre comme cl� et sa quantit� comme valeur.
    Ces classes proposent les getters et setters n�cessaires � leur utilisation dans le syst�me.

    Pour manipuler les Book et Panier en SGBD, on a cr�er des Bean Entity EJB Statless :
        - BookBean : g�rant les instances de Book en base de donn�es
        - PanierBean : g�rant les instances de Panier en base de donn�es

## Book & Panier Servlet :

	Pour r�aliser le projet, on a cr�er des servlets qui se trouvent dans le package car.tp4.servlet qui r�pondent aux requ�tes envoy� par le navigateur.

	Les diff�rentes servlets d�velopp�es pour ce projet sont les suivantes:

        - AddPanier : Servlet utilis� pour ajouter un livre au panier electronique.
        - AfficherCommandes : Servlet utilis� pour r�cup�rer les commande valid�es par le client.
        - AfficherPanier : Servlet utilis� pour r�cup�rer le panier du client en cours.
        - AuthorsServlet : Servlet utilis� pour r�cup�rer tous les auteurs existants dans la base de donn�es.
        - BookServlet : Servlet utilis� pour faire l'enregistrement d'un livre dans la base de donn�es et r�cup�rer les livres existants dans la base de donn�es au m�me temps.
        - ChercheLivre : Servlet utilis� pour r�cup�rer un livre recherch� par le client de la base de donn�es.
        - ChercheLivreParAuteur : Servlet utilis� pour r�cup�rer tous les livres d'un auteur de la base de donn�es.
        - InitServlet : Servlet utilis� pour ajouter 5 livres � la base de donn�es.
        - RetirerPanier : Servlet utilis� pour enlever un livre du panier electronique.
        - SortBooks : Servlet utilis� pour trier les livres par leurs ann�e de parution .
        - ValiderPanier : Servlet utilis� pour valider le panier et passer la commande.

## Book & Panier Servlet :

	Pour afficher les r�sultats et les retours de la partie serveur, on a utilis� des pages JSP qui se trouvent dans le r�p�rtoire webapp, et bien pr�cisement dans le dossier jsp.

	Les diff�rentes page Jsp utilis�es dans notre projet sont les suivantes:

        - index.jsp : Page utilis� pour afficher un formulaire de saisie de livre.

        - jsp/addbook.jsp : Page utilis� pour afficher le r�capitulatif du livre saisi par l'utilisateur.

        - jsp/authors.jsp : Page utilis� pour afficher les auteurs envoy�s par la servlet.

        - jsp/book.jsp : Page utilis� pour afficher les livres envoy�s par la servlet, et qui permet de les ajouter au panier.

        - jsp/commandes.jsp : Page utilis� pour afficher les commandes envoy�es par la servlet.

        - jsp/panier.jsp : Page utilis� pour afficher le panier, ou plut�t les livres existants au panier.


## Fonctionnalit�s :

	--> Enregistrement des livres en ligne.

	--> Affichage des livres disponibles et leurs d�tails.

	--> Affichage de tous les auteurs.

	--> Initialisation de la base de donn�es avec 5 livres pr�d�finis.

	--> Ajout d'un ou plusieurs livres au panier �lectronique.

	--> Enl�vement d'un ou plusieurs livres au panier �lectronique.

	--> Visualisation du panier.

	--> Validation du panier �lectronique sous la forme d'une commande.

	--> Gestion des stocks de livres.

	--> Recherche d'un livre avec une partie de son titre, ou m�me avec un mot avec des accents ressemblant � un morceau du titre du livre.

	--> Affichage de tous les livres d'un auteur.

	--> Trie des livres par ann�e de parution.

	--> Affichages des anciennes commandes pass� par le client.
	
## Conclusion :

	Dans ce projet on pris les differentes possibilit� technologies qui qont offerts par JEE.
	
	Ainsi se projet pr�sent tout les possibilit� propos� pour faire le developpement d'une application JEE.
