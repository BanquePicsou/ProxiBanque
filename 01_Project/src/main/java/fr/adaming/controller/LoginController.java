package fr.adaming.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.entities.Personne;
import fr.adaming.service.ILogService;

@Controller
public class LoginController {
	
	
	@Autowired
	ILogService log;
	
	
	@RequestMapping("/login")
	public String pageLogin(){
		return "login";
	}
	
	@RequestMapping("/site/index")
	public String goToIndex(HttpSession session){
		//on récupérer l'user de la session
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		//appel de la methode isExist -> forcement car connecté
		Personne p = log.isExist(auth);
		//on fout l'utilisateur dans l'objet HTTPSession :)
		session.setAttribute("users", p);
		//ENSUITE, on retourne vers la page dediée en fonction du role de l'user :)
		switch (p.getRole()) {
		case "ROLE_ADMIN":
			return "AccueilBigBoss";
		case "ROLE_CONSEILLER":
			return "AccueilConseiller";
		case "ROLE_GERANT":
			return "AccueilGerant";
		default :
			return null;
		}
		
		
	}

}
