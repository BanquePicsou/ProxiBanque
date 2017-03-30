package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entities.Personne;

@Repository
@Transactional
public class LogDaoImpl implements ILogDao {

	@PersistenceContext
	EntityManager em;
						

	public void setEm(EntityManager em) {
		this.em = em;
	}
	@Override
	public Personne isExist(Authentication user) {
		String role = user.getAuthorities().toString();
		String pRole = null;
		switch (role) {
		case "[ROLE_ADMIN]":
			pRole = "ROLE_ADMIN";
			break;
		case "[ROLE_CONSEILLER]":
			pRole = "ROLE_CONSEILLER";
			break;
		case "[ROLE_GERANT]":
			pRole = "ROLE_GERANT";	
		}
		String req = "Select p From Personne p Where nom=:pUsername and role=:pRo";
		Query query = em.createQuery(req);
		query.setParameter("pUsername", user.getName());
		query.setParameter("pRo", pRole);
		Personne p = (Personne) query.getSingleResult();
		return p;
	}

	
	
	
}
