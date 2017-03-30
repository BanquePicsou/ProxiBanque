package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Gerant;
import fr.adaming.service.IPersonneService;

/**
 * Controller pour des methoders sp�cifiques d'un admin :
 * 1)Afficher une liste de g�rant 
 * @author inti0302
 *
 */
@Controller
@RequestMapping("/user/admin")
public class AdminController {
	
	/**
	 * Attribut utilis� pour l'appel du service
	 * @Autowired pour l'injection de d�pendance
	 */
	@Autowired
	IPersonneService personneService;
	
	
	@RequestMapping(value="/listeGerant", method=RequestMethod.GET)
	public String getListGerant(ModelMap model){
		List<Gerant> liste = personneService.getAllGerant();
		model.addAttribute("listeGerant", liste);
		return "BigBoss/listeGerant";//mettre la page
	}
	

}
