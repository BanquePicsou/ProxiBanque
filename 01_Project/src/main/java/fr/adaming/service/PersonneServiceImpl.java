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
 * l'interface IPersonneService et redefini ses m�thodes
 * C'est ici que sont d�finie les differentes regles de gestion et
 * l'appel de la classe  + interface DAO pour l'interaction avec
 * la base de donn�e.
 * @Service : reconnaissance en tant que Service par Spring IoC
 * @Transactional : le service va initier les transactions avec la BDD
 * @author Robin
 *
 */
@Service
@Transactional
public class PersonneServiceImpl implements IPersonneService {

	/**
	 * L'attribut personneDao est utilis� pour l'appel des 
	 * m�thodes de la classe PersoneDao. 
	 * Il est annot� par @Autowired pour l'injection de d�pendance
	 * @SuppresWarnings retire l'avertissement li� � la g�n�ricit� de la 
	 * classe+interface PersonneDao
	 */
	@SuppressWarnings("rawtypes")
	@Autowired
	IPersonneDao personneDao;
	
	
	/** Ajoute un client en appelant la m�thode g�n�rique Dao ajout Personne
	 * Comme il s'agit d'un client, le r�le "client" lui est attribu� avant 
	 * la transmission � la base de donn�e
	 * @param client : le conseiller cr�er par l'utilisateur 
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao */
	@SuppressWarnings("unchecked")
	@Override
	public void addClient(Client client) {
		client.setRole("client");
		personneDao.addPersonne(client);
		
	}

	/** Ajoute un gerant en appelant la m�thode g�n�rique Dao ajout Personne
	 * Comme il s'agit d'un gerant, le r�le "gerant" lui est attribu� avant 
	 * la transmission � la base de donn�e
	 * @param gerant : le gerant cr�er par l'utilisateur 
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao */
	@SuppressWarnings("unchecked")
	@Override
	public void addGerant(Gerant gerant) {
		gerant.setRole("gerant");
		personneDao.addPersonne(gerant);
	}

	/** Ajoute un conseiller en appelant la m�thode g�n�rique Dao ajout Personne
	 * Comme il s'agit d'un conseiller, le r�le "conseiller" lui est attribu� avant 
	 * la transmission � la base de donn�e
	 * @param conseiller : le conseiller cr�er par l'utilisateur 
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao */
	@SuppressWarnings("unchecked")
	@Override
	public void addConseiller(Conseiller conseiller) {
		conseiller.setRole("conseiller");
		personneDao.addPersonne(conseiller);
		
	}

	/** Cette methode peut supprimer n'importe quelle personne selon son id
	 * La personne est r�cup�r�e via la methode getByID puis envoy�e � la 
	 * DAO via une m�thode g�n�rique.
	 * @param id : identifiant dans la bdd de l'individu � supprimer
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao  */
	@SuppressWarnings("unchecked")
	@Override
	public void deletePersonne(int id) {
		personneDao.deletePersonne(personneDao.getPersonne(id));	
	}


	/**
	 * Retourne un individu enregistr� dans la bdd (client, conseiller, gerant ou admin) 
	 * @param id : identifiant dans la bdd de l'individu recherch�
	 * @return Personne (comprenant ses classes filles) 
	 */
	@Override
	public Personne getPersonne(int id) {	
		return personneDao.getPersonne(id);
	}

	/**
	 * 
	 * Cette m�thode n'a pas de selection de type(client, conseiller, gerant ou admin)
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao
	 * @return liste int�grale des indivudes enregistr�s dans la base 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> getAllPersonne() {
		return personneDao.getList();
	}

	
	/**
	 * Permet de sortir la liste des clients de la base de donn�e
	 * @return listeRetour : la liste des clients, selection�s de la liste compl�te des personnes 
	 * � partir du r�le "client"
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao
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
	 * Permet de sortir la liste des gerant de la base de donn�e
	 * @return listeRetour : la liste des gerant, selection�s de la liste compl�te des personnes 
	 * � partir du r�le "gerant"
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao
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
	 * Permet de sortir la liste des conseiller de la base de donn�e
	 * @return listeRetour : la liste des conseiller, selection�s de la liste compl�te des personnes 
	 * � partir du r�le "conseiller"
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao
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
	 * Permet de sortir la liste des conseiller d'un g�rant
	 * La liste g�n�rique des personnes est r�cup�r�e.
	 * Ensuite, chaque conseiler est identifi� via son r�le.
	 * Si le g�rant correspond, le conseiler est ajout� � la liste de retour
	 * @param gerant : le gerant dont on veut la liste de conseiller
	 * @return liste de conseiller tri� selon le g�rant
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Conseiller> getConseillersByGerant(Gerant gerant) {
		List<Personne> liste = personneDao.getList();
		List<Conseiller> listeRetour = new ArrayList<>();
		for(Personne p:liste){
			if(p.getRole().equals("conseiller")){
				/* Cast en conseiller pour utiliser les m�thodes de conseiller */
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
	 * La liste g�n�rique des personnes est r�cup�r�e.
	 * Ensuite, chaque client est identifi� via son r�le.
	 * Si le conseiller correspond, le client est ajout� � la liste de retour
	 * @param conseiller : le conseiller dont on veut la liste de client
	 * @return liste de client tri� selon le conseiller
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClientsByConseiller(Conseiller conseiller) {
		List<Personne> liste = personneDao.getList();
		List<Client> listeRetour = new ArrayList<>();
		for(Personne p:liste){
			if(p.getRole().equals("client")){
				/* Cast en client pour utiliser les m�thodes de conseiller */
				Client c = (Client) p;
				if(c.getConseiller().equals(conseiller)){
					listeRetour.add(c);
				}
			}
		}
		return listeRetour;
	}

}
