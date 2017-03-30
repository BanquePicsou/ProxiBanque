package fr.adaming.dao;

import org.springframework.security.core.Authentication;

import fr.adaming.entities.Personne;

public interface ILogDao {

	public Personne isExist(Authentication user);
	
	
	
}
