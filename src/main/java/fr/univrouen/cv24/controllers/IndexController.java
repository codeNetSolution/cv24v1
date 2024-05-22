package fr.univrouen.cv24.controllers;

import fr.univrouen.cv24.Repository.DiplomesRepository;
import fr.univrouen.cv24.model.Diplome;
import fr.univrouen.cv24.model.ObjectifStatut;
import fr.univrouen.cv24.model.TestCV;
import fr.univrouen.cv24.model.cv24;
import fr.univrouen.cv24.services.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
		List<cv24> cv24s = new ArrayList<>();

		for (TestCV cv : cvs) {
			List<Diplome> diplomes = cvService.getAllDiplomesByIdRecent(cv.getId());
			ObjectifStatut objectifStatut = cvService.getObjectifsStatutById(cv.getId());
			cv24s.add(new cv24(cv, diplomes, objectifStatut));
		}
		model.addAttribute("cv24s", cv24s);

		if (cvs == null || cvs.isEmpty()) {
			System.out.println("No CVs found.");
		} else {
			for (TestCV cv : cvs) {
				List<Diplome> ListTest = cvService.getAllDiplomesById(cv.getId());
				System.out.println("Diplome " + ListTest.isEmpty());
				if (cv.getDiplomes() != null) {
					for (Diplome diplome : ListTest) {
						System.out.println("Diplome est non VIDE");
						System.out.println("Diplome intitulé : " + diplome.getIntitule());
					}
				} else {
					System.out.println("Diplome VIDE");
				}
			}
		}
		return "cvs";
	}

}
