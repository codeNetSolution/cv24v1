package fr.univrouen.cv24.controllers;

import fr.univrouen.cv24.Repository.DiplomesRepository;
import fr.univrouen.cv24.dto.CvListDTO;
import fr.univrouen.cv24.dto.DiplomeDTO;
import fr.univrouen.cv24.dto.ObjectifStatutDTO;
import fr.univrouen.cv24.dto.TestCVDTO;
import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.services.CVService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
public class IndexController {

	@Autowired
	private CVService cvService;

	@Autowired
	private DiplomesRepository diplomesRepository;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("projectName","CV 2024");
		model.addAttribute("projectVersion","1.0");
		model.addAttribute("teamMembers", new String[]{
				"Abdelkrim SAIDOUN"
		});
		model.addAttribute("universityLogo", "/img/logo.png");
		
		return "home";
	}
	
	@GetMapping("/help")
	public String showHelp() {
		return "help";
	}

	@GetMapping("/cv24/resume")
	public String showCVs(Model model) {
		List<TestCV> cvs = cvService.getAllCVs();
		List<Cv24> cv24s = new ArrayList<>();

		List<TestCVDTO> cvDTOs = cvs.stream()
				.map(TestCVDTO::new)
				.collect(Collectors.toList());

		for (TestCVDTO cv : cvDTOs) {
			List<DiplomeDTO> diplomes = cvService.getAllDiplomeHighLevel(cv.getDiplomes());
			ObjectifStatutDTO objectifStatut = cv.getObjectifStatut();
			cv24s.add(new Cv24(cv, diplomes, objectifStatut));
		}
		model.addAttribute("cv24s", cv24s);
		return "cvs";
	}

	@GetMapping("/cv24/html")
	public String showCVById(Model model, @RequestParam Long id) {
		List<TestCV> cvs;
		try {
			cvs = cvService.getTestCVById(id);
		} catch (NoSuchElementException e) {
			model.addAttribute("id", id);
			model.addAttribute("status", "ERROR");
			return "cv_error";
		}
		List<Cv24> cv24s = new ArrayList<>();

		List<TestCVDTO> cvDTOs = cvs.stream()
				.map(TestCVDTO::new)
				.toList();

		for (TestCVDTO cv : cvDTOs) {
			List<DiplomeDTO> diplomes = cvService.getAllDiplomeHighLevel(cv.getDiplomes());
			ObjectifStatutDTO objectifStatut = cv.getObjectifStatut();
			cv24s.add(new Cv24(cv, diplomes, objectifStatut));
		}

		model.addAttribute("cv24s", cv24s);
		return "cvs";
	}



}
