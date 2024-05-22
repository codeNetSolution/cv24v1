package fr.univrouen.cv24.model;

import java.util.List;

public class cv24 {
    private TestCV cv;
    private List<Diplome> diplomes;
    private ObjectifStatut objectifStatut;

    public cv24(TestCV cv, List<Diplome> diplomes, ObjectifStatut objectifStatut) {
        this.cv = cv;
        this.diplomes = diplomes;
        this.objectifStatut = objectifStatut;
    }

    // Getters and setters
    public TestCV getCv() {
        return cv;
    }

    public void setCv(TestCV cv) {
        this.cv = cv;
    }

    public List<Diplome> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(List<Diplome> diplomes) {
        this.diplomes = diplomes;
    }

    public void setObjectifStatut(ObjectifStatut objectifStatut) {
        this.objectifStatut = objectifStatut;
    }
    public ObjectifStatut getObjectifStatut() {
        return objectifStatut;
    }
}
