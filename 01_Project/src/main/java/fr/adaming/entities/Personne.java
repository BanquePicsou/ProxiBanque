package fr.adaming.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * La classe abstraite Personne comprend les informations de bases 
 * lié à toute persone liée 
 * @author inti0302
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="rôle")
public abstract class Personne {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
}
