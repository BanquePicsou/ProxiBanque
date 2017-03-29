package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Conseiller;
import fr.adaming.entities.Gerant;
import fr.adaming.entities.Personne;

/**
 * Interface du service Personne.
 * Le service assure la communication entre le controller et la DAO.
 * @author Robin
 *
 */
public interface IPersonneService {
	
	/* Les methodes pour ajouter une personne */
	/** Ajoute un client en appelant la méthode générique Dao ajout Personne */
	public void addClient (Client client);
	/** Ajoute un gérant en appelant la méthode générique Dao ajout Personne */
	public void addGerant (Gerant gerant);
	/** Ajoute un conseiller en appelant la méthode générique Dao ajout Personne */
	public void addConseiller (Conseiller conseiller);
	
	/* pour supprimer */
	/** Cette methode peut supprimer n'importe quelle personne selon son id */
	public void deletePersonne (int id);
	
	/* pour récupérer */
	/** Permet de récupérer n'importe quelle personne selon son ID */
	public Personne getPersonne (int id);
	/** Récupère la liste intégrale des personnes et ses classes filles */
	public List<Personne> getAllPersonne();
	/** Permet de récupérer la liste des clients à l'aide des régles de gestion définie dans la classe service */
	public List<Client> getAllClients();
	/** Permet de récupérer la liste des gérants à l'aide des régles de gestion définie dans la classe service */
	public List<Gerant> getAllGerant();
	/** Permet de récupérer la liste des conseiler à l'aide des régles de gestion définie dans la classe service */
	public List<Conseiller> getAllConseiller();
	/** Permet de récupérer la liste des conseiller pour un gérant à l'aide des régles de gestion définie dans la classe service */
	public List<Conseiller> getConseillersByGerant (Gerant gerant);
	/** Permet de récupérer la liste des clients par conseiler à l'aide des régles de gestion définie dans la classe service */
	public List<Client> getClientsByConseiller (Conseiller conseiller);
}
