package fr.univrouen.cv24.controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import fr.univrouen.cv24.util.Fichier;
import fr.univrouen.cv24.model.TestCV;

@RestController
public class GetController {
	@GetMapping("/resume")
	public String getListCVinXML() {
		return "Envoi de la liste des CV";
	}
	@GetMapping("/cvid")
	public String getCVinXML(
			@RequestParam(value = "texte") String texte) {
		return ("Détail du CV n°" + texte);
	}
	@GetMapping("/test")
	public String getTextTest(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "titre") String titre) {
		
		return ("id = " + id + "<br>" + "titre = " + titre);
	}
	
	@GetMapping("/testfic")
	public String testFichierXML() {
	    Fichier fichier = new Fichier();
	    return fichier.loadFileXML("smallCV.xml");
	}
	
	@RequestMapping(value="/testxml", produces=MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody TestCV getXML() {
		TestCV cv = new TestCV("HAMILTON", "MARGARET", "1969/07/21", "Appollo11@nasa.us");
		
		return cv;
	}
}