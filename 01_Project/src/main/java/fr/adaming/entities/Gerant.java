package fr.adaming.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Classe correspondant aux Gerant : gère une agence et les conseillers associes
 * Persistence, enregistrée dans la table personnes, avec le rôle gerant
 * Il n'a pas d'attribut, juste des associations
 * @author inti0302
 *
 */
@Entity
@DiscriminatorValue("gerant")
public class Gerant extends Conseiller{

	
	private static final long serialVersionUID = 1L;
	
	/* Les associations : une liste de conseiller et une agence */
	@OneToMany(mappedBy="gerant")
	private List<Conseiller> listeConseiller;
	
	/**
	 * Un gerant gère une agence
	 */
	@OneToOne(mappedBy="gerant")
	private Agence agence;

	/* Les constructeurs  */
	
	/**
	 * 
	 * Constructeur vide
	 */
	public Gerant() {
		super();
	}

	/**
	 * Constructeur pour faire un gérant
	 * @param nom
	 * @param prenom
	 * @param password
	 */
	public Gerant(String nom, String prenom, String password) {
		super(nom, prenom, password);
	}

	/**
	 * Constructeur complet
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param role
	 * @param password
	 */
	public Gerant(int id, String nom, String prenom, String role, String password) {
		super(id, nom, prenom, role, password);
	}

	/* GETTER ET SETTERS */
	
	public List<Conseiller> getListeConseiller() {
		return listeConseiller;
	}

	public void setListeConseiller(List<Conseiller> listeConseiller) {
		this.listeConseiller = listeConseiller;
	}

	
	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/**
	 * Réecriture de la methode tostring pour debuger
	 */
	@Override
	public String toString() {
		return "Gerant [getPassword()=" + getPassword() + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getRole()=" + getRole() + "]";
	}
	
	
	
	
	
}
