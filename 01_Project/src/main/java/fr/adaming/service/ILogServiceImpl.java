package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ILogDao;
import fr.adaming.entities.Personne;

@Service
public class ILogServiceImpl implements ILogService{

	@Autowired
	ILogDao log;
	
	public void setLog(ILogDao log) {
		this.log = log;
	}


	@Override
	public Personne isExist(Authentication user) {
		return log.isExist(user);
	}

}
