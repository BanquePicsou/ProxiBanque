package fr.adaming.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Agence;
import fr.adaming.entities.Client;
import fr.adaming.entities.Conseiller;
import fr.adaming.service.IAgenceService;

@Controller
@RequestMapping("/admin/agence")
public class AgenceController{

	/**
	 *  Attribut utilisé pour l'appel du service
	 * @Autowired pour l'injection de dépendance
	 */
	@Autowired
	IAgenceService agenceService;

	public void setAgenceService(IAgenceService agenceService) {
		this.agenceService = agenceService;
	}
	
	@RequestMapping(value="/ajoutAgence", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireAgence(){
		System.out.println("--debuggage : on rentre dans la methode qui charge le formulaire de création d'agence: \n");
		return new ModelAndView("newAgence","command",new Agence());
	}
	
	@RequestMapping(value="/soumettreAjouterAgence", method=RequestMethod.POST)
	public String enregistrementAgence(ModelMap modelMap, Agence pAgence){
		System.out.println("--debuggage: on rentre dans la methode qui envois le formulaire Agence au service : \n");
		System.out.println("L'agence est :");
		System.out.println(pAgence);
		System.out.println("--------------------------");
		agenceService.addAgence(pAgence);
		return "BigBoss/ajoutAgence";
	}
	
	@RequestMapping(value="/deleteAgence{idA}", method=RequestMethod.GET)
	public String deleteAgence(ModelMap modelMap,@PathVariable("idA") int id){
		System.out.println("--debuggage: on rentre dans la methode qui supprime une agence \n");
		agenceService.deleteAgence(agenceService.getAgence(id));
		return "deleteAgence"; 
	}
	
	@RequestMapping(value="/updateAgence{idA}", method=RequestMethod.GET)
	public String updateVueAgence(ModelMap modelMap,@PathVariable("idA") int id){
		System.out.println("--debuggage: on rentre dans la methode qui modifieune agence \n");
		Agence agenceAModifier=agenceService.getAgence(id);
		modelMap.addAttribute("AgenceAModifier", agenceAModifier);
		return "updateVueAgence"; 
	}
	
	@RequestMapping(value="/soumettreUpdateAgence", method=RequestMethod.POST)
	public String updateSoumettreAgence(ModelMap modelMap, Agence pAgence){
		System.out.println("--debuggage: on rentre dans la methode qui envois le formulaire Agence au service : \n");
		System.out.println("L'agence est :");
		System.out.println(pAgence);
		System.out.println("--------------------------");
		agenceService.addAgence(pAgence);
		return "updateAgence";
	}
	
	@RequestMapping(value = "/listeAgence", method = RequestMethod.GET)
	public String afficherAgence(ModelMap model) {
		List<Agence> listeAgence = agenceService.getList();
		model.addAttribute("agenceListe", listeAgence);
		return "BigBoss/gererListe";
	}
	

}
