package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IPersonneDao;
import fr.adaming.entities.Client;
import fr.adaming.entities.Conseiller;
import fr.adaming.entities.Gerant;
import fr.adaming.entities.Personne;

/**
 * La classe PersonneServiceImpl implemente 
 * l'interface IPersonneService et redefini ses méthodes
 * C'est ici que sont définie les differentes regles de gestion et
 * l'appel de la classe  + interface DAO pour l'interaction avec
 * la base de donnée.
 * @Service : reconnaissance en tant que Service par Spring IoC
 * @Transactional : le service va initier les transactions avec la BDD
 * @author Robin
 *
 */
@Service
@Transactional
public class PersonneServiceImpl implements IPersonneService {

	/**
	 * L'attribut personneDao est utilisé pour l'appel des 
	 * méthodes de la classe PersoneDao. 
	 * Il est annoté par @Autowired pour l'injection de dépendance
	 * @SuppresWarnings retire l'avertissement lié à la généricité de la 
	 * classe+interface PersonneDao
	 */
	@SuppressWarnings("rawtypes")
	@Autowired
	IPersonneDao personneDao;
	
	
	/** Ajoute un client en appelant la méthode générique Dao ajout Personne
	 * Comme il s'agit d'un client, le rôle "client" lui est attribué avant 
	 * la transmission à la base de donnée
	 * @param client : le conseiller créer par l'utilisateur 
	 * @SuprresWarning annule l'erreur lié à la généricité de PersonneDao */
	@SuppressWarnings("unchecked")
	@Override
	public void addClient(Client client) {
		client.setRole("client");
		personneDao.addPersonne(client);
		
	}

	/** Ajoute un gerant en appelant la méthode générique Dao ajout Personne
	 * Comme il s'agit d'un gerant, le rôle "gerant" lui est attribué avant 
	 * la transmission à la base de donnée
	 * @param gerant : le gerant créer par l'utilisateur 
	 * @SuprresWarning annule l'erreur lié à la généricité de PersonneDao */
	@SuppressWarnings("unchecked")
	@Override
	public void addGerant(Gerant gerant) {
		gerant.setRole("gerant");
		personneDao.addPersonne(gerant);
	}

	/** Ajoute un conseiller en appelant la méthode générique Dao ajout Personne
	 * Comme il s'agit d'un conseiller, le rôle "conseiller" lui est attribué avant 
	 * la transmission à la base de donnée
	 * @param conseiller : le conseiller créer par l'utilisateur 
	 * @SuprresWarning annule l'erreur lié à la généricité de PersonneDao */
	@SuppressWarnings("unchecked")
	@Override
	public void addConseiller(Conseiller conseiller) {
		conseiller.setRole("conseiller");
		personneDao.addPersonne(conseiller);
		
	}

	/** Cette methode peut supprimer n'importe quelle personne selon son id
	 * La personne est récupérée via la methode getByID puis envoyée à la 
	 * DAO via une méthode générique.
	 * @param id : identifiant dans la bdd de l'individu à supprimer
	 * @SuprresWarning annule l'erreur lié à la généricité de PersonneDao  */
	@SuppressWarnings("unchecked")
	@Override
	public void deletePersonne(int id) {
		personneDao.deletePersonne(personneDao.getPersonne(id));	
	}


	/**
	 * Retourne un individu enregistré dans la bdd (client, conseiller, gerant ou admin) 
	 * @param id : identifiant dans la bdd de l'individu recherché
	 * @return Personne (comprenant ses classes filles) 
	 */
	@Override
	public Personne getPersonne(int id) {	
		return personneDao.getPersonne(id);
	}

	/**
	 * 
	 * Cette méthode n'a pas de selection de type(client, conseiller, gerant ou admin)
	 * @SuprresWarning annule l'erreur lié à la généricité de PersonneDao
	 * @return liste intégrale des indivudes enregistrés dans la base 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> getAllPersonne() {
		return personneDao.getList();
	}

	
	/**
	 * Permet de sortir la liste des clients de la base de donnée
	 * @return listeRetour : la liste des clients, selectionés de la liste complète des personnes 
	 * à partir du rôle "client"
	 * @SuprresWarning annule l'erreur lié à la généricité de PersonneDao
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllClients() {
		List<Personne> liste = personneDao.getList();
		List<Client> listeRetour = new ArrayList<>();
		for(Personne p:liste){
			if(p.getRole().equals("client")){
				listeRetour.add((Client) p);
			}
		}
		return listeRetour;
	}

	
	/**
	 * Permet de sortir la liste des gerant de la base de donnée
	 * @return listeRetour : la liste des gerant, selectionés de la liste complète des personnes 
	 * à partir du rôle "gerant"
	 * @SuprresWarning annule l'erreur lié à la généricité de PersonneDao
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Gerant> getAllGerant() {
		List<Personne> liste = personneDao.getList();
		List<Gerant> listeRetour = new ArrayList<>();
		for(Personne p:liste){
			if(p.getRole().equals("gerant")){
				listeRetour.add((Gerant) p);
			}
		}
		return listeRetour;
	}

	/**
	 * Permet de sortir la liste des conseiller de la base de donnée
	 * @return listeRetour : la liste des conseiller, selectionés de la liste complète des personnes 
	 * à partir du rôle "conseiller"
	 * @SuprresWarning annule l'erreur lié à la généricité de PersonneDao
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Conseiller> getAllConseiller() {	
		List<Personne> liste = personneDao.getList();
		List<Conseiller> listeRetour = new ArrayList<>();
		for(Personne p:liste){
			if(p.getRole().equals("conseiller")){
			listeRetour.add((Conseiller) p);
			}
		}
		return listeRetour;
	}

	/**
	 * Permet de sortir la liste des conseiller d'un gérant
	 * La liste générique des personnes est récupérée.
	 * Ensuite, chaque conseiler est identifié via son rôle.
	 * Si le gérant correspond, le conseiler est ajouté à la liste de retour
	 * @param gerant : le gerant dont on veut la liste de conseiller
	 * @return liste de conseiller trié selon le gérant
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Conseiller> getConseillersByGerant(Gerant gerant) {
		List<Personne> liste = personneDao.getList();
		List<Conseiller> listeRetour = new ArrayList<>();
		for(Personne p:liste){
			if(p.getRole().equals("conseiller")){
				/* Cast en conseiller pour utiliser les méthodes de conseiller */
				Conseiller c = (Conseiller) p;
				if(c.getGerant().equals(gerant)){
					listeRetour.add(c);
				}
			}
		}
		return listeRetour;
	}

	/**
	 * Permet de sortir la liste des client d'un conseilelr
	 * La liste générique des personnes est récupérée.
	 * Ensuite, chaque client est identifié via son rôle.
	 * Si le conseiller correspond, le client est ajouté à la liste de retour
	 * @param conseiller : le conseiller dont on veut la liste de client
	 * @return liste de client trié selon le conseiller
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClientsByConseiller(Conseiller conseiller) {
		List<Personne> liste = personneDao.getList();
		List<Client> listeRetour = new ArrayList<>();
		for(Personne p:liste){
			if(p.getRole().equals("client")){
				/* Cast en client pour utiliser les méthodes de conseiller */
				Client c = (Client) p;
				if(c.getConseiller().equals(conseiller)){
					listeRetour.add(c);
				}
			}
		}
		return listeRetour;
	}

}
