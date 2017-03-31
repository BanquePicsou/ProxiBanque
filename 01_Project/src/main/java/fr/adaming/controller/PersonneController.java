package fr.adaming.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

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
 * controle uniquement les méthodes liés aux personnes de 
 * personne générique : 
 * -CRUD
 * -listes
 * Les associations et les méthodes spécifiques sont gerés dans des controlleurs 
 * spécifiques
 * @author Robin
 *
 */
@Controller
@RequestMapping("/user")
public class PersonneController {

	/**
	 * Attribut utilisé pour l'appel du service
	 * @Autowired pour l'injection de dépendance
	 */
	@Autowired
	IPersonneService personneService;
	
	
	
	/* -------------------------------------------- les méthodes d'ajouts de personnes : */
	/*-1)Ajout d'un client*/
	/* 1)a)génération du formulaire */
	/**
	 * Methode qui permet l'affichage du formulaire de création d'un nouveau client
	 * @return ModelAndView : le formulaire qui permet de créer un nouveau client
	 */
	@RequestMapping(value="/ajoutClient", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireClient(){
		return new ModelAndView("Conseiller/client/newClient","command",new Client());
	}
	/**
	 * Appel la méthode de Personne Service pour ajouter un nouveau Client à la BDD
	 * @param modelMap : la session
	 * @param pClient : le client crée dans la vue par l'utilisateur
	 * @return un string pour la navigation
	 */
	/*1)b)enregistrement du client*/
	@RequestMapping(value="/soumettreClient", method=RequestMethod.POST)
	public String enregistrementEmploye(ModelMap modelMap, Client pClient, HttpSession session){
		Conseiller c = (Conseiller) session.getAttribute("users") ;
		personneService.addClient(pClient, c);
		return "Conseiller/listeClient"; /* !!!!!!!!!METTRE LE RETOUR ICI LORS DE LA CREATION DE LA PAGE ET DE LA NAVIGATION */
	}
	/*-2)Ajout d'un conseiller*/
	/* 2)a)génération du formulaire */
	/**
	 * Methode qui permet l'affichage du formulaire de création d'un nouveau conseiller
	 * @return ModelAndView : le formulaire qui permet de créer un nouveau conseiller
	 */
	@RequestMapping(value="/ajoutConseiller", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireConseiller(){
		System.out.println("--debuggage : on rentre dans la methode qui charge le formulaire d'inscription du conseiller: \n");
		return new ModelAndView("Gerant/newConseiller","command",new Conseiller());
	}
	/**
	 * Appel la méthode de Personne Service pour ajouter un nouveau Conseiller à la BDD
	 * @param modelMap : la session
	 * @param pConseiller : le Conseiller crée dans la vue par l'utilisateur
	 * @return un string pour la navigation
	 */
	/*2)b)enregistrement du Conseiller*/
	@RequestMapping(value="/soumettreConseiller", method=RequestMethod.POST)
	public String enregistrementEmploye(ModelMap modelMap, Conseiller pConseiller, HttpSession session){
		System.out.println("--debuggage: on rentre dans la methode qui envois le formulaire Conseiller au service : \n");
		System.out.println("Le Conseiller est :");
		System.out.println(pConseiller);
		System.out.println("--------------------------");
		Gerant g = (Gerant) session.getAttribute("users");
		personneService.addConseiller(pConseiller, g);
		return "Gerant/listeConseiller"; /* !!!!!!!!!METTRE LE RETOUR ICI LORS DE LA CREATION DE LA PAGE ET DE LA NAVIGATION */
	}
	/*-3)Ajout d'un gérant*/
	/* 3)a)génération du formulaire */
	/**
	 * Methode qui permet l'affichage du formulaire de création d'un nouveau Gerant
	 * @return ModelAndView : le formulaire qui permet de créer un nouveau Gerant
	 */
	@RequestMapping(value="/ajoutGerant", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireGerant(){
		System.out.println("--debuggage : on rentre dans la methode qui charge le formulaire d'inscription du Gerant: \n");
		return new ModelAndView("BigBoss/newGerant","command",new Gerant());
	}
	/**
	 * Appel la méthode de Personne Service pour ajouter un nouveau Gerant à la BDD
	 * @param modelMap : la session
	 * @param pGerant : le Gerant crée dans la vue par l'utilisateur
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
		List<Gerant> liste = personneService.getAllGerant();
		modelMap.addAttribute("listeGerant", liste);
		return "BigBoss/listeGerant"; /* !!!!!!!!!METTRE LE RETOUR ICI LORS DE LA CREATION DE LA PAGE ET DE LA NAVIGATION */
	}
	
	
	/* --------------------------la methode de suppression de personne--------------------------------- */
	/**
	 * Methode pour supprimer un user
	 * Le controlleur appel la méthode service pour supprimer
	 * Les regles de gestion sont définie dans le service (pour éviter qu'un conseiller supprime un admin
	 * par exemple)
	 * @param modelMap session
	 * @param id de la personne a supprimer
	 * @param le rôle de la personne a supprimer
	 * @return String pour la navigation
	 */
	@RequestMapping(value="/delete{idP}", method=RequestMethod.GET)
	public String deletePersonne(ModelMap modelMap,@PathVariable("idP") int id, HttpSession session){
		System.out.println("--debuggage: on rentre dans la methode qui supprime personne \n");
		String retour = personneService.deletePersonne(id,session);
		System.out.println("-- le string retourné pour la navigation est : "+retour);
		return retour; 
	}
			
	/*------- METTRE A JOUR DES PERSONNES ---------------
	 * 	a)Chargement du formulaire
	 */
	/**
	 * Chargement du formulaire pour modifier une personne
	 * Le formulaire modifié dépend du role
	 * @param id : en fonction de l'id, la personne a modifier est recupérée.
	 * @return modelAndView : le formulaire transmis dépend du role
	 */
	@RequestMapping(value="/update{idP}", method=RequestMethod.GET)
	public ModelAndView updatePersonne(@PathVariable("idP")int id){
		System.out.println("-----deggugage : chargergement du formulaire update personne");
		//recherche de la personne
		Personne p = personneService.getPersonne(id);
		System.out.println(p);
		if(p.getRole().equals("ROLE_CLIENT")){
			System.out.println("la personne recherchée est un client");
			Client c = (Client) p;
			return new ModelAndView("Conseiller/updateClient","command",c); 
		}
		if(p.getRole().equals("ROLE_GERANT")){
			System.out.println("la persone recherchée  est un gerant");
			Gerant g = (Gerant) p;
			return new ModelAndView("BigBoss/updateGerant","command",g);
		}
		if(p.getRole().equals("ROLE_CONSEILLER")){
			System.out.println("la personne recherchée est un conseiler");
			Conseiller c = (Conseiller) p;
			return new ModelAndView("Gerant/updateConseiller","command",c);
		}
		else{
			return null;//unique cas où c'est un admin)
		}
	}
	/*
	 * b)Envois du formulaire :
	 * a)Client
	 */
	/** envois le client modifié au service*/
	@RequestMapping(value="/update/client", method=RequestMethod.POST)
	public String updateClient (ModelMap modelMap, Client pClient){
		System.out.println("--debbug : debut de l'envois du formulaire au service :");
		System.out.println("le nouveau client : "+pClient);
		System.out.println("---------------------");
		personneService.updateClient(pClient);
		return "/Conseiller/listeClient";
	}
	/*b)Conseiller*/
	/** envois le conseiller modifié au service */
	@RequestMapping(value="/update/conseiller", method=RequestMethod.POST)
	public String updateConseiller(ModelMap modelMap, Conseiller pConseiller){
		System.out.println("--debbug : debut de l'envois du formulaire au service :");
		System.out.println("le nouveau conseiller : "+pConseiller);
		System.out.println("---------------------");
		personneService.updateConseiller(pConseiller);
		return "/Gerant/listeConseiller";
	}
	/*c)Gerant */
	/** envois le gerant modifié au service */
	@RequestMapping(value="/update/gerant", method=RequestMethod.POST)
	public String updateGerant(ModelMap modelMap, Gerant pGerant){
		System.out.println("--debbug : debut de l'envois du formulaire au service :");
		System.out.println("le nouveau gerant : "+pGerant);
		System.out.println("---------------------");
		personneService.updateGerant(pGerant);
		List<Gerant> liste = personneService.getAllGerant();
		modelMap.addAttribute("listeGerant", liste);
		return "/BigBoss/listeGerant";
	}
	
	
	/*------- CHERCHER UNE PERSONNE -------------*/
	/**
	 * Cette methode retourne une personne sur une page spécifique à son rôle
	 * @param id de la personne recherchée
	 * @param model va contenir les informations de la personee
	 * @return une page en fonction du role
	 */
	@RequestMapping("/get{idP}")
	public String getPersonne(@PathVariable("idP")int id,ModelMap model){
		Personne p = personneService.getPersonne(id);
		System.out.println("la methode get someone : ");
		System.out.println("La personne récupérée : "+p);
		System.out.println("-----------------");
		switch (p.getRole()) {
		case "ROLE_CLIENT":
			System.out.println("félicitation, c'est un client :)");
			Client c = (Client) p;
			model.addAttribute("client", c);
			return null;//une page dédiée à afficher les info d'un client
		case "ROLE_CONSEILLER":	
			System.out.println("félicitation, c'est un conseiller :)");
			Conseiller con =  (Conseiller) p;
			model.addAttribute("conseiller", con);
			return null;//une page dédiée à afficher les infos d'un conseiler
		case "ROLE_GERANT" :
			System.out.println("félication, c'est un gérant :)");
			Gerant ger = (Gerant) p;
			model.addAttribute("gerant", ger);
			return null;//une page dédiée à afficher les infos d'un gérant
		default:
			System.out.println("felication, on sait pas ce que c'est");
			return null;//une page d'echec ou la même page avec un message d'erreur dans le modelMap
		}
	
	}
}
