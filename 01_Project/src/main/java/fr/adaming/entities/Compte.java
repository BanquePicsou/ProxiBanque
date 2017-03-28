package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * La classe abstraite Compte qui contient les info 
 * de base partagés par tous les comptes
 * Une seule table qui contient tt, 
 * différencié par type de compte
 * @author inti0302
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@Table(name="comptes")
public abstract class Compte implements Serializable {

	/* les attributs de tous comptes*/
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id_compte")
	private int id;
	@Column(name="num_compte")
	private long numero;
	@Column(name="solde_compte")
	private double solde;
	@Column(name="datecrea_compte")
	private Date datecreation;
	
	/* Les associations : chaque compte est lié à un client et chaque client a un compte (de chaque type) */
	@ManyToOne
	private Client client;

	/* Constructeurs : */
	
	/**
	 * Constructeur vide
	 */
	public Compte() {
		super();
	}

	/** constructeur d'un compte sans client associé*/
	public Compte(long numero, double solde, Date datecreation) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.datecreation = datecreation;
	}

	/** constructeur d'un compte avec client associé */
	public Compte(long numero, double solde, Date datecreation, Client client) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.datecreation = datecreation;
		this.client = client;
	}

	/** constructeur complet */
	public Compte(int id, long numero, double solde, Date datecreation, Client client) {
		super();
		this.id = id;
		this.numero = numero;
		this.solde = solde;
		this.datecreation = datecreation;
		this.client = client;
	}

	/* GETTER ET SETTERS */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
}
