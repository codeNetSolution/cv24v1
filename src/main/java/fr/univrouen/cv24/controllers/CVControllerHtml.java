package fr.univrouen.cv24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.univrouen.cv24.model.TestCV;
import fr.univrouen.cv24.Repository.CVRepository;

import java.util.Optional;

@Controller

public class CVControllerHtml {

    @Autowired
    private CVRepository cvRepository;

    @GetMapping
    public String getCVById(@RequestParam(value = "id") Long id, Model model) {
        Optional<TestCV> cv = cvRepository.findById(id);
        if (cv.isPresent()) {
            model.addAttribute("cv", cv.get());
            return "cv_detail";  // Nom du fichier template HTML pour les détails du CV
        } else {
            model.addAttribute("id", id);
            model.addAttribute("status", "ERROR");
            return "cv_error";  // Nom du fichier template HTML pour l'erreur
        }
    }
}
