package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entities.Agence;

/**
 * Classe de gestion des agences
 * 
 * @author inti0292
 *
 */
@Repository
@Transactional
public class AgenceDaoImpl implements IAgenceDao {

	/**
	 * Attribut en Autowired utilis� pour la connection dans la base de donn�e
	 * et la cr�ation d'un entity manager
	 */
	@Autowired
	EntityManagerFactory emf;

	/**
	 * Setter de l'entity manager factory pour la cr�ation des Entity manager
	 * dans les m�thodes
	 * 
	 * @param emf
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/**
	 * Ajout d'une agence en bdd
	 * 
	 * @param agence
	 */
	@Override
	public void addAgence(Agence agence) {
		EntityManager em = emf.createEntityManager();
		em.persist(agence);

	}

	/**
	 * Suppresion d'une agence en bdd
	 * 
	 * @param agence
	 */
	@Override
	public void deleteAgence(Agence agence) {
		EntityManager em = emf.createEntityManager();
		em.remove(agence);

	}

	/**
	 * Cr�ation d'une liste d'agence compl�te � partir de la table agence.
	 * 
	 * @return liste de r�sultats
	 */
	@Override
	public List<Agence> getList() {
		EntityManager em = emf.createEntityManager();
		String req = "Select a FROM Agence a";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	/**
	 * Recherche d'un agence par son id unique en bdd
	 * 
	 * @param id
	 * @return l'objet agence dont l'id = id en param�tre
	 */
	@Override
	public Agence getAgence(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Agence.class, id);
	}

	/**
	 * Mise � jour d'une agence en bdd
	 * 
	 * @param agence
	 */
	@Override
	public void updateAgence(Agence agence) {
		EntityManager em = emf.createEntityManager();
		em.merge(agence);
	}

}
