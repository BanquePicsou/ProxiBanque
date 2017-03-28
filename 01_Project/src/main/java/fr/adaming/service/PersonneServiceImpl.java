package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.IPersonneDao;
import fr.adaming.entities.Client;
import fr.adaming.entities.Conseiller;
import fr.adaming.entities.Gerant;
import fr.adaming.entities.Personne;

public class PersonneServiceImpl implements IPersonneService {

	@SuppressWarnings("rawtypes")
	@Autowired
	IPersonneDao personneDao;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void addClient(Client client) {
		client.setRole("client");
		personneDao.addPersonne(client);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addGerant(Gerant gerant) {
		gerant.setRole("gerant");
		personneDao.addPersonne(gerant);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addConseiller(Conseiller conseiller) {
		conseiller.setRole("conseiller");
		personneDao.addPersonne(conseiller);
		
	}

	@Override
	public void deletePersonne(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personne getPersonne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> getAllPersonne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gerant> getAllGerant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conseiller> getAllConseiller() {
		@SuppressWarnings("unchecked")
		List<Personne> liste = personneDao.getList();
		List<Conseiller> listeRetour = new ArrayList<>();
		for(Personne p:liste){
			if(p.getRole().equals("conseiller"));
			listeRetour.add((Conseiller) p);
		}
		return listeRetour;
	}

	@Override
	public List<Conseiller> getConseillersByGerant(Gerant gerant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getClientsByConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return null;
	}

}
