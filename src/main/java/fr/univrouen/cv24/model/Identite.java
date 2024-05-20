package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "cvs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Identite {


    @XmlElement(name = "genre",namespace = "http://univ.fr/cv24")
    String genre;

    @XmlElement(name = "firstame",namespace = "http://univ.fr/cv24")
    String prenom;

    @XmlElement(name = "lastname",namespace = "http://univ.fr/cv24")
    String nom;

    @XmlElement(name = "tel",namespace = "http://univ.fr/cv24")
    String telephone;

    @XmlElement(name = "mail",namespace = "http://univ.fr/cv24")
    private String email;

    @OneToOne(mappedBy = "identite")
    private TestCV testCV;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }
    public String getTelephone() {
        return this.telephone;
    }

    public String getEmail() {
        return this.email;
    }
}