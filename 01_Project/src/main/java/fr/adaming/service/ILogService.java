package fr.adaming.service;

import org.springframework.security.core.Authentication;

import fr.adaming.entities.Personne;

/**
 * Cette interface communique entre controler et dao pour r�cup�rer l'user et le mettre en session apr�s authentification
 * @author inti0302
 *
 */
public interface ILogService {

	public Personne isExist(Authentication user);
}
