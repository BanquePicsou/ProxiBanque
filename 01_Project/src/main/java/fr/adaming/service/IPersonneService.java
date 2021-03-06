package fr.adaming.service;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	/** Ajoute un client en appelant la m�thode g�n�rique Dao ajout Personne */
	public String addClient (Client client, Conseiller conseiller);
	/** Ajoute un g�rant en appelant la m�thode g�n�rique Dao ajout Personne */
	public void addGerant (Gerant gerant);
	/** Ajoute un conseiller en appelant la m�thode g�n�rique Dao ajout Personne */
	public void addConseiller (Conseiller conseiller, Gerant g);
	
	/* pour supprimer */
	/** Cette methode peut supprimer n'importe quelle personne selon son id*/
	public String deletePersonne (int id, HttpSession session);
	
	
	/* pour update */
	/** met � jour un client*/
	public void updateClient (Client client);
	/** met � jour un gerant*/
	public void updateGerant (Gerant gerant);
	/** met � jour un conseiller*/
	public void updateConseiller (Conseiller conseiller);
	
	
	/* pour r�cup�rer */
	/** Permet de r�cup�rer n'importe quelle personne selon son ID */
	public Personne getPersonne (int id);
	/** R�cup�re la liste int�grale des personnes et ses classes filles */
	public List<Personne> getAllPersonne();
	/** Permet de r�cup�rer la liste des clients � l'aide des r�gles de gestion d�finie dans la classe service */
	public List<Client> getAllClients();
	/** Permet de r�cup�rer la liste des g�rants � l'aide des r�gles de gestion d�finie dans la classe service */
	public List<Gerant> getAllGerant();
	/** Permet de r�cup�rer la liste des conseiler � l'aide des r�gles de gestion d�finie dans la classe service */
	public List<Conseiller> getAllConseiller();
	/** Permet de r�cup�rer la liste des conseiller pour un g�rant � l'aide des r�gles de gestion d�finie dans la classe service */
	public List<Conseiller> getConseillersByGerant (Gerant gerant);
	/** Permet de r�cup�rer la liste des clients par conseiler � l'aide des r�gles de gestion d�finie dans la classe service */
	public List<Client> getClientsByConseiller (Conseiller conseiller);
	

}
