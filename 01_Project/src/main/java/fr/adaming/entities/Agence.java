package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * La classe Agence est gerée par un gerant, comporte plusieurs 
 * conseiller et sert plusieurs clients (a travers les conseiller)
 * Elle est persistente
 * @author inti0302
 *
 */
@Entity
@Table(name="agences")
public class Agence implements Serializable {

	/* les attributs d'une agence */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agence")
	private int id;
	@Column(name="identifiant_agence")
	private String identifiant;
	@Column(name="creation_agence")
	private Date datecreation;
	
	/* Les associations */
	/**
	 * Une agence est gerée par un gerant et un gerant gere une agence
	 */
	@OneToOne
	private Gerant gerant;
	
	/**
	 * L'admin gère toutes les agences
	 */
	@ManyToOne
	private Admin admin;
	
	
	/* Les constructeurs */
	
	/**
	 * Constructeur vide
	 */
	public Agence() {
		super();
	}

	/**
	 * Constructeur identifiant (la date creation est set a la creation dans le service)
	 * @param identifiant
	 */
	public Agence(String identifiant) {
		super();
		this.identifiant = identifiant;
	}


	/**
	 * Constructeur complet
	 * @param id
	 * @param identifiant
	 * @param datecreation
	 */
	public Agence(int id, String identifiant, Date datecreation) {
		super();
		this.id = id;
		this.identifiant = identifiant;
		this.datecreation = datecreation;
	}

	/* getter et setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/** Methode ToString pour debug */
	@Override
	public String toString() {
		return "Agence [id=" + id + ", identifiant=" + identifiant + ", datecreation=" + datecreation + ", gerant="
				+ gerant + ", admin=" + admin + "]";
	}

	
	
	
}
