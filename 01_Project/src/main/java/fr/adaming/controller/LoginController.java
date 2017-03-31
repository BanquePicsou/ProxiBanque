package fr.adaming.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.entities.Gerant;
import fr.adaming.entities.Personne;
import fr.adaming.service.ILogService;
import fr.adaming.service.IPersonneService;

@Controller
public class LoginController {
	
	
	@Autowired
	ILogService log;
	
	/**
	 * Attribut utilisé pour l'appel du service
	 * @Autowired pour l'injection de dépendance
	 */
	@Autowired
	IPersonneService personneService;
	
	
	@RequestMapping("/login")
	public String pageLogin(){
		return "login";
	}
	
	@RequestMapping("/site/index")
	public String goToIndex(HttpSession session, ModelMap modelMap){
		//on récupérer l'user de la session
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		//appel de la methode isExist -> forcement car connecté
		Personne p = log.isExist(auth);
		//on fout l'utilisateur dans l'objet HTTPSession :)
		session.setAttribute("users", p);
		//ENSUITE, on retourne vers la page dediée en fonction du role de l'user :)
		switch (p.getRole()) {
		case "ROLE_ADMIN":
			List<Gerant> liste = personneService.getAllGerant();
			modelMap.addAttribute("listeGerant", liste);
			return "BigBoss/listeGerant";
		case "ROLE_CONSEILLER":
			return "AccueilConseiller";
		case "ROLE_GERANT":
			return "AccueilGerant";
		default :
			return null;
		}
		
	}
	
	@RequestMapping(value="/deconnexion")
	public String pageLogout(){
		return "login";
	}

}
