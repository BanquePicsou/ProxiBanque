package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.entities.Agence;

/**
 * @author inti0292
 *
 */
@Service
public class AgenceServiceImpl implements IAgenceService {

	/**
	 * Liaison faible d'agenceDao
	 */
	@Autowired
	IAgenceDao agenceDao;

	/**
	 * Setter d'agence Dao
	 * @param agenceDao
	 */
	public void setAgenceDao(IAgenceDao agenceDao) {
		this.agenceDao = agenceDao;
	}

	/**
	 * Ajout d'une agence
	 * 
	 * @param agence
	 */
	@Override
	public void addAgence(Agence agence) {
		agenceDao.addAgence(agence);
	}

	/**
	 * Suppresion d'une agence
	 * 
	 * @param agence
	 */
	@Override
	public void deleteAgence(Agence agence) {
		agenceDao.deleteAgence(agence);
	}

	/**
	 * Création d'une liste d'agence complète à partir de la dao
	 * 
	 * @return liste de résultats
	 */
	@Override
	public List<Agence> getList() {
		return agenceDao.getList();
	}

	/**
	 * Recherche d'un agence par son id unique en dao
	 * 
	 * @param id
	 * @return l'objet agence dont l'id = id en paramètre
	 */
	@Override
	public Agence getAgence(int id) {
		return agenceDao.getAgence(id);
	}

	/**
	 * Mise à jour d'une agence via dao
	 * 
	 * @param agence
	 */
	@Override
	public void updateAgence(Agence agence) {
		agenceDao.updateAgence(agence);

	}

}
