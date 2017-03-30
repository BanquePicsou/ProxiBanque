package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICompteDao;
import fr.adaming.entities.Compte;
import fr.adaming.entities.CompteCourant;
import fr.adaming.entities.CompteEpargne;
/**
 * classe service pour les comptes (permet de gérer les regles de gestion des comptes)
 * @Service : reconnaissance en tant que Service par Spring IoC
 * @Transactional : le service va initier les transactions avec la BDD
 * @author inti0242
 *
 */
@Service
@Transactional
public class CompteServiceImpl implements ICompteServive {

	/**
	 * utilisation de compteDao pour l'appel des methodes de la classe CompteDao
	 * @Autowired pour l'injection de dépendance avec spring
	 */
	@Autowired
	private ICompteDao compteDao;
	
	//setter pour injection 

	/**
	 * setter pour l'injection de l'autowired
	 * @param compteDao
	 */
	public void setCompteDao(ICompteDao compteDao) {
		this.compteDao = compteDao;
	}

	//methode crud
	/**
	 * ajouter un compte Epargne
	 * @param ce CompteEpargne 
	 */
	@Override
	public void addCompteEpargne(CompteEpargne ce) {
		ce.setTypecompte("compteEpargne");
		compteDao.addCompte(ce);

	}


	/**
	 * Ajouter un compte courant
	 * @param cc CompteCourant
	 */
	@Override
	public void addCompteCourant(CompteCourant cc) {
		cc.setTypecompte("compteCourant");
		compteDao.addCompte(cc);

	}

	/**
	 * supprimer un comte epargne ou un compte courant
	 * @param id du compte a supprimer
	 */
	@Override
	public void deleteCompte(int id) {
		Compte compte = compteDao.getCompte(id);
		
		compteDao.deleteCompte(compte);

	}

	/**
	 * obtenir un compte compte
	 * @param id du compte a chercher
	 */
	@Override
	public Compte getCompte(int id) {

		return compteDao.getCompte(id);
	}

	/**
	 * obtenir la liste des comptes epargnes
	 * @return liste des comptes epargnes 
	 */
	@Override
	public List<CompteEpargne> getAllCompteEpargne() {
		List<Compte> listeC = compteDao.getList();
		List<CompteEpargne> listeE = new ArrayList<>();
		for (Compte c : listeC) {
			if (c.getTypecompte().equals("compteEpargne")) {
				listeE.add((CompteEpargne) c);
			}
		}
		
		return listeE;
	}

	/**
	 * obtenir la liste des comptes courants
	 * @return liste des comptes courants
	 */
	@Override
	public List<CompteCourant> getAllCompteCourant() {

		List<Compte> listeC = compteDao.getList();
		List<CompteCourant> listeCC = new ArrayList<>();
		for (Compte c : listeC) {
			if (c.getTypecompte().equals("compteCourant")) {
				listeCC.add((CompteCourant) c);
			}
		}
		
		return listeCC;

	}

	/**
	 * Modifier un compte epargne
	 * @param ce CompteEpargne
	 */
	@Override
	public void updateCompteEpargne(CompteEpargne ce) {
		ce.setTypecompte("compteEpargne");
		compteDao.updateCompte(ce);
		
	}

	/**
	 * Modififier un compte courant
	 * @param cc CompteCourant
	 */
	@Override
	public void updateCompteCourant(CompteCourant cc) {
		cc.setTypecompte("compteCourant");
		compteDao.updateCompte(cc);
	}

}
