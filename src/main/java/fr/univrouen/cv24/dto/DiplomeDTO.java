package fr.univrouen.cv24.dto;

import fr.univrouen.cv24.model.Diplome;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DiplomeDTO {

    @XmlElement(name = "intitule")
    private String intitule;

    @XmlElement(name = "niveau")
    private int niveau;

    public DiplomeDTO(Diplome diplome) {
        this.intitule = diplome.getIntitule();
        this.niveau = diplome.getNiveau();
    }

    public void setIntitule(String intitule){
        this.intitule = intitule;
    }

    public void setNiveau(int niveau){
        this.niveau = niveau;
    }

    public String getIntitule(){
        return intitule;
    }

    public int getNiveau(){
        return niveau;
    }
}