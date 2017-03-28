package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Conseiller;
import fr.adaming.entities.Gerant;
import fr.adaming.entities.Personne;

public interface IPersonneService {
	
	/* Les methodes pour ajouter une personne */
	public void addClient (Client client);
	public void addGerant (Gerant gerant);
	public void addConseiller (Conseiller conseiller);
	
	/* pour supprimer */
	public void deletePersonne (int id);
	
	/* pour récupérer */
	public Personne getPersonne (int id);
	public List<Personne> getAllPersonne();
	public List<Client> getAllClients();
	public List<Gerant> getAllGerant();
	public List<Conseiller> getAllConseiller();
	public List<Conseiller> getConseillersByGerant (Gerant gerant);
	public List<Client> getClientsByConseiller (Conseiller conseiller);
}
