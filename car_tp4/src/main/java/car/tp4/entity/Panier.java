package car.tp4.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Panier implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String idClient;
	private HashMap<Long,Integer> commande;

	public Panier(String idClient, HashMap<Long,Integer> commande) {
		this.idClient = idClient;
		this.commande = commande;
	}

	public Panier() {
		commande = new HashMap<Long,Integer>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public HashMap<Long,Integer> getCommande() {
		return commande;
	}

	public void setCommande(HashMap<Long,Integer> commande) {
		this.commande = commande;
	}

	public void addBook(Book b){
		commande.put(b.getId(),b.getQte());
	}

}
