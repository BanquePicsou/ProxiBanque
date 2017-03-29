package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * La classe abstraite Personne comprend les informations de bases 
 * lié à toute persone enregistrées dans la base de donnée.
 * Les classes filles sont : Client et Conseiller Clientèle.
 * Tous les users sont mapés dans la 
 * @author inti0302
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="rôle")
@Table(name="personnes")
public abstract class Personne implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private int id;
	@Column(name="nom_personne")
	private String nom;
	@Column(name="prenom_personne")
	private String prenom;
	/** Cet attribut est inscrit dans la bdd pour discriminer les users
	attribué à la personne dans le service lors de l'ajout*/
	@Column(name="role_personne")
	private String role;
	@Column(name="actived")
	@Type(type="byte")
	boolean actived;
	
	
	/* Constructeurs */
	/**
	 * Constructeur vide la classe personne
	 */
	public Personne() {
		super();
	}

	/**
	 * Constructeur avec paramètre (sans id)
	 * Sans rôle : celui-ci est inscrit via le setter dans le Service
	 * @param nom
	 * @param prenom
	 * @param role
	 */
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
			}

	/**
	 * Constructeur chargé
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param role
	 */
	public Personne(int id, String nom, String prenom, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
	}


		
	/*Getter et Setters */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
