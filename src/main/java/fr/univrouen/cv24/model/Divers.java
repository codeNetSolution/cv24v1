package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "divers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Divers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @XmlElement(name = "divers",namespace = "http://univ.fr/cv24")
    private String divers;

    @XmlElement(name = "comment",namespace = "http://univ.fr/cv24")
    private String comment;



    @ManyToOne
    @JoinColumn(name = "cv_id")
    private TestCV testCV;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDivers() {
        return this.divers;
    }
    public String getComment() {
        return this.comment;
    }

    public void setDivers(String divers){
        this.divers = divers;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

}
