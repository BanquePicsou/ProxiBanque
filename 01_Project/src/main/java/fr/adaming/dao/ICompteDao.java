package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Compte;

public interface ICompteDao<T extends Compte> {

	
	public void addCompte(T compte);
	public void deleteCompte(T compte);
	public List<Compte> getList();
	public Compte getCompte(int id);
	public void updateCompte(T compte);
	public List<Compte> getCompteByClient(Client client);
	
}
