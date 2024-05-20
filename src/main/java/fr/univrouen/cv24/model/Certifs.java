package fr.univrouen.cv24.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Certifs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "certifs", cascade = CascadeType.ALL)
    @XmlElement(name = "certif", namespace = "http://univ.fr/cv24")
    private List<Certification> certif;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Certification> getCertif() {
        return certif;
    }

    public void setCertif(List<Certification> certif) {
        this.certif = certif;
    }
}
