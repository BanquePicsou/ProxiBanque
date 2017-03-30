package fr.adaming.service;

import org.springframework.security.core.Authentication;

import fr.adaming.entities.Personne;

/**
 * Cette interface communique entre controler et dao pour récupérer l'user et le mettre en session après authentification
 * @author inti0302
 *
 */
public interface ILogService {

	public Personne isExist(Authentication user);
}
