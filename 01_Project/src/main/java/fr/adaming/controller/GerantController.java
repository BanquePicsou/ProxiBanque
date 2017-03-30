package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Conseiller;
import fr.adaming.service.IPersonneService;

/**
 * Controller pour des afficages sp�cifique au g�rant 
 * 1)afficher tt les conseiller (pas importante)
 * 2)afficher ses conseiller (surtout celle l�)
 * @author inti0302
 *
 */
@Controller
@RequestMapping("/user/gerant")
public class GerantController {

	/**
	 * Attribut utilis� pour l'appel du service
	 * @Autowired pour l'injection de d�pendance
	 */
	@Autowired
	IPersonneService personneService;
	
	@RequestMapping(value="/listeConseiller", method=RequestMethod.GET)
	public String getAllConseiller(ModelMap model){
		List<Conseiller> liste = personneService.getAllConseiller();
		model.addAttribute("listeConseiller", liste);
		return null;//corriger apr�s
	}
	
}
