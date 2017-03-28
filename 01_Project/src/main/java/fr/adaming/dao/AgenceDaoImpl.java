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
 * @author inti0292
 *
 */
@Repository
@Transactional
public class AgenceDaoImpl implements IAgenceDao {

	/**
	 * 
	 */
	@Autowired
	EntityManagerFactory emf;

	/**
	 * @param emf
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IAgenceDao#addAgence(fr.adaming.entities.Agence)
	 */
	@Override
	public void addAgence(Agence agence) {
		EntityManager em = emf.createEntityManager();
		em.persist(agence);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IAgenceDao#deleteAgence(fr.adaming.entities.Agence)
	 */
	@Override
	public void deleteAgence(Agence agence) {
		EntityManager em = emf.createEntityManager();
		em.remove(agence);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IAgenceDao#getList()
	 */
	@Override
	public List<Agence> getList() {
		EntityManager em = emf.createEntityManager();
		String req = "Select a FROM Agence a";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IAgenceDao#getAgence(int)
	 */
	@Override
	public Agence getAgence(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Agence.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IAgenceDao#updateAgence(fr.adaming.entities.Agence)
	 */
	@Override
	public void updateAgence(Agence agence) {
		EntityManager em = emf.createEntityManager();
		em.merge(agence);
	}

}
