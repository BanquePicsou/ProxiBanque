package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Agence;
import fr.adaming.entities.Gerant;
import fr.adaming.service.IAgenceService;
import fr.adaming.service.IPersonneService;

@Controller
@RequestMapping("/admin/agence")
public class AgenceController{

	/**
	 *  Attribut utilisé pour l'appel du service
	 * @Autowired pour l'injection de dépendance
	 */
	@Autowired
	IAgenceService agenceService;
	
	@Autowired
	IPersonneService personneService;

	public void setAgenceService(IAgenceService agenceService) {
		this.agenceService = agenceService;
	}
	
	
	public void setPersonneService(IPersonneService personneService) {
		this.personneService = personneService;
	}



	@RequestMapping(value="/ajoutAgence", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireAgence(ModelMap model){
		List<Gerant> liste = personneService.getAllGerant();
		model.addAttribute("gerants", liste);
		return new ModelAndView("BigBoss/newAgence","command",new Agence());
	}
	
	@RequestMapping(value="/soumettreAjouterAgence", method=RequestMethod.POST)
	public String enregistrementAgence(ModelMap modelMap, Agence pAgence){
		agenceService.addAgence(pAgence);
		List<Agence> listeAgence = agenceService.getList();
		modelMap.addAttribute("agenceListe", listeAgence);
		return "BigBoss/listeAgence";
	}
	
	@RequestMapping(value="/deleteAgence/{idA}", method=RequestMethod.GET)
	public String deleteAgence(ModelMap modelMap,@PathVariable("idA") int id){
		agenceService.deleteAgence(agenceService.getAgence(id));
		List<Agence> listeAgence = agenceService.getList();
		modelMap.addAttribute("agenceListe", listeAgence);
		return "BigBoss/listeAgence";
	}
	
	@RequestMapping(value="/updateAgence/{idA}", method=RequestMethod.GET)
	public String updateVueAgence(ModelMap modelMap,@PathVariable("idA") int id){
		Agence agenceAModifier=agenceService.getAgence(id);
		modelMap.addAttribute("AgenceAModifier", agenceAModifier);
		return "BigBoss/ModifAgence"; 
	}
	
	@RequestMapping(value="/soumettreUpdateAgence", method=RequestMethod.POST)
	public String updateSoumettreAgence(ModelMap modelMap, Agence pAgence){
		List<Agence> listeAgence = agenceService.getList();
		modelMap.addAttribute("agenceListe", listeAgence);
		return "BigBoss/listeAgence";
	}
	
	@RequestMapping(value = "/listeAgence", method = RequestMethod.GET)
	public String afficherAgence(ModelMap model) {
		List<Agence> listeAgence = agenceService.getList();
		model.addAttribute("agenceListe", listeAgence);
		return "BigBoss/listeAgence";
	}
	

}
