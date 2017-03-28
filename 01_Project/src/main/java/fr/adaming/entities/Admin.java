package fr.adaming.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Admin : doit etre crer a la main dans la bdd
 * a la capacite de creer des gerant et de les gerer + creer agence
 * pas dattribut perso jsute liste agence
 * @author inti0302
 * Pas besoin de constructeur
 */
@Entity
@DiscriminatorValue("admin")
public class Admin extends Gerant {

	
	private static final long serialVersionUID = 1L;

	
	

	/* Les associations : liste d'agence */
	
	/**/

	
	
	
}
