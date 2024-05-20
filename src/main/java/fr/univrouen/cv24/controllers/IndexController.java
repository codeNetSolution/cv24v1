package fr.univrouen.cv24.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
	
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
}
