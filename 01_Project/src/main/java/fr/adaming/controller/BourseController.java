package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteEpargne;
import fr.adaming.service.IBourseService;
import fr.adaming.ws.QuoteData;

/**
 * controlleur pour récupérer les informations de la bourse avec comme uri
 * global : /bourse
 * 
 * @author inti0242
 *
 */
@Controller
@RequestMapping("/bourse")
public class BourseController {

	/**
	 * bourseService utilisé avec l'injection de dependance de spring utilsé
	 * pour l'appel des methodes de la classe service
	 */
	@Autowired
	private IBourseService bourseService;

	public void setBourseService(IBourseService bourseService) {
		this.bourseService = bourseService;
	}
	
	/**
	 * Methode qui permet l'affichage des données de la bourse
	 * 
	 * @return String : page d'affichage de la bourse
	 */
	@RequestMapping(value = "/bourse", method = RequestMethod.GET)
	public String getBourseInfo(ModelMap model, String indice) {
		
		String[][] listeIndices = {{"A","Agilent Technologies, Inc."},
				{"AA","Alcoa Corporation"},
				{"AAC","AAC Holdings, Inc."},
				{"AAMC","Altisource Asset Management Corp Com"},
				{"AAN","Aaron's, Inc."},
				{"AAP","Advance Auto Parts Inc Advance Auto Parts Inc W/I"},
				{"AAU","Almaden Minerals, Ltd."},
				{"AAV","Advantage Oil & Gas Ltd Ordinary Shares"},
				{"AB","AllianceBernstein Holding L.P. Units"},
				{"ABB","ABB Ltd"},
				{"B","Barnes Group, Inc."},
				{"BA","Boeing Company (The)"},
				{"BAA","BANRO CORPORATION Ordinary Shares"},
				{"BABA","Alibaba Group Holding Limited American Depositary Shares each representing one Ordinary share"},
				{"BAC","Bank of America Corporation"},
				{"BAF","BlackRock Municipal Income Investment Quality Trust"},
				{"BAH","Booz Allen Hamilton Holding Corporation"},
				{"BAK","Braskem SA ADR"},
				{"BAM","Brookfield Asset Management Inc."},
				{"BANC","Banc of California, Inc."},
				{"C","Citigroup, Inc."},
				{"CAA","CalAtlantic Group, Inc."},
				{"CAB","Cabela's Inc Class A"},
				{"CABO","Cable One, Inc."},
				{"CACI","CACI International, Inc. Class A"},
				{"CAE","CAE Inc. Ordinary Shares"},
				{"CAF","Morgan Stanley China A Share Fund Inc."},
				{"CAG","ConAgra Brands, Inc."},
				{"CAH","Cardinal Health, Inc."},
				{"CAI","CAI International, Inc."},
				{"D","Dominion Resources, Inc."},
				{"DAC","Danaos Corporation"},
				{"DAL","Delta Air Lines, Inc."},
				{"DAN","Dana Incorporated"},
				{"DAR","Darling Ingredients Inc."},
				{"DATA","Tableau Software, Inc. Class A"},
				{"DB","Deutsche Bank AG"},
				{"DB.RT","Deutsche Bank Aktiengesellschaft"},
				{"DBD","Diebold Nixdorf Incorporated"},
				{"DBL","DoubleLine Opportunistic Credit Fund of Beneficial Interest"},
				{"E","ENI S.p.A."},
				{"EAB","Entergy Arkansas, Inc. First Mortgage Bonds, 4.90% Series Due December 1, 2052"},
				{"EAD","Wells Fargo Income Opportunities Fund"},
				{"EAE","Entergy Arkansas, Inc. First Mortgage Bonds, 4.75% Series due June 1, 2063"},
				{"EAI","Entergy Arkansas, Inc. First Mortgage Bonds, 4.875% Series Due September 1, 2066"},
				{"EAT","Brinker International, Inc."},
				{"EBF","Ennis, Inc."},
				{"EBS","Emergent Biosolutions, Inc."},
				{"EC","Ecopetrol S.A. American Depositary Shares"},
				{"ECA","Encana Corporation"},
				{"F","Ford Motor Company"},
				{"FAC","First Acceptance Corporation"},
				{"FAF","First American Corporation (New)"},
				{"FAM","First Trust/Aberdeen Global Opportunity Income Fund First Trust/Aberdeen Global Opportunity Income Fund of Beneficial Interest"},
				{"FAX","Aberdeen Asia-Pacific Income Fund Inc"},
				{"FBC","Flagstar Bancorp, Inc."},
				{"FBHS","Fortune Brands Home & Security, Inc."},
				{"FBK","FB Financial Corporation"},
				{"FBM","Foundation Building Materials, Inc."},
				{"FBP","First BanCorp. New"}}; 

		if(indice == null){
			indice = listeIndices[0][0];
		}
		QuoteData qd = bourseService.getQuote(indice, "0");
		model.addAttribute("listeIndices",listeIndices);
		model.addAttribute("nom",qd.getCompanyName());
		model.addAttribute("changePercent",qd.getChangePercent());
		model.addAttribute("dayHigh",qd.getDayHigh());
		model.addAttribute("dayLow",qd.getDayLow());
		model.addAttribute("stockChange",qd.getStockChange());
		model.addAttribute("stockVolume",qd.getStockVolume());
		
		return "Bourse/affichage";

	}

}
