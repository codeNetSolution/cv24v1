package fr.univrouen.cv24.dto;

import fr.univrouen.cv24.model.ObjectifStatut;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ObjectifStatutDTO {

    @XmlElement(name = "initule")
    private String initule;

    public ObjectifStatutDTO(ObjectifStatut objectifStatut) {
        this.initule = objectifStatut.getInitule();
    }


    public void setInitule(String initule){
        this.initule = initule;
    }

    public String getInitule(){
        return initule;
    }
}