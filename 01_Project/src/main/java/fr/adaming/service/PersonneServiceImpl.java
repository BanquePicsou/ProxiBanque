package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	/**
	 * Le setter de personneDao pour le fonctionnement correct de l'autowired
	 * @param personneDao
	 */
	public void setPersonneDao(IPersonneDao personneDao) {
		this.personneDao = personneDao;
	}

	/** Ajoute un client en appelant la m�thode g�n�rique Dao ajout Personne
	 * Comme il s'agit d'un client, le r�le "client" lui est attribu� avant 
	 * la transmission � la base de donn�e
	 * @param client : le conseiller cr�er par l'utilisateur 
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao */
	@SuppressWarnings("unchecked")
	@Override
	public String addClient(Client client, Conseiller conseiller) {
		System.out.println("le conseiller est : "+conseiller);
		List<Client> liste = conseiller.getListeClient();
		System.out.println(liste);
		if(liste.size()<9){
			client.setRole("ROLE_CLIENT");
			client.setActived(true);
			personneDao.addPersonne(client);
			client.setConseiller(conseiller);
			liste.add(client);
			conseiller.setListeClient(liste);		
			personneDao.updatePersonne(conseiller);
			return "succes";
		}else{
			return "gofuckyourself";
			}
		
	}

	/** Ajoute un gerant en appelant la m�thode g�n�rique Dao ajout Personne
	 * Comme il s'agit d'un gerant, le r�le "gerant" lui est attribu� avant 
	 * la transmission � la base de donn�e
	 * @param gerant : le gerant cr�er par l'utilisateur 
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao */
	@SuppressWarnings("unchecked")
	@Override
	public void addGerant(Gerant gerant) {	
		gerant.setRole("ROLE_GERANT");
		gerant.setActived(true);	
		personneDao.addPersonne(gerant);
	}


	/** Cette methode peut supprimer n'importe quelle personne selon son id
	 * La personne est r�cup�r�e via la methode getByID puis envoy�e � la 
	 * DAO via une m�thode g�n�rique.
	 * @param role : le role de l'utilisateur connect�, pour v�rifier s'il a le privilege suffisant pour 
	 * supprimer l'utilisateur
	 * @param id : identifiant dans la bdd de l'individu � supprimer
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao 
	 * @return string utilis� pour la navigation suite � un refus de la suppression si privilege insuffisant */
	@SuppressWarnings("unchecked")
	@Override
	public String deletePersonne(int id, HttpSession session) {
		Personne p = personneDao.getPersonne(id);
		Personne user = (Personne) session.getAttribute("users");
		String role = user.getRole();
		//Si c'est un simple client, tout le monde peut supprimer
		if(p.getRole().equals("ROLE_CLIENT")){
			personneDao.deletePersonne(p);
			return "deleteok";
		}
		//si c'est un conseiller, seul gerant et admin peuvent supprimer
		if(p.getRole().equals("ROLE_CONSEILLER")){
			if(role.equals("ROLE_CONSEILLER")){
			return "refus";
			}
			if(role.equals("ROLE_GERANT") || role.equals("ROLE_ADMIN")){
				personneDao.deletePersonne(p);
				return "deleteok";
				}
		}
		//si c'est un g�rant, seul admin peut supprimer
		if(p.getRole().equals("ROLE_GERANT")){
			if(role.equals("ROLE_CONSEILLER")||role.equals("ROLE_GERANT")){
			return "refus";
			}
			if(role.equals("ROLE_ADMIN")){
				personneDao.deletePersonne(p);
				return "deleteok";
			}
		}
		//si c'est un admin, personne ne peut le supprimer
		if(p.getRole().equals("ROLE_ADMIN")){
			return "refus";
		}
		return null;
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
			if(p.getRole().equals("ROLE_CLIENT")){
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
			if(p.getRole().equals("ROLE_GERANT")){
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
			if(p.getRole().equals("ROLE_CONSEILLER")){
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
			if(p.getRole().equals("ROLE_CONSEILLER")){
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
		System.out.println("le conseiller de la session : ");
		System.out.println(conseiller);
		List<Client> listeRetour = new ArrayList<>();
		int idC = conseiller.getId();
		System.out.println("son id : "+idC);
		for(Personne p:liste){
			int a = 1;
			if(p.getRole().equals("ROLE_CLIENT")){
				System.out.println("---------"+a+")");
				Client c = (Client) p;
				System.out.println(c);
				a++;	
				int idCl = c.getConseiller().getId();
				System.out.println("L'id conseiler du client ="+idCl+", = "+idC+"(id du conseiller check");
				
			}
			
		}
			
		
		return listeRetour;
	}
	/**
	 * Met � jour un client en appellant la methode generique updatePersonne
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void updateClient(Client client) {
		personneDao.updatePersonne(client);	
	}
	/**
	 * Met � jour un gerant en appellant la methode generique updatePersonne
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void updateGerant(Gerant gerant) {
		personneDao.updatePersonne(gerant);		
	}
	/**
	 * Met � jour un conseiller en appellant la methode generique updatePersonne
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void updateConseiller(Conseiller conseiller) {
		personneDao.updatePersonne(conseiller);	
	}
	/** Ajoute un conseiller en appelant la m�thode g�n�rique Dao ajout Personne
	 * Comme il s'agit d'un conseiller, le r�le "conseiller" lui est attribu� avant 
	 * la transmission � la base de donn�e
	 * @param conseiller : le conseiller cr�er par l'utilisateur 
	 * @SuprresWarning annule l'erreur li� � la g�n�ricit� de PersonneDao */
	@SuppressWarnings("unchecked")
	@Override
	public void addConseiller(Conseiller conseiller, Gerant g) {
		conseiller.setGerant(g);
		List<Conseiller> liste = g.getListeConseiller();	
		conseiller.setRole("ROLE_CONSEILLER");
		conseiller.setActived(true);
		personneDao.addPersonne(conseiller);
		liste.add(conseiller);
		g.setListeConseiller(liste);	
		personneDao.updatePersonne(g);
	}

}
