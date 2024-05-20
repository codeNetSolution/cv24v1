package fr.univrouen.cv24.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class ObjectifStatut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement(name = "initule", namespace = "http://univ.fr/cv24")
    private String initule;

    @XmlElement(name = "typeContrat", namespace = "http://univ.fr/cv24")
    private String typeContrat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitule() {
        return initule;
    }

    public void setInitule(String initule) {
        this.initule = initule;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }
}
