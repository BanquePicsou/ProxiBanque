package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;


import fr.adaming.entities.Personne;

/**
 * Classe générique Dao pour les personnes(Client, Conseiler, Admin et Gérant)
 * Communique avec la BDD
 * @author inti0302
 *
 * @param <T> t etend personne et toutes ses classes filles
 */
@Repository
public class PersonneDaoImpl<T extends Personne> implements IPersonneDao<T> {

	/**
	 * Cet attribut est utilisé pour la connexion avec la base de donnée 
	 * et la création d'un entity manager
	 */
	@PersistenceContext
	EntityManager em;
						
	/**
	 * Le setter de l'EMF pour le fonctionnement correct de l'autowired
	 * @return
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	

	/**
	 * Methode generique pour ajouter une personne :
	 * @param personne T : peu importe son type, il sera enregistré dans la bdd 
	 * sans perte d'information
	 */
	@Override
	public void addPersonne(T personne) {
		System.out.println("DAO : avant creation entity manager");
		System.out.println("DAO : juste avant le persist ");
		em.persist(personne);
		
	}

	

	/**
	 * Methode generique pour delete une personne
	 * 	@param personne T : peu importe son type, il sera supprimé de la bdd
	 */
	@Override
	public void deletePersonne(T personne) {
		em.remove(personne);	
	}

	/**
	 * Methode generique pour recupérer la liste des personnes
	 * @return la liste intégrale des personne : elle sera ensuite trié 
	 * selon différentes régles de gestion dans les services
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> getList() {
		String req = "Select p FROM Personne p";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	/**
	 * Methode generique pour récupérer une personne :
	 * @return personne selon id; sans perte d'information par rapport à son type
	 * @param id de la personne à chercher
	 */
	@Override
	public Personne getPersonne(int id) {
		return em.find(Personne.class, id);
	}

	/**
	 *@param personne T : peu importe son type, il sera enregistré dans la bdd 
	 * sans perte d'information
	 */
	@Override
	public void updatePersonne(T personne) {
		em.merge(personne);		
	}



}
