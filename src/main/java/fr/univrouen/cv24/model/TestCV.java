package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@XmlRootElement(name = "TestCV", namespace = "http://univ.fr/cv24")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestCV {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@XmlElement(name="identite",namespace = "http://univ.fr/cv24")
	private Identite identite;

	@OneToOne(cascade = CascadeType.ALL)
	@XmlElement(name = "objectif-statut", namespace = "http://univ.fr/cv24")
	private ObjectifStatut objectifStatut;

	@OneToOne(cascade = CascadeType.ALL)
	@XmlElement(name= "profs", namespace = "http://univ.fr/cv24")
	private Profs profs;

	@OneToOne(cascade = CascadeType.ALL)
	@XmlElement(name="competencesList",namespace = "http://univ.fr/cv24")
	private CompetencesList competencesList;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@XmlElement(name="diplomes",namespace = "http://univ.fr/cv24")
	private Diplomes diplomes;

	@OneToOne(cascade = CascadeType.ALL)
	@XmlElement(name="certifs",namespace = "http://univ.fr/cv24")
	private Certifs certifs;


	@OneToOne(cascade = CascadeType.ALL)
	@XmlElement(name="langues",namespace = "http://univ.fr/cv24")
	private Langues langues;

	@OneToOne(cascade = CascadeType.ALL)
	@XmlElement(name="autre",namespace = "http://univ.fr/cv24")
	private Autre autre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	public ObjectifStatut getObjectifStatut() {
		return objectifStatut;
	}

	public void setObjectifStatut(ObjectifStatut objectifStatut) {
		this.objectifStatut = objectifStatut;
	}

	public Profs getProfs() {
		return profs;
	}

	public void setProfs(Profs profs) {
		this.profs = profs;
	}

	public CompetencesList getCompetencesList() {
		return competencesList;
	}

	public void setCompetencesList(CompetencesList competencesList) {
		this.competencesList = competencesList;
	}

	public Diplomes getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(Diplomes diplomes) {
		this.diplomes = diplomes;
	}

	public void setCertifs(Certifs certifs) {
		this.certifs = certifs;
	}
	public Certifs getCertifs(){
		return certifs;
	}

	public Langues getLangues() {
		return langues;
	}

	public void setLangues(Langues langues) {
		this.langues = langues;
	}

	public Autre getAutre() {
		return autre;
	}

	public void setAutre(Autre autre) {
		this.autre = autre;
	}
}
