package fr.adaming.controller;

import java.awt.Color;
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

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import fr.adaming.entities.Client;
import fr.adaming.entities.Compte;
import fr.adaming.entities.CompteCourant;
import fr.adaming.entities.CompteEpargne;
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

						document.addTitle("Relev� d'indentit� Banquaire - " + client.getNom());

						document.open();

						Paragraph titre = new Paragraph("Relev� d'indentit� Banquaire");
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

						Paragraph coordonneesCl = new Paragraph("Coordon�es client\n");
						coordonneesCl.add(nomCl);
						coordonneesCl.add(adresseCl);

						document.add(coordonneesCl);

						Phrase numCpt = new Phrase("Num�ro de compte : " + cc.getNumero() + "\n");

						Paragraph infosCpt = new Paragraph("\n\n\nInformations du compte\n");
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
			model.addAttribute("error", "Le client n'existe pas ou ne poss�de pas de compte courant");
		}

		return "Conseiller/client/affichePdf";
	}

	@RequestMapping(value = "/releveCpt/{id}", method = RequestMethod.GET)
	public String generateReleveCpt(ModelMap model, @PathVariable("id") int idPersonne) {

		Client client = (Client) personneService.getPersonne(idPersonne);
		CompteCourant cc = null;
		CompteEpargne ce = null;
		String pathGetPdf = null;

		if (client != null) {
			if (client.getListeCompte() != null) {

				for (Compte cpt : client.getListeCompte()) {
					if (cpt.getTypecompte().equals("courant")) {
						cc = (CompteCourant) cpt;
					}
					if (cpt.getTypecompte().equals("epargne")) {
						ce = (CompteEpargne) cpt;
					}
				}

				if (cc != null || ce != null) {
					URL url = this.getClass().getResource("/");

					String path = "";
					try {
						path = URLDecoder.decode(url.getFile(), "UTF-8");
						path = path.replace("WEB-INF/classes/", "Releves/");

						if (path.startsWith("/")) {
							path = path.replaceFirst("/", "");

						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

					String pathPdf = path + "/releveCpt" + client.getNom() + ".pdf";

					Document document = new Document(PageSize.A4);
					try {

						PdfWriter.getInstance(document, new FileOutputStream(pathPdf));

						document.addTitle("Relev� de comptes - " + client.getNom());

						document.open();

						Paragraph titre = new Paragraph("Relev� de comptes");
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

						Paragraph coordonneesCl = new Paragraph("Coordon�es client\n");
						coordonneesCl.add(nomCl);
						coordonneesCl.add(adresseCl);

						document.add(coordonneesCl);

						Table tableauComptes = new Table(5);
						tableauComptes.setPadding(2);
						tableauComptes.setDefaultCellBorderColor(Color.GRAY);
						tableauComptes.setCellpadding(2);
						new Font(Font.HELVETICA, 11, Font.BOLD);
						Cell cell1 = new Cell("Type de compte");
						cell1.setHeader(true);
						tableauComptes.addCell(cell1);
						tableauComptes.addCell("Num�ro de compte");
						tableauComptes.addCell("D�couvert (�)");
						tableauComptes.addCell("Taux d'inter�ts (%)");
						tableauComptes.addCell("Solde (�)");

						if (cc != null) {
							tableauComptes.addCell(cc.getTypecompte());
							tableauComptes.addCell(String.valueOf(cc.getNumero()));
							tableauComptes.addCell(String.valueOf(cc.getDecouvert()));
							tableauComptes.addCell("");
							tableauComptes.addCell(String.valueOf(cc.getSolde()));
						}
						if (ce != null) {
							tableauComptes.addCell(ce.getTypecompte());
							tableauComptes.addCell(String.valueOf(ce.getNumero()));
							tableauComptes.addCell("");
							tableauComptes.addCell(String.valueOf(ce.getTaux()));
							tableauComptes.addCell(String.valueOf(ce.getSolde()));
						}
						
						Paragraph comptes = new Paragraph("\n\n\nR�capitulatif de vos comptes",
								new Font(Font.TIMES_ROMAN, 15, Font.BOLD));

						comptes.add(tableauComptes);

						document.add(comptes);

					} catch (DocumentException de) {
						de.printStackTrace();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
					document.close();

					pathGetPdf = "/01_Project/Releves/releveCpt" + client.getNom() + ".pdf";
				}
			}
		}
		model.addAttribute("lienPdf", pathGetPdf);
		if (pathGetPdf == null) {
			model.addAttribute("error", "Le client n'existe pas ou ne poss�de pas de comptes");
		}

		return "Conseiller/client/affichePdf";
	}

}
