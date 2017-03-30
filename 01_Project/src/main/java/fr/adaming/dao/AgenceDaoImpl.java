package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
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



	@PersistenceContext
	EntityManager em;
						

	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * Ajout d'une agence en bdd
	 * 
	 * @param agence
	 */
	@Override
	public void addAgence(Agence agence) {
		em.persist(agence);

	}

	/**
	 * Suppresion d'une agence en bdd
	 * 
	 * @param agence
	 */
	@Override
	public void deleteAgence(Agence agence) {
		System.out.println("j'arrive � la m�thode de suppression d'agence DAO !");
		em.remove(agence);

	}

	/**
	 * Cr�ation d'une liste d'agence compl�te � partir de la table agence.
	 * 
	 * @return liste de r�sultats
	 */
	@Override
	public List<Agence> getList() {
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
		System.out.println("Je suis avant le get Agence");
		return em.find(Agence.class, id);
		System.out.println("Je suis apr�s le get Agence");
	}

	/**
	 * Mise � jour d'une agence en bdd
	 * 
	 * @param agence
	 */
	@Override
	public void updateAgence(Agence agence) {
		em.merge(agence);
	}

}
