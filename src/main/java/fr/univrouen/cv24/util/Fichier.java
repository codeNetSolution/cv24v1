package fr.univrouen.cv24.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.DefaultResourceLoader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Fichier {
    
    public String loadFileXML(String path) {
        Resource resource = new DefaultResourceLoader().getResource("classpath:xml/smallCV.xml");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception e) {
            return "Erreur lors de la lecture du fichier : " + e.getMessage();
        }
    }
}
