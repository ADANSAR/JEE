package car.tp4.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.*;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class PanierBean
 */
@Stateless
@Local
public class PanierBean {

	@PersistenceContext(unitName = "panier-pu")
	private EntityManager entityManager;

	@EJB
	private BookBean bookBean;

	String idClient;
	List<Book> books = new ArrayList<Book>();


	/**
	 * @param idClient l'identifiant du client
	 * @param book le livre à ajouter
	 *
	 * ajouter un livre au panier éléctronique
	 *
	 */
	public void addBook(String idClient, Book book) {
		if(!idClient.equals(idClient)) {
			this.idClient = idClient;
			book.setQte(1);
			books.add(book);
		}
		else {
			boolean found = false;
			for (Book bk : books) {
				if (bk.equals(book)){
					bk.setQte(1 + bk.getQte());
					found = true;
				}
			}
			if(found!=true) {
				this.idClient = idClient;
				book.setQte(1);
				books.add(book);
			}
		}
	}


	/**
	 * @param idClient l'identifiant du client
	 * @param book le livre à retirer
	 *
	 * enlever un livre du panier éléctronique
	 *
	 */
	public void removeBook(String idClient, Book book) {
		int index=-1;
		if(this.idClient.equals(idClient)) {
			for(Book bk: books)
				if(bk.getId()==book.getId())
					index=books.indexOf(bk);
		}
		if(index!=-1) {
			int qte=books.get(index).getQte();
			if(qte>1)
				books.get(index).setQte(qte-1);
			else
				books.remove(index);
		}
	}


	/**
	 * @param idClient l'identifiant du client
	 *
	 * @return liste des livres ajoutés au panier par le client
	 */
	public List<Book> getSelectedBooks(String idClient) {
		if (idClient.equals(this.idClient))
			return this.books;
		return null;
	}


	/**
	 * @param idClient l'identifiant du client
	 *
	 * Valider une commande et l'ajouter à la base de données
	 */
	public void addPanier(String idClient) {
		if(this.idClient.equals(idClient)) {
			Panier temp= new Panier();
			for(Book b : books)
				temp.addBook(b);
				temp.setIdClient(idClient);
			entityManager.persist(temp);
			this.books.clear();
		}
		else
			throw new RuntimeException("erreur de validation de la commande, utilisateur inconnu");
	}


	/**
	 * @param idClient l'identifiant du client
	 *
	 * @return liste des paniers ayant validé par le client
	 */
	public List<Panier> getCommandes(String idClient) {
		Query query = entityManager.createQuery("SELECT p from Panier p where p.idClient=?1");
		query.setParameter(1, idClient);
		return query.getResultList();
	}

	/**
	 *
	 * @return liste des commandes récentes validé par le client
	 */
	public HashMap<Long,List<Book>> getLastOrders(String idClient) {
		List<Panier> maListe= getCommandes(idClient);
		HashMap<Long,List<Book>> map = new HashMap<Long,List<Book>>();
		for(Panier p : maListe){
			List<Book> books = new ArrayList<Book>();
			for(Map.Entry<Long, Integer> entry : p.getCommande().entrySet()) {
			    Long cle = entry.getKey();
					Book b = bookBean.getBook(cle);
					b.setQte(entry.getValue());
			    books.add(b);
			}
			map.put(p.getId(),books);
		}
		return map;
	}

}
