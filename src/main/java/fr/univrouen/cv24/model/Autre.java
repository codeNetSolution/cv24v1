package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Autre {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "divers_id")
    @XmlElement(name = "divers", namespace = "http://univ.fr/cv24")
    private Divers divers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDivers(Divers divers) {
        this.divers = divers;
    }

    public Divers getDivers(){
        return divers;
    }
}
