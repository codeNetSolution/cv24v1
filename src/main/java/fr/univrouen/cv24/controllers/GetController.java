package fr.univrouen.cv24.controllers;


import fr.univrouen.cv24.model.CV.CVList;
import fr.univrouen.cv24.services.CVService;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import fr.univrouen.cv24.Repository.*;

import fr.univrouen.cv24.util.Fichier;
import fr.univrouen.cv24.model.TestCV;
import jakarta.xml.bind.JAXBContext;

import java.io.StringWriter;
import java.util.List;

@RestController
public class GetController {
	
	@Autowired
    private CVRepository cvRepository;

	@Autowired
	private CVService cvService;
	
	
	 @GetMapping(value = "/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	 public String getListCVinXML() {
		 try {
			 List<TestCV> cvs = cvRepository.findAll();

			 JAXBContext jaxbContext = JAXBContext.newInstance(CVList.class);
			 Marshaller marshaller = jaxbContext.createMarshaller();
			 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			 CVList cvList = new CVList(cvs);
			 StringWriter writer = new StringWriter();
			 marshaller.marshal(cvList, writer);

			 return writer.toString();
		 } catch (Exception e) {
			 return "<error>Erreur lors de la génération du XML</error>";
		 }
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


	@GetMapping("/cv24/resume")
	public String showCVs(Model model) {
		List<TestCV> cvs = cvService.getAllCVs();
		model.addAttribute("cvs", cvs);
		System.out.println("cvs RECEIVED: " + cvs); // Log the raw XML data

		return "cvs"; // Le nom du fichier template sans l'extension .html
	}
	

}