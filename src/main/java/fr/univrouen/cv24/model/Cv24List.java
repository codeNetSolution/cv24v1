package fr.univrouen.cv24.model;

import fr.univrouen.cv24.model.Cv24;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "cv24s")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cv24List {
    @XmlElement(name = "cv24")
    private List<Cv24> list;

    public Cv24List() {}

    public Cv24List(List<Cv24> list) {
        this.list = list;
    }

    // Ensure getters and setters are present and correct
}
