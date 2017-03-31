package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;
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
	/** Ajout d'un compte epargne */
	public String addCompteEpargne (CompteEpargne ce, Client client);
	/** Ajout d'un compte courant */
	public String addCompteCourant (CompteCourant cc, Client client);
	
	/* Les methodes pour modifier un compte */
	/** Modification d'un compte epargne */
	public void updateCompteEpargne (CompteEpargne ce);
	/** Modification d'un compte courant */
	public void updateCompteCourant (CompteCourant cc);
	
	/* pour supprimer */
	/** Supprimer d'un compte avec l'id */
	public void deleteCompte (int id);
	
	/* pour récupérer un compte*/
	/** Chercher un compte avec l'id */
	public Compte getCompte (int id);
	
	/*recupere liste*/
	/** Recuperer la liste des comptes epargnes */
	public List<CompteEpargne> getAllCompteEpargne();
	/** Recuperer la liste des comptes courants */
	public List<CompteCourant> getAllCompteCourant();

	public List<Compte> getCompteByClient(Client client);
	
}
