package fr.adaming.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Client;
import fr.adaming.entities.Conseiller;
import fr.adaming.entities.Personne;
import fr.adaming.service.IPersonneService;

/**
 * Controller pour des methoders spécifiques d'un conseiller :
 * 1)Afficher une liste de client
 * 2)Afficher sa liste de client 
 * 3)Virement de compte à  compte
 * 
 * @author Robin
 *
 */
@Controller
@RequestMapping("/user/conseiller")
public class ConseillerController {

	/**
	 * Attribut utilisé pour l'appel du service
	 * @Autowired pour l'injection de dépendance
	 */
	@Autowired
	IPersonneService personneService;
	
	@RequestMapping(value="/allClient", method=RequestMethod.GET)
	public String getAllClient(ModelMap model){
		List<Client> liste = personneService.getAllClients();
		model.addAttribute("listeClient", liste);
		return "Conseiller/client/listeAllClient"; //mettre une rediction
	}
	
	/* CODER METHODE get CLIENT BY CONTROLLER QUAND SESSION VUE OK*/
	@RequestMapping(value="/mesclients", method=RequestMethod.GET)
	public String getClientsByConseiller(ModelMap model, HttpSession session){	
		Conseiller c = (Conseiller) session.getAttribute("users");
		List<Client> liste = personneService.getClientsByConseiller(c);
		model.addAttribute("listeClientBy", liste);
		return "Conseiller/client/listeClient";//ajouter la page d'affichage
	}
	
	
}
