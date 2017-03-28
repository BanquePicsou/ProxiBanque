package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entities.Personne;

@Component
@Transactional
public class PersonneDaoImpl<T extends Personne> implements IPersonneDao<T> {

	@PersistenceContext
	EntityManager em;
						
	@Override
	public void addPersonne(T personne) {
		em.persist(personne);		
	}

	@Override
	public void deletePersonne(T personne) {
		em.remove(personne);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> getList() {
		String req = "Select p FROM Personne p";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public Personne getPersonne(int id) {
		return em.find(Personne.class, id);
	}

	@Override
	public void updatePersonne(T personne) {
		em.merge(personne);		
	}

}
