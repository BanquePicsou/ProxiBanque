package fr.adaming.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * La classe Compte Epargne
 * Mappé dans la table compte
 * @author inti0302
 *
 */
@Entity
@DiscriminatorValue("epargne")
public class CompteEpargne extends Compte {

	/* les attributs */
	private static final long serialVersionUID = 1L;
	/** le taux d'un compte epargne, vaut de base 0.3% (inscrit dans les regle service à la creation */
	private float taux;
	
	
	
	/* Les constructeurs  */
	/**
	 * Constructeur vide
	 */
	public CompteEpargne() {
		super();
	}
	
	/**
	 * Constructeur sans client (sans taux, car taux set dans service lors de la creation)
	 * @param numero
	 * @param solde
	 * @param datecreation
	 */
	public CompteEpargne(long numero, double solde, Date datecreation) {
		super(numero, solde, datecreation);
	}

	/**
	 * Constructeur avec client (sans taux, car taux set dans service lors de la creation)
	 * @param numero
	 * @param solde
	 * @param datecreation
	 * @param client
	 */
	public CompteEpargne(long numero, double solde, Date datecreation, Client client) {
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
	 * @param taux
	 */
	public CompteEpargne(int id, long numero, double solde, Date datecreation,String typecompte, Client client, float taux) {
		super(id, numero, solde, datecreation,typecompte, client);
		this.taux = taux;
	}


	/* getter et setters*/
	
	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	

	/**
	 * La methode ToString pour debuggage
	 */
	@Override
	public String toString() {
		return "CompteEpargne [taux=" + taux + ", getId()=" + getId() + ", getNumero()=" + getNumero() + ", getSolde()="
				+ getSolde() + ", getDatecreation()=" + getDatecreation() + ", getClient()=" + getClient() + "]";
	}
	
	
}
