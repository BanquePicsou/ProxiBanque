package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Personne;

/**
 * Interface générique utilisé par la classe PersonneDaoImpl
 * @author Robin
 *
 * @param <T> généricité : T inclus Personne et toutes ses classes filles
 */
public interface IPersonneDao<T extends Personne> {

	/** ajouter une personne de tout type à la bdd */
	public void addPersonne(T personne);
	/** delete une personne de tout type de la bdd */
	public void deletePersonne(T personne);
	/** récupere la liste intégrale de la bdd */
	public List<Personne> getList();
	/** récuperer une personne de la bdd */
	public Personne getPersonne(int id);
	/** met à jour tout type de persone de la BDD */
	public void updatePersonne(T personne);
	
}
