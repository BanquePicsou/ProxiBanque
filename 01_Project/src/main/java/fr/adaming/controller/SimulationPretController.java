package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Client;
import fr.adaming.entities.Compte;
import fr.adaming.entities.CompteEpargne;
import fr.adaming.service.ICompteServive;
import fr.adaming.service.IPersonneService;

/**
 * Contrôleur servant à calculer et envoyer une simmulation de pret immobilier
 * pour un client
 * 
 * @author Thomas
 *
 */
@Controller
@RequestMapping("/simul")
public class SimulationPretController {

	/**
	 * Attribut utilisé pour l'appel du service
	 * 
	 * @Autowired pour l'injection de dépendance
	 */
	@Autowired
	IPersonneService personneService;

	public void setPersonneService(IPersonneService personneService) {
		this.personneService = personneService;
	}

	/**
	 * Attribut utilisé pour l'appel du service compte
	 * 
	 * @Autowired pour l'injection de dépendance
	 */
	@Autowired
	ICompteServive compteService;

	public void setCompteService(ICompteServive compteService) {
		this.compteService = compteService;
	}

	/**
	 * Methode qui permet l'affichage du formulaire de selection d'un client
	 * 
	 * @return ModelAndView : le formulaire qui permet de créer un nouveau
	 *         client
	 */
	@RequestMapping(value = "/simulClient", method = RequestMethod.GET)
	public ModelAndView accueil(ModelMap model) {
		System.out
				.println("--debuggage : on rentre dans la methode qui charge le formulaire de selection du client: \n");

		List<Client> listeClient = personneService.getAllClients();

		model.addAttribute("listeClient", listeClient);

		return new ModelAndView("Simulation/simulationForm", "clientForm", new Client());

	}

	// Soumission du Formulaire
	@RequestMapping(value = "/soumettreSimulClient", method = RequestMethod.POST)
	public String soumettreFormSimul(ModelMap model, @ModelAttribute("clientForm") Client pClient, String pMontant,
			String pDuree, String pNbEch) {

		System.out.println("--debuggage : on rentre dans la methode qui lance la simulation: \n");

		Client client = (Client) personneService.getPersonne(pClient.getId());
		System.out.println(client);
		
		double montant = 0;
		int duree = 0;
		int nbEch = 0;

		try {
			montant = Double.valueOf(pMontant);
			duree = Integer.valueOf(pDuree);
			nbEch = Integer.valueOf(pNbEch);
		} catch (Exception e) {
			e.getMessage();
		}

		String[][] resulatSimul = simulation(client, montant, duree, nbEch);

		model.addAttribute("client", client);
		model.addAttribute("montant", montant);
		model.addAttribute("duree", duree);
		model.addAttribute("nbEch", nbEch);
		model.addAttribute("resulatSimul", resulatSimul);

		return "Simulation/simulationResult";

	}

	private String[][] simulation(Client client, double montant, int duree, int nbEch) {

		String[][] tableauResult = new String[(duree * nbEch) + 1][4];

		List<Compte> listeComptes = client.getListeCompte();
		System.out.println(listeComptes);
		CompteEpargne ce = null;
		for (Compte c : listeComptes) {
			if (c.getTypecompte().equals("epargne")) {
				ce = (CompteEpargne) c;
			}
		}

		if (ce != null) {
			nbEch *= duree;

			double tauxAnnuel = ce.getTaux();

			double tauxPeriodique = (tauxAnnuel * 0.01 / nbEch);

			double montantEch = 0;
			double interets = 0;
			double capitalRemb = 0;
			double capital = montant;

			montantEch = Math.round(((capital * tauxPeriodique) / (1 - Math.pow((1 + tauxPeriodique), -nbEch))) * 100)
					/ 100;

			int i = 0;

			while (capital > 0) {
				interets = Math.round(capital * tauxPeriodique * 100) / 100;

				capitalRemb = Math.round((montantEch - interets) * 100) / 100;
				if (capitalRemb > capital) {
					capitalRemb = Math.round(capital * 100) / 100;
				}
				capital -= capitalRemb;

				tableauResult[i][0] = "Echéance " + (i + 1);
				tableauResult[i][1] = String.valueOf(capital + capitalRemb) + " x "
						+ String.valueOf(tauxPeriodique * 100) + "% = " + String.valueOf(interets) + "€";
				tableauResult[i][2] = String.valueOf(montantEch) + " - " + String.valueOf(interets) + " = "
						+ String.valueOf(capitalRemb) + "€";
				tableauResult[i][3] = String.valueOf(capital + capitalRemb) + " - " + String.valueOf(capitalRemb)
						+ " = " + String.valueOf(capital) + "€";

				i++;
			}

		}

		return tableauResult;
	}

}
