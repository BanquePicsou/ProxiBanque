package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;
import fr.adaming.entities.CompteEpargne;
import fr.adaming.service.ICompteServive;
/**
 * controlleur pour la gestion des comptes
 * avec comme uri global : /compte
 * @author inti0242
 *
 */
@Controller
@RequestMapping("/compte")
public class CompteController {
	/**
	 * compteService utilisé avec l'injection de dependance de spring
	 * utilsé pour l'appel des methodes de la classe service
	 */
	@Autowired
	private ICompteServive compteService;

	/**
	 * permet l'injection de dependance avec spring
	 * @return
	 */
	public ICompteServive getCompteService() {
		return compteService;
	}
	
	
	//methodes pour ajouter un compte
	/*pour le compte epargne*/
	//afficher formulaire compte Epargne
	/**
	 * Methode qui permet l'affichage du formulaire de création d'un nouveau compte Epargne
	 * @return ModelAndView : le formulaire qui permet de créer un nouveau compte Epargne
	 */
	@RequestMapping(value="/ajoutCompteEpargne", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireAjoutCompteEpargne(){
		
		return new ModelAndView("addCompteEpargne","command",new CompteEpargne());
	}
	//soumettre formulaire compte Epargne
	/**
	 * methode qui permet de valider et enregistrer un nouveau compte epargne dans la base de donnée
	 * @param modelMap
	 * @param pCompteEpargne
	 * @return 
	 */
	@RequestMapping(value="/soumettreCompteEpargne", method=RequestMethod.POST)
	public String enregistrementAjoutCompteEpargne(ModelMap modelMap, CompteEpargne pCompteEpargne){
		
		compteService.addCompteEpargne(pCompteEpargne);
		return "listeCompteEpargne"; }
		
		/*pour le compte courant*/
		//afficher formulaire compte Courant
		/**
		 * Methode qui permet l'affichage du formulaire de création d'un nouveau compte Courant
		 * @return ModelAndView : le formulaire qui permet de créer un nouveau compte Courant
		 */
		@RequestMapping(value="/ajoutCompteCourant", method=RequestMethod.GET)
		public ModelAndView afficherFormulaireAjoutCompteCourant(){
			
			return new ModelAndView("addCompteCourant","command",new CompteCourant());
		}
		//soumettre formulaire compte Courant
		/**
		 * methode qui permet de valider et enregistrer un nouveau compte courant dans la base de donnée
		 * @param modelMap
		 * @param pCompteCourant
		 * @return 
		 */
		@RequestMapping(value="/soumettreCompteCourant", method=RequestMethod.POST)
		public String enregistrementAjoutCompteCourant(ModelMap modelMap, CompteCourant pCompteCourant){
			
			compteService.addCompteCourant(pCompteCourant);
			return "listeCompteCourant"; }
	
	//methodes pour modifier un compte
		/*pour le compte epargne*/
		//afficher formulaire modif compte Epargne
		/**
		 * Methode qui permet l'affichage du formulaire de modififier compte Epargne
		 * @return ModelAndView : le formulaire qui permet de créer modifier un compte Epargne
		 */
		@RequestMapping(value="/modifierCompteEpargne", method=RequestMethod.GET)
		public ModelAndView afficherFormulaireModifCompteEpargne(){
			
			return new ModelAndView("updateCompteEpargne","command",new CompteEpargne());
		}
		//soumettre formulaire modif compte Epargne
		/**
		 * methode qui permet de valider et enregistrer une modification d'un compte epargne dans la base de donnée
		 * @param modelMap
		 * @param pCompteEpargne
		 * @return 
		 */
		@RequestMapping(value="/soumettreModifCompteEpargne", method=RequestMethod.POST)
		public String enregistrementModifCompteEpargne(ModelMap modelMap, CompteEpargne pCompteEpargne){
			
			compteService.updateCompteEpargne(pCompteEpargne);
			return "listeCompteEpargne"; }
			
			/*pour le compte courant*/
			//afficher formulaire modif compte Courant
			/**
			 * Methode qui permet l'affichage du formulaire de modification d'un compte Courant
			 * @return ModelAndView : le formulaire qui permet de modification d'un compte Courant
			 */
			@RequestMapping(value="/modifCompteCourant", method=RequestMethod.GET)
			public ModelAndView afficherFormulaireModifCompteCourant(){
				
				return new ModelAndView("updateCompteCourant","command",new CompteCourant());
			}
			//soumettre formulaire modif compte Courant
			/**
			 * methode qui permet de valider et enregistrer une modification d'un compte courant dans la base de donnée
			 * @param modelMap
			 * @param pCompteCourant
			 * @return 
			 */
			@RequestMapping(value="/soumettreModifCompteCourant", method=RequestMethod.POST)
			public String enregistremenModiftCompteCourant(ModelMap modelMap, CompteCourant pCompteCourant){
				
				compteService.updateCompteCourant(pCompteCourant);
				return "listeCompteCourant"; }
	
	
	//methodes pour supprimer un compte
	
			/**
			 * 
			 * @return
			 */
			@RequestMapping(value = "/supCompte", method = RequestMethod.GET)
			public String supC() {
				// direction vers le formulaire de suppression
				return "deleteCompte";
			}

			// on soumet les donnes du formulaire
			/**
			 * 
			 * @param model
			 * @param id
			 * @return
			 */
			@RequestMapping(value = "/supprimerCompte", method = RequestMethod.GET)
			public String supprimerEmployes(Model model, @RequestParam("id_param") int id) {
				
				compteService.deleteCompte(id);
				
				return "listeCompteCourant";

			}
	
	//methodes pour afficher les listes des comptes
			
			/**
			 * redirection vers la liste a affichee
			 * @param model
			 * @return
			 */
			@RequestMapping(value = "/cc", method = RequestMethod.GET)
			public String afficherCC() {
				
				return "listeCompteCourant";
			}
			//liste compte courant
			/**
			 * methode pour afficher la liste dans une page
			 * @param model
			 * @return page de redirection
			 */
			@RequestMapping(value = "/listeCompteCourant", method = RequestMethod.GET)
			public String afficherCompteCourant(ModelMap model) {

				List<CompteCourant> listeCompteCourant = compteService.getAllCompteCourant();

				model.addAttribute("ccListe", listeCompteCourant);
				return "listeCompteCourant";
			}
			
			/**
			 * redirection vers la liste a affichee de compte epargne
			 * @param model
			 * @return page de redirection
			 */
			@RequestMapping(value = "/ce", method = RequestMethod.GET)
			public String afficherCE() {
				
				return "listeCompteEpargne";
			}
			//liste compte epargne
			/**
			 * methode pour afficher la liste de compte epargne dans une page
			 * @param model
			 * @return page de redirection
			 */
			@RequestMapping(value = "/listeCompteEpargne", method = RequestMethod.GET)
			public String afficherCompteEpargne(ModelMap model) {

				List<CompteEpargne> listeCompteEpargne = compteService.getAllCompteEpargne();

				model.addAttribute("ceListe", listeCompteEpargne);
				return "afficherListeCe";
			}


}
