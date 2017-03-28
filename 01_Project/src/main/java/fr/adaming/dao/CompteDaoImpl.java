package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entities.Compte;
/**
 * Classe dao pour les comptes façon generique
 * @author inti0242
 *
 * @param <T>
 */
@Repository
public class CompteDaoImpl<T extends Compte> implements ICompteDao<T> {

	/**
	 * appel de emf pour faire les requetes jpa
	 */
	@Autowired
	EntityManagerFactory emf;
	
	//setter pour injection
	
	public void setEmF(EntityManagerFactory emf) {
		this.emf = emf;
	}

	//methodes crud
	
	/**
	 * methode ajouter un compte (epargne ou courant)
	 */
	@Override
	public void addCompte(T compte) {
		EntityManager em=emf.createEntityManager();
		em.persist(compte);
		
	}

	/**
	 * supprimer un compte (epargne ou courant)
	 */
	@Override
	public void deleteCompte(T compte) {
		EntityManager em=emf.createEntityManager();
	em.remove(compte);
		
	}

	/**
	 * recupperer la liste de compte
	 */
	@Override
	public List<Compte> getList() {
		EntityManager em=emf.createEntityManager();
		String req="select c from Compte c";
		Query query=em.createQuery(req);
		return query.getResultList();
	}

	/**
	 * trouver un compte par son id
	 */
	@Override
	public Compte getCompte(int id) {
		EntityManager em=emf.createEntityManager();
		return em.find(Compte.class, id) ;
	}

	/**
	 * modifier un compte 
	 */
	@Override
	public void updateCompte(T compte) {
		EntityManager em=emf.createEntityManager();
	em.merge(compte);
		
	}

	
}
