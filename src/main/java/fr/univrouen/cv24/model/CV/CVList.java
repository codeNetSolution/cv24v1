package fr.univrouen.cv24.model.CV;

import fr.univrouen.cv24.model.TestCV;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CVs")
public class CVList {

    private List<TestCV> cvs;

    public CVList() { }

    public CVList(List<TestCV> cvs) {
        this.cvs = cvs;
    }

    @XmlElement(name = "CV")
    public List<TestCV> getCvs() {
        return cvs;
    }

    public void setCvs(List<TestCV> cvs) {
        this.cvs = cvs;
    }
}
