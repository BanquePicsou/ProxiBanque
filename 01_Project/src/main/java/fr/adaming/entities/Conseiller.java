package fr.adaming.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@DiscriminatorValue("conseiller")
public class Conseiller extends Personne{

	
	private static final long serialVersionUID = 1L;
	/* les attributs spécifiques d'un conseiller/gérant/admin */
	/**
	 * Le mot de passe utilisé pour la connexion
	 */
	@Column(name="mdp_users")
	private String password;
	
	
	/* Les asso a mapper : 1 gerant et une liste de client */
	@OneToMany(mappedBy="conseiller")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Client> listeClient;
	
	@ManyToOne
	private Gerant gerant;
	
	/* Les constructeurs */
	
	/**
	 * Constructeur vide
	 */
	public Conseiller() {
		super();
	}

	/**
	 * Constructeur utilisé lors de la creation d'un conseiller clientele
	 * @param nom
	 * @param prenom
	 * @param password
	 */
	public Conseiller(String nom, String prenom, String password) {
		super(nom, prenom);
		this.password = password;
	}

	/**
	 * Constructeur complet
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param role
	 * @param password
	 */
	public Conseiller(int id, String nom, String prenom, String role, String password) {
		super(id, nom, prenom, role);
		this.password = password;
	}

	/* getter et setters */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

	
	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	/**
	 * La methode ToString pour le debugage
	 */
	@Override
	public String toString() {
		return "Conseiller [password=" + password + ", getId()=" + getId()
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getRole()=" + getRole() + "]";
	}
	
	
	
}
