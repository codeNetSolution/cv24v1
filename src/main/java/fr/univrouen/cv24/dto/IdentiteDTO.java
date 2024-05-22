package fr.univrouen.cv24.dto;

import fr.univrouen.cv24.model.Identite;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class IdentiteDTO {

    @XmlElement(name="genre")
    private String genre;

    @XmlElement(name = "nom")
    private String nom;

    @XmlElement(name = "prenom")
    private String prenom;

    public IdentiteDTO(Identite identite) {
        this.genre = identite.getGenre();
        this.nom = identite.getNom();
        this.prenom = identite.getPrenom();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }

    public void setPrenom(String prenom) {
        this.prenom= prenom;
    }
    public String getPrenom(){
        return prenom;
    }

    public void setGenre(String genre){
        this.genre= genre;
    }
    public String getGenre(){
        return genre;
    }
}
