package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Client;
import fr.adaming.entities.Conseiller;
import fr.adaming.entities.Gerant;
import fr.adaming.entities.Personne;
import fr.adaming.service.IPersonneService;


/**
 * Controlleur pour les personnes 
 * controle uniquement les m�thodes li�s aux personnes de 
 * personne g�n�rique : 
 * -CRUD
 * -listes
 * Les associations et les m�thodes sp�cifiques sont ger�s dans des controlleurs 
 * sp�cifiques
 * @author Robin
 *
 */
@Controller
@RequestMapping("/user")
public class PersonneController {

	/**
	 * Attribut utilis� pour l'appel du service
	 * @Autowired pour l'injection de d�pendance
	 */
	@Autowired
	IPersonneService personneService;
	
	
	/* -------------------------------------------- les m�thodes d'ajouts de personnes : */
	/*-1)Ajout d'un client*/
	/* 1)a)g�n�ration du formulaire */
	/**
	 * Methode qui permet l'affichage du formulaire de cr�ation d'un nouveau client
	 * @return ModelAndView : le formulaire qui permet de cr�er un nouveau client
	 */
	@RequestMapping(value="/ajoutClient", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireClient(){
		System.out.println("--debuggage : on rentre dans la methode qui charge le formulaire d'inscription du client: \n");
		return new ModelAndView("newClient","command",new Client());
	}
	/**
	 * Appel la m�thode de Personne Service pour ajouter un nouveau Client � la BDD
	 * @param modelMap : la session
	 * @param pClient : le client cr�e dans la vue par l'utilisateur
	 * @return un string pour la navigation
	 */
	/*1)b)enregistrement du client*/
	@RequestMapping(value="/soumettreClient", method=RequestMethod.POST)
	public String enregistrementEmploye(ModelMap modelMap, Client pClient){
		System.out.println("--debuggage: on rentre dans la methode qui envois le formulaire client au service : \n");
		System.out.println("Le client est :");
		System.out.println(pClient);
		System.out.println("--------------------------");
		personneService.addClient(pClient);
		return null; /* !!!!!!!!!METTRE LE RETOUR ICI LORS DE LA CREATION DE LA PAGE ET DE LA NAVIGATION */
	}
	/*-2)Ajout d'un conseiller*/
	/* 2)a)g�n�ration du formulaire */
	/**
	 * Methode qui permet l'affichage du formulaire de cr�ation d'un nouveau conseiller
	 * @return ModelAndView : le formulaire qui permet de cr�er un nouveau conseiller
	 */
	@RequestMapping(value="/ajoutConseiller", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireConseiller(){
		System.out.println("--debuggage : on rentre dans la methode qui charge le formulaire d'inscription du conseiller: \n");
		return new ModelAndView("newConseiller","command",new Conseiller());
	}
	/**
	 * Appel la m�thode de Personne Service pour ajouter un nouveau Conseiller � la BDD
	 * @param modelMap : la session
	 * @param pConseiller : le Conseiller cr�e dans la vue par l'utilisateur
	 * @return un string pour la navigation
	 */
	/*2)b)enregistrement du Conseiller*/
	@RequestMapping(value="/soumettreConseiller", method=RequestMethod.POST)
	public String enregistrementEmploye(ModelMap modelMap, Conseiller pConseiller){
		System.out.println("--debuggage: on rentre dans la methode qui envois le formulaire Conseiller au service : \n");
		System.out.println("Le Conseiller est :");
		System.out.println(pConseiller);
		System.out.println("--------------------------");
		personneService.addConseiller(pConseiller);
		return null; /* !!!!!!!!!METTRE LE RETOUR ICI LORS DE LA CREATION DE LA PAGE ET DE LA NAVIGATION */
	}
	/*-3)Ajout d'un g�rant*/
	/* 3)a)g�n�ration du formulaire */
	/**
	 * Methode qui permet l'affichage du formulaire de cr�ation d'un nouveau Gerant
	 * @return ModelAndView : le formulaire qui permet de cr�er un nouveau Gerant
	 */
	@RequestMapping(value="/ajoutGerant", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireGerant(){
		System.out.println("--debuggage : on rentre dans la methode qui charge le formulaire d'inscription du Gerant: \n");
		return new ModelAndView("newGerant","command",new Gerant());
	}
	/**
	 * Appel la m�thode de Personne Service pour ajouter un nouveau Gerant � la BDD
	 * @param modelMap : la session
	 * @param pGerant : le Gerant cr�e dans la vue par l'utilisateur
	 * @return un string pour la navigation
	 */
	/*3)b)enregistrement du Gerant*/
	@RequestMapping(value="/soumettreGerant", method=RequestMethod.POST)
	public String enregistrementEmploye(ModelMap modelMap, Gerant pGerant){
		System.out.println("--debuggage: on rentre dans la methode qui envois le formulaire Gerant au service : \n");
		System.out.println("Le Gerant est :");
		System.out.println(pGerant);
		System.out.println("--------------------------");
		personneService.addGerant(pGerant);
		return null; /* !!!!!!!!!METTRE LE RETOUR ICI LORS DE LA CREATION DE LA PAGE ET DE LA NAVIGATION */
	}
	
	
	/* --------------------------la methode de suppression de personne--------------------------------- */
	/**
	 * Methode pour supprimer un user
	 * Le controlleur appel la m�thode service pour supprimer
	 * Les regles de gestion sont d�finie dans le service (pour �viter qu'un conseiller supprime un admin
	 * par exemple)
	 * @param modelMap session
	 * @param id de la personne a supprimer
	 * @param le r�le de la personne a supprimer
	 * @return String pour la navigation
	 */
	@RequestMapping(value="/delete{idP}{role}", method=RequestMethod.GET)
	public String deletePersonne(ModelMap modelMap,@PathVariable("idP") int id,@PathVariable("role") String role){
		System.out.println("--debuggage: on rentre dans la methode qui supprime personne \n");
		String retour = personneService.deletePersonne(id, role);
		System.out.println("-- le string retourn� pour la navigation est : "+retour);
		return retour; 
	}
	
		
	/* les methodes de r�cup�ration de liste */
	/*1) r�cup�ration de la liste globale */
	/**
	 * Retourne dans le model sous le nom personneList la liste compl�te de tout les employ�s (utilis� par l'admin ?)
	 * @param model
	 * @return string pour la navigation
	 */
	@RequestMapping(value="/admin/liste", method=RequestMethod.GET)
	public String afficherPersonne(ModelMap model){
		List<Personne> listePersonne = personneService.getAllPersonne();
		model.addAttribute("personneListe", listePersonne);
		return null; /* mettre le retour pour la navigation quand on aura tout fini :) */
	}
	
	
}
