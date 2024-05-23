package fr.univrouen.cv24.dto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fr.univrouen.cv24.model.Diplome;
import fr.univrouen.cv24.model.TestCV;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "TestCVDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestCVDTO {

    @XmlElement(name = "id")
    private Long id;
    private ObjectifStatutDTO objectifStatut;
    private IdentiteDTO identite;

    private List<DiplomeDTO> diplomes;


    public TestCVDTO(TestCV testCV) {
        this.id = testCV.getId();
        this.objectifStatut = new ObjectifStatutDTO(testCV.getObjectifStatut());
        this.identite = new IdentiteDTO(testCV.getIdentite());

        DiplomeDTO diplomeMax = testCV.getDiplomes().getDiplomes().stream()
                .max(Comparator.comparingInt(Diplome::getNiveau))
                .map(DiplomeDTO::new).orElse(null);

        this.diplomes = new ArrayList<>();
        this.diplomes.add(diplomeMax);
    }

    public TestCVDTO() {}

    public Long getId(){
        return id;
    }

    public IdentiteDTO getIdentite(){
        return identite;
    }

    public ObjectifStatutDTO getObjectifStatut(){
        return objectifStatut;
    }

    public List<DiplomeDTO> getDiplomes() {
        return diplomes;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setObjectifStatut(ObjectifStatutDTO objectifStatut){
        this.objectifStatut = objectifStatut;
    }

    public void setIdentite(IdentiteDTO identite){
        this.identite = identite;
    }

    public void setDiplomes(List<DiplomeDTO> List){
        this.diplomes = List;
    }

}



