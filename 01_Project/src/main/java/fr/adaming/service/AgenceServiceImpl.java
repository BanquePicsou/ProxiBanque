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
	 * 
	 */
	@Autowired
	IAgenceDao agenceDao;

	/**
	 * @param agenceDao
	 */
	public void setAgenceDao(IAgenceDao agenceDao) {
		this.agenceDao = agenceDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.adaming.service.IAgenceService#addAgence(fr.adaming.entities.Agence)
	 */
	@Override
	public void addAgence(Agence agence) {
		agenceDao.addAgence(agence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.service.IAgenceService#deleteAgence(fr.adaming.entities.
	 * Agence)
	 */
	@Override
	public void deleteAgence(Agence agence) {
		agenceDao.deleteAgence(agence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.service.IAgenceService#getList()
	 */
	@Override
	public List<Agence> getList() {
		return agenceDao.getList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.service.IAgenceService#getAgence(int)
	 */
	@Override
	public Agence getAgence(int id) {
		return agenceDao.getAgence(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.service.IAgenceService#updateAgence(fr.adaming.entities.
	 * Agence)
	 */
	@Override
	public void updateAgence(Agence agence) {
		agenceDao.updateAgence(agence);

	}

}
