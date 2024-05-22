package fr.univrouen.cv24.model;

import fr.univrouen.cv24.dto.DiplomeDTO;
import fr.univrouen.cv24.dto.ObjectifStatutDTO;
import fr.univrouen.cv24.dto.TestCVDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cv24 {

    @XmlElement
    private TestCVDTO cv;

    @XmlElementWrapper(name = "diplomes")
    @XmlElement(name = "diplome")
    private List<DiplomeDTO> diplomes;

    @XmlElement
    private ObjectifStatutDTO objectifStatut;

    public Cv24(TestCVDTO cv, List<DiplomeDTO> diplomes, ObjectifStatutDTO objectifStatut) {
        this.cv = cv;
        this.diplomes = diplomes;
        this.objectifStatut = objectifStatut;
    }

    // Getters and setters
    public TestCVDTO getCv() {
        return cv;
    }

    public void setCv(TestCVDTO cv) {
        this.cv = cv;
    }

    public List<DiplomeDTO> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(List<DiplomeDTO> diplomes) {
        this.diplomes = diplomes;
    }

    public void setObjectifStatut(ObjectifStatutDTO objectifStatut) {
        this.objectifStatut = objectifStatut;
    }
    public ObjectifStatutDTO getObjectifStatut() {
        return objectifStatut;
    }
}
