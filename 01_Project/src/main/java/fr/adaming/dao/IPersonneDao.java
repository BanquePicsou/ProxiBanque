package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Personne;

public interface IPersonneDao<T extends Personne> {

	public void addPersonne(T personne);
	public void deletePersonne(T personne);
	public List<Personne> getList();
	public Personne getPersonne(int id);
	public void updatePersonne(T personne);
	
}
