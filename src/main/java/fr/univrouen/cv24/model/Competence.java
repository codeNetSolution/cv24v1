package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "competences")
@XmlAccessorType(XmlAccessType.FIELD)
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement(name = "titre", namespace = "http://univ.fr/cv24")
    private String titre;

    @XmlElement(name = "datedeb", namespace = "http://univ.fr/cv24")
    private String datedeb;

    @XmlElement(name = "datefin", namespace = "http://univ.fr/cv24")
    private String datefin;

    @ManyToOne
    @JoinColumn(name = "competencesList_id")
    private CompetencesList competencesList;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private TestCV testCV;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public CompetencesList getCompetencesList() {
        return competencesList;
    }

    public void setCompetencesList(CompetencesList competencesList) {
        this.competencesList = competencesList;
    }

    public TestCV getTestCV() {
        return testCV;
    }

    public void setTestCV(TestCV testCV) {
        this.testCV = testCV;
    }
}
