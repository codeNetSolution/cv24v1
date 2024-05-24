package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@Entity
@Table(name = "diplomes_group")
@XmlAccessorType(XmlAccessType.FIELD)
public class Diplomes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "diplomes", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @XmlElement(name = "diplome-niveau", namespace = "http://univ.fr/cv24")
    private List<Diplome> diplome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Diplome> getDiplomes() {
        return diplome;
    }

    public void setDiplomes(List<Diplome> diplomes) {
        this.diplome = diplomes;
    }
}
