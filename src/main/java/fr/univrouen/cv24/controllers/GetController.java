package fr.univrouen.cv24.controllers;


import fr.univrouen.cv24.dto.CvListDTO;
import fr.univrouen.cv24.dto.TestCVDTO;
import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.model.CV.CVList;
import fr.univrouen.cv24.services.CVService;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import fr.univrouen.cv24.Repository.*;

import fr.univrouen.cv24.util.Fichier;
import jakarta.xml.bind.JAXBContext;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
public class GetController {
	
	@Autowired
    private CVRepository cvRepository;

	@Autowired
	private CVService cvService;
	
	
//	 @GetMapping(value = "/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
//	 public String getListCVinXML() {
//		 try {
//			 List<TestCV> cvs = cvRepository.findAll();
//
//			 List<Cv24> cv24s = new ArrayList<>();
//
//			 for (TestCV cv : cvs) {
//				 List<Diplome> diplomes = cvService.getAllDiplomesByIdRecent(cv.getId());
//				 ObjectifStatut objectifStatut = cvService.getObjectifsStatutById(cv.getId());
//				 cv24s.add(new Cv24(cv, diplomes, objectifStatut));
//			 }
//
//			 JAXBContext jaxbContext = JAXBContext.newInstance(Cv24.class);
//			 Marshaller marshaller = jaxbContext.createMarshaller();
//			 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			 StringWriter writer = new StringWriter();
//			 marshaller.marshal(cv24s, writer);
//
//			 return writer.toString();
//		 } catch (Exception e) {
//			 return "<error>Erreur lors de la génération du XML</error>";
//		 }
//	 }
	
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

	@GetMapping(value = "/cv24/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<CvListDTO> showCVsXML() {
		List<TestCV> cvs = cvService.getAllCVs();
		List<TestCVDTO> cvDTOs = cvs.stream()
				.map(TestCVDTO::new)
				.collect(Collectors.toList());
		CvListDTO cvListDTO = new CvListDTO(cvDTOs);
		return ResponseEntity.ok(cvListDTO);
	}

	@GetMapping(value = "/cv24/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<?> cvXMLId(@RequestParam Long id) {
		List<TestCV> cvs;
		try {
			cvs = cvService.getTestCVById(id);
		} catch (NoSuchElementException e) {
			ErrorResponse errorResponse = new ErrorResponse(id, "Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
		List<TestCVDTO> cvDTOs = cvs.stream()
				.map(TestCVDTO::new)
				.collect(Collectors.toList());
		CvListDTO cvListDTO = new CvListDTO(cvDTOs);
		return ResponseEntity.ok(cvListDTO);
	}


}