package fr.adaming.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Classe correspondant aux Client
 * Persistence, enregistr�e dans la table personnes, avec le r�le client
 * @author Robin
 *
 */
@Entity
@DiscriminatorValue("client")
public class Client extends Personne {

	
	private static final long serialVersionUID = 1L;
	/** Les informations sur le client */
	@Column(name="adresse_client")
	private String adresse;
	@Column(name="telephone_client")
	private String telephone;
	/** Chaque client a le choix entre une carte visa prenium et une carte electron */
	@Column(name="carte_client")
	private String carte;

	
	/* Les associations : 1 conseiller, 1 compte epargne, 1 compte courant*/
	@ManyToOne
	private Conseiller conseiller;
	
	/**
	 * Association avec le compte
	 * Chaque client peut avoir un compte epargne et un compte courant :
	 * Les regles de gestion sont verifies dans le service
	 */
	@OneToMany(mappedBy="client")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Compte> listeCompte;
	
	
	/* LES CONSTRUCTEURS */
	
	/**
	 * Constructeur vide
	 */
	public Client() {
		super();
	}

	/**
	 * Constructeur d'un client complet lors de l'instanciation de celui-ci dans le controlleur
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param telephone
	 * @param carte
	 */
	public Client(String nom, String prenom, String adresse, String telephone, String carte) {
		super(nom, prenom);
		this.adresse = adresse;
		this.telephone = telephone;
		this.carte = carte;
	}

	/**
	 * Constructeur complet
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param role
	 * @param adresse
	 * @param telephone
	 * @param carte
	 */
	public Client(int id, String nom, String prenom, String role, String adresse, String telephone, String carte) {
		super(id, nom, prenom, role);
		this.adresse = adresse;
		this.telephone = telephone;
		this.carte = carte;
	}

	
	
	/* Getter et Setter */
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCarte() {
		return carte;
	}

	public void setCarte(String carte) {
		this.carte = carte;
	}
	

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public List<Compte> getListeCompte() {
		return listeCompte;
	}

	public void setListeCompte(List<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}

	/**
	 * La r�ecriture de la m�thode ToString, utilise pour le debuggage
	 */
	@Override
	public String toString() {
		return "Client [adresse=" + adresse + ", telephone=" + telephone + ", carte=" + carte + ", getId()=" + getId()
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getRole()=" + getRole() + "]";
	}
	
	
	
}
