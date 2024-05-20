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
public class Langues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "langues", cascade = CascadeType.ALL)
    @XmlElement(namespace = "http://univ.fr/cv24")
    private List<Langue> langue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Langue> getLangue() {
        return langue;
    }

    public void setLangue(List<Langue> langue) {
        this.langue = langue;
    }
}
