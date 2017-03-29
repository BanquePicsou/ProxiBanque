package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Compte;
import fr.adaming.entities.CompteCourant;
import fr.adaming.entities.CompteEpargne;

/**
 * interfacace du compte service
 * @author inti0242
 *
 */
public interface ICompteServive {

	/* Les methodes pour ajouter un compte */
	public void addCompteEpargne (CompteEpargne ce);
	public void addCompteCourant (CompteCourant cc);
	
	
	/* pour supprimer */
	public void deleteCompte (int id);
	
	/* pour récupérer un compte*/
	public Compte getCompte (int id);
	
	/*recupere liste*/
	public List<CompteEpargne> getAllCompteEpargne();
	public List<CompteCourant> getAllCompteCourant();

	
}
