package fr.adaming.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("courant")
public class CompteCourant extends Compte {

	/* Les attributs */
	private static final long serialVersionUID = 1L;
	/**
	 * specifique aux comptes courant
	 * decouvert par defaut de 1000€ set dans le service lors de la creation
	 */
	private double decouvert;
	
	/**
	 * Constructeur vide
	 */
	public CompteCourant() {
		super();
	}

	/**
	 * Constructeur sans client (sans decouvert, car decouvert set dans service lors de la creation)
	 * @param numero
	 * @param solde
	 * @param datecreation
	 */
	public CompteCourant(long numero, double solde, Date datecreation) {
		super(numero, solde, datecreation);
	}

	/**
	 * Constructeur avec client (sans decouvert, car decouvert set dans service lors de la creation)
	 * @param numero
	 * @param solde
	 * @param datecreation
	 * @param client
	 */
	public CompteCourant(long numero, double solde, Date datecreation, Client client) {
		super(numero, solde, datecreation, client);
	}


	/**
	 * Constructeur chargé
	 * @param id
	 * @param numero
	 * @param solde
	 * @param datecreation
	 * @param typecompte
	 * @param client
	 * @param decouvert
	 */
	public CompteCourant(int id, long numero, double solde, Date datecreation,String typecompte, Client client, double decouvert) {
		super(id, numero, solde, datecreation,typecompte, client);
		this.decouvert = decouvert;
	}

	/* getter et setters */
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	/**
	 * reecriture ToString pour debuggage
	 */
	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", getId()=" + getId() + ", getNumero()=" + getNumero()
				+ ", getSolde()=" + getSolde() + ", getDatecreation()=" + getDatecreation() + ", getClient()="
				+ getClient() + "]";
	}
	
	
	
	
}
