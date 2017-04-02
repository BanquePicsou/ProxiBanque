package fr.adaming.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import fr.adaming.entities.Client;
import fr.adaming.entities.Compte;
import fr.adaming.entities.CompteCourant;
import fr.adaming.service.ICompteServive;
import fr.adaming.service.IPersonneService;

@Controller
@RequestMapping("/pdfGeneration")
public class GeneratePDFController {

	@Autowired
	IPersonneService personneService;

	@Autowired
	ICompteServive compteService;

	public void setPersonneService(IPersonneService personneService) {
		this.personneService = personneService;
	}

	public void setCompteService(ICompteServive compteService) {
		this.compteService = compteService;
	}

	@RequestMapping(value = "/rib/{id}", method = RequestMethod.GET)
	public String generateRIB(ModelMap model, @PathVariable("id") int idPersonne) {

		Client client = (Client) personneService.getPersonne(idPersonne);
		CompteCourant cc = null;
		String pathGetPdf = null;

		if (client != null) {
			if (client.getListeCompte() != null) {

				for (Compte cpt : client.getListeCompte()) {
					if (cpt.getTypecompte().equals("courant")) {
						cc = (CompteCourant) cpt;
					}
				}
				if (cc != null) {
					URL url = this.getClass().getResource("/");

					String path = "";
					try {
						path = URLDecoder.decode(url.getFile(), "UTF-8");
						path = path.replace("WEB-INF/classes/", "RIBs/");

						if (path.startsWith("/")) {
							path = path.replaceFirst("/", "");

						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

					String pathPdf = path + "/rib" + cc.getClient().getNom() + ".pdf";

					Document document = new Document(PageSize.A4);
					try {

						PdfWriter.getInstance(document, new FileOutputStream(pathPdf));

						document.addTitle("Relevé d'indentité Banquaire - " + client.getNom());

						document.open();

						Paragraph titre = new Paragraph("Relevé d'indentité Banquaire");
						titre.setAlignment(Element.ALIGN_CENTER);

						document.add(titre);

						Phrase banque = new Phrase("Banque Picsou\n");
						document.add(banque);

						String pathImage = "";
						try {
							pathImage = URLDecoder.decode(url.getFile(), "UTF-8");
							pathImage = pathImage.replace("WEB-INF/classes/", "resources/");

							if (pathImage.startsWith("/")) {
								pathImage = pathImage.replaceFirst("/", "");
							}
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						Image picsou = Image.getInstance(pathImage + "img/1947-balthazar-picsou-00.png");

						picsou.scalePercent(20);
						document.add(picsou);

						Phrase nomCl = new Phrase(client.getNom() + " " + client.getPrenom() + "\n");
						Phrase adresseCl = new Phrase(client.getAdresse() + "\n");

						Paragraph coordonneesCl = new Paragraph("Coordonées client\n");
						coordonneesCl.add(nomCl);
						coordonneesCl.add(adresseCl);

						document.add(coordonneesCl);

						Phrase numCpt = new Phrase("Numéro de compte : " + cc.getNumero() + "\n");

						Paragraph infosCpt = new Paragraph("Informations du compte\n");
						infosCpt.add(numCpt);

						document.add(infosCpt);

					} catch (DocumentException de) {
						de.printStackTrace();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
					document.close();

					pathGetPdf = "/01_Project/RIBs/rib" + cc.getClient().getNom() + ".pdf";
				}
			}
		}
		model.addAttribute("lienPdf", pathGetPdf);
		if (pathGetPdf == null) {
			model.addAttribute("error", "Le client n'existe pas ou ne possède pas de compte courant");
		}

		return "Conseiller/client/affichePdf";
	}

}
