package fr.adaming.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeContext;
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
import fr.adaming.service.IPersonneService;

/**
 * controlleur pour la gestion des comptes avec comme uri global : /compte
 * 
 * @author inti0242
 *
 */
@Controller
@RequestMapping("/compte")
public class CompteController {
	/**
	 * compteService utilisé avec l'injection de dependance de spring utilsé
	 * pour l'appel des methodes de la classe service
	 */
	@Autowired
	private ICompteServive compteService;

	@Autowired
	private IPersonneService personneService;

	/**
	 * permet l'injection de dependance avec spring pour invoquer les services
	 * de la classe compte service
	 * 
	 * @return
	 */

	public void setCompteService(ICompteServive compteService) {
		this.compteService = compteService;
	}

	/**
	 * permet l'injection de dependance avec spring pour invoquer les services
	 * de la classe personne service
	 * @param personneService
	 */
	public void setPersonneService(IPersonneService personneService) {
		this.personneService = personneService;
	}

	//METHODE POUR AJOUTER UN COMPTE
	/* pour le compte epargne */
	// a) afficher formulaire compte Epargne
	/**
	 * Methode qui permet l'affichage du formulaire de création d'un nouveau
	 * compte Epargne
	 * 
	 * @return ModelAndView : le formulaire qui permet de créer un nouveau
	 *         compte Epargne
	 */
	@RequestMapping(value = "/ajoutCompteEpargne", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireAjoutCompteEpargne(ModelMap modelMap) {

		List<Client> listeClient = personneService.getAllClients();
		modelMap.addAttribute("clientListe", listeClient);

		return new ModelAndView("Conseiller/compte/addCompteEpargne", "command", new CompteEpargne());
	}

	// b) soumettre formulaire compte Epargne
	/**
	 * methode qui permet de valider et enregistrer un nouveau compte epargne
	 * dans la base de donnée 
	 * 
	 * @param modelMap
	 * @param pCompteEpargne
	 * @return
	 */
	@RequestMapping(value = "/soumettreCompteEpargne", method = RequestMethod.POST)
	public String enregistrementAjoutCompteEpargne(Model model, CompteEpargne pCompteEpargne) {
		
		if (pCompteEpargne.getId() == 0) {
			// ajout date
			Date datecreation = new Date();
			pCompteEpargne.setDatecreation(datecreation);
			// ajout client
			Client cl = (Client) personneService.getPersonne(pCompteEpargne.getClient().getId());
			pCompteEpargne.setClient(cl);
			compteService.addCompteEpargne(pCompteEpargne);

		} else {
			// ajout date
			Date datecreation = new Date();
			pCompteEpargne.setDatecreation(datecreation);
			// ajout client
			Client cl = (Client) personneService.getPersonne(pCompteEpargne.getClient().getId());
			pCompteEpargne.setClient(cl);
			compteService.updateCompteEpargne(pCompteEpargne);

		}
		List<CompteEpargne> listeCompteEpargne = compteService.getAllCompteEpargne();

		model.addAttribute("ceListe", listeCompteEpargne);

		return "Conseiller/compte/listeCompteEpargne";
	}

	/* pour le compte courant */
	//a) afficher formulaire compte Courant
	/**
	 * Methode qui permet l'affichage du formulaire de création d'un nouveau
	 * compte Courant
	 * 
	 * @return ModelAndView : le formulaire qui permet de créer un nouveau
	 *         compte Courant
	 */
	@RequestMapping(value = "/ajoutCompteCourant", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireAjoutCompteCourant(ModelMap modelMap) {
		List<Client> listeClient = personneService.getAllClients();

		modelMap.addAttribute("clientListe", listeClient);

		return new ModelAndView("Conseiller/compte/addCompteCourant", "command", new CompteCourant());
	}

	// b) soumettre formulaire compte Courant
	/**
	 * methode qui permet de valider et enregistrer un nouveau compte courant
	 * dans la base de donnée
	 * 
	 * @param modelMap
	 * @param pCompteCourant
	 * @return
	 */
	@RequestMapping(value = "/soumettreCompteCourant", method = RequestMethod.POST)
	public String enregistrementAjoutCompteCourant(Model model, CompteCourant pCompteCourant) {
		
		if (pCompteCourant.getId() == 0) {
			// ajout date
			Date datecreation = new Date();
			pCompteCourant.setDatecreation(datecreation);
			// ajout client
			Client cl = (Client) personneService.getPersonne(pCompteCourant.getClient().getId());
			pCompteCourant.setClient(cl);
			compteService.addCompteCourant(pCompteCourant);

		} else {
			Date datecreation = new Date();
			pCompteCourant.setDatecreation(datecreation);
			// ajout client
			Client cl = (Client) personneService.getPersonne(pCompteCourant.getClient().getId());
			pCompteCourant.setClient(cl);
			compteService.updateCompteCourant(pCompteCourant);

		}
		List<CompteCourant> listeCompteCourant = compteService.getAllCompteCourant();

		model.addAttribute("ccListe", listeCompteCourant);
		return "Conseiller/compte/listeCompteCourant";
	}

	// methodes pour modifier un compte
	/* pour le compte courant */

	/**
	 * permet la redirection vers la page ajout compte courant
	 * @param model
	 * @param id_cc
	 * @return
	 */
	@RequestMapping(value = "/afficherModifCC", method = RequestMethod.GET)
	public String afficherFormulaireModifCompteCourant(Model model, @RequestParam("id_param") int id_cc) {
		List<Client> listeClient = personneService.getAllClients();
		model.addAttribute("clientListe", listeClient);
		CompteCourant cc = (CompteCourant) compteService.getCompte(id_cc);
		model.addAttribute("command", cc);
		return "Conseiller/compte/addCompteCourant";
	}

	/* pour le compte epargne */
	/**
	 * permet la redirection vers la page ajout compte epargne
	 * @param model
	 * @param id_ce
	 * @return
	 */
	@RequestMapping(value = "/afficherModifCE", method = RequestMethod.GET)
	public String afficherFormulaireModifCompteEpargne(Model model, @RequestParam("id_param") int id_ce) {
		List<Client> listeClient = personneService.getAllClients();
		model.addAttribute("clientListe", listeClient);
		CompteEpargne ce = (CompteEpargne) compteService.getCompte(id_ce);
		model.addAttribute("command", ce);
		return "Conseiller/compte/addCompteEpargne";
	}

	// methodes pour supprimer un compte

	// on soumet les donnees du formulaire
	/**
	 * methode pour supprimer un compte epargne ou un compte courant
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/supprimerC", method = RequestMethod.GET)
	public String supprimerEmployes(Model model, @RequestParam("id_param") int id) {
		if (compteService.getCompte(id).getTypecompte().equals("compteCourant")) {
			compteService.deleteCompte(id);
			List<CompteCourant> listeCompteCourant = compteService.getAllCompteCourant();

			model.addAttribute("ccListe", listeCompteCourant);
			return "Conseiller/compte/listeCompteCourant";
		} else {
			compteService.deleteCompte(id);
			List<CompteEpargne> listeCompteEpargne = compteService.getAllCompteEpargne();

			model.addAttribute("ceListe", listeCompteEpargne);
		}
		return "Conseiller/compte/listeCompteEpargne";

	}

	// methodes pour afficher les listes des comptes

	// liste compte courant
	/**
	 * methode pour afficher la liste de compte epargne dans une page
	 * 
	 * @param model
	 * @return page de redirection
	 */
	@RequestMapping(value = "/listeCompteCourant", method = RequestMethod.GET)
	public String afficherCompteCourant(ModelMap model) {

		List<CompteCourant> listeCompteCourant = compteService.getAllCompteCourant();

		model.addAttribute("ccListe", listeCompteCourant);
		return "Conseiller/compte/listeCompteCourant";
	}

	// liste compte epargne
	/**
	 * methode pour afficher la liste de compte epargne dans une page
	 * 
	 * @param model
	 * @return page de redirection
	 */
	@RequestMapping(value = "/listeCompteEpargne", method = RequestMethod.GET)
	public String afficherCompteEpargne(ModelMap model) {

		List<CompteEpargne> listeCompteEpargne = compteService.getAllCompteEpargne();

		model.addAttribute("ceListe", listeCompteEpargne);
		return "Conseiller/compte/listeCompteEpargne";
	}

}
