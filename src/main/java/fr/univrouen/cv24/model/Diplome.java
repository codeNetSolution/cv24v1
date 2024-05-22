package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "diplomes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement(name = "intitule", namespace = "http://univ.fr/cv24")
    private String intitule;

    @XmlElement(name = "niveau", namespace = "http://univ.fr/cv24")
    private int niveau;

    @XmlElement(name = "date", namespace = "http://univ.fr/cv24")
    private String date;

    @XmlElement(name = "institut", namespace = "http://univ.fr/cv24")
    private String institut;


    @ManyToOne
    @JoinColumn(name = "cv_id")
    private TestCV testCV;

    public Long getId() {
        return id;
    }

    @Column(name = "diplomes_id")
    private Long diplomesId;

    @ManyToOne
    @JoinColumn(name = "diplomes_id", insertable = false, updatable = false)
    private Diplomes diplomes;


    @PrePersist
    private void prePersist() {
        if (this.diplomes != null) {
            this.diplomesId = this.diplomes.getId();
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
    }


    public TestCV getTestCV() {
        return testCV;
    }

    public void setTestCV(TestCV testCV) {
        this.testCV = testCV;
    }

    public Long getDiplomesId() {
        return diplomesId;
    }

    public void setDiplomesId(Long diplomesId) {
        this.diplomesId = diplomesId;
    }

    public Diplomes getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(Diplomes diplomes) {
        this.diplomes = diplomes;
    }
}
