package fr.univrouen.cv24.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Profs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "profs", cascade = CascadeType.ALL)
    @XmlElement(namespace = "http://univ.fr/cv24")
    private List<Profession> prof;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Profession> getProf() {
        return prof;
    }

    public void setProf(List<Profession> prof) {
        this.prof = prof;
    }
}
