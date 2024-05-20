package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "langues")
@XmlAccessorType(XmlAccessType.FIELD)
public class Langue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement(name = "lang", namespace = "http://univ.fr/cv24")
    private String lang;

    @XmlElement(name = "cert", namespace = "http://univ.fr/cv24")
    private String cert;

    @XmlElement(name = "nivs", namespace = "http://univ.fr/cv24")
    private int nivs; // Score TOEIC

    @XmlElement(name = "nivi", namespace = "http://univ.fr/cv24")
    private String nivi; // Niveau CLES

    @ManyToOne
    @JoinColumn(name = "langues_id")
    private Langues langues;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private TestCV testCV;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public int getNivs() {
        return nivs;
    }

    public void setNivs(int nivs) {
        this.nivs = nivs;
    }

    public String getNivi() {
        return nivi;
    }

    public void setNivi(String nivi) {
        this.nivi = nivi;
    }

    public Langues getLangues() {
        return langues;
    }

    public void setLangues(Langues langues) {
        this.langues = langues;
    }

    public TestCV getTestCV() {
        return testCV;
    }

    public void setTestCV(TestCV testCV) {
        this.testCV = testCV;
    }
}
