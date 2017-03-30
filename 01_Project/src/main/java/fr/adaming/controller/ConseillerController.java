package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Client;
import fr.adaming.service.IPersonneService;

/**
 * Controller pour des methoders sp�cifiques d'un conseiller :
 * 1)Afficher une liste de client
 * 2)Afficher sa liste de client 
 * 3)Virement de compte �  compte
 * 
 * @author Robin
 *
 */
@Controller
@RequestMapping("/user/conseiller")
public class ConseillerController {

	/**
	 * Attribut utilis� pour l'appel du service
	 * @Autowired pour l'injection de d�pendance
	 */
	@Autowired
	IPersonneService personneService;
	
	@RequestMapping(value="/allClient", method=RequestMethod.GET)
	public String getAllClient(ModelMap model){
		List<Client> liste = personneService.getAllClients();
		model.addAttribute("listeClient", liste);
		return null; //mettre une rediction
	}
	
	/* CODER METHODE get CLIENT BY CONTROLLER QUAND SESSION VUE OK*/
	
	
	
}
