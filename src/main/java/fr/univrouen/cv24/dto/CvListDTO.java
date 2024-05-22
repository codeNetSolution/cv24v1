package fr.univrouen.cv24.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlRootElement(name = "cvList",namespace = "http://univ.fr/cv24")
@XmlAccessorType(XmlAccessType.FIELD)
public class CvListDTO {
    @XmlElement(name = "cv")
    private List<TestCVDTO> cvs;

    public CvListDTO() {
    }

    public CvListDTO(List<TestCVDTO> cvs) {
        this.cvs = cvs;
    }

    public List<TestCVDTO> getCvs() {
        return cvs;
    }

    public void setCvs(List<TestCVDTO> cvs) {
        this.cvs = cvs;
    }
}
