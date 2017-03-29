package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Personne;

/**
 * Interface g�n�rique utilis� par la classe PersonneDaoImpl
 * @author Robin
 *
 * @param <T> g�n�ricit� : T inclus Personne et toutes ses classes filles
 */
public interface IPersonneDao<T extends Personne> {

	/** ajouter une personne de tout type � la bdd */
	public void addPersonne(T personne);
	/** delete une personne de tout type de la bdd */
	public void deletePersonne(T personne);
	/** r�cupere la liste int�grale de la bdd */
	public List<Personne> getList();
	/** r�cuperer une personne de la bdd */
	public Personne getPersonne(int id);
	/** met � jour tout type de persone de la BDD */
	public void updatePersonne(T personne);
	
}
