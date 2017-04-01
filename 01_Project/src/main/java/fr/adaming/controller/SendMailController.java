package fr.adaming.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/email")
public class SendMailController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String newEmail(ModelMap model){
		return "sendEmail";
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String sendEmail(ModelMap model, String destinataire, String objet, String corpsMessage) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("proxy.banque@gmail.com", "proxybanque");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("no-reply@proxy.banque.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
			message.setSubject(objet);
			message.setText(corpsMessage);

			Transport.send(message);

			System.out.println("Done");
			model.addAttribute("resultEmail","Votre message a bien été envoyé");

		} catch (MessagingException e) {
			model.addAttribute("resultEmail","Erreur : Votre message n'a pas pu être envoyé");
			e.printStackTrace();
		}

		return "sendedEmail";
	}
}
