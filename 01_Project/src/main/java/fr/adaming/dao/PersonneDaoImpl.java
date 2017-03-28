package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fr.adaming.entities.Personne;

/**
 * Classe générique Dao pour les personnes(Client, Conseiler, Admin et Gérant)
 * Communique avec la BDD
 * @author inti0302
 *
 * @param <T>
 */
@Repository
public class PersonneDaoImpl<T extends Personne> implements IPersonneDao<T> {

	@Autowired
	EntityManagerFactory emf;
						
	/**
	 * Le setter de l'EMF pour le fonctionnement correct de l'autowired
	 * @return
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/**
	 * Methode generique pour ajouter une personne
	 */
	@Override
	public void addPersonne(T personne) {
		EntityManager em = emf.createEntityManager();
		em.persist(personne);
	}

	/**
	 * Methode generique pour delete une personne
	 */
	@Override
	public void deletePersonne(T personne) {
		EntityManager em = emf.createEntityManager();
		em.remove(personne);	
	}

	/**
	 * Methode generique pour recupérer la liste des personnes
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> getList() {
		EntityManager em = emf.createEntityManager();
		String req = "Select p FROM Personne p";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	/**
	 * Methode generique pour récupérer une personne
	 */
	@Override
	public Personne getPersonne(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Personne.class, id);
	}

	/**
	 * Methode générique pour mettre à jour une personne
	 */
	@Override
	public void updatePersonne(T personne) {
		EntityManager em = emf.createEntityManager();
		em.merge(personne);		
	}

}
