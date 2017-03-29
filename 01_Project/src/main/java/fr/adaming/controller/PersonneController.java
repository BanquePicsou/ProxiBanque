package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Client;
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
	
	
	
	
	
	
	
	
	
	
	
	/* la methode de suppression de personne */ 
	
	/* les methodes de r�cup�ration de liste */
	
	
}
