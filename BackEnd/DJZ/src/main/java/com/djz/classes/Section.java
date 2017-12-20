package com.djz.classes;

public class Section {
    private final String id;
    private String intitule;
    private int taux;

    public Section(String id, String intitule, int taux) {
        this.id = id;
        this.intitule = intitule;
        this.taux = taux;
    }

    public Section(String intitule, int taux) {
       this(null,intitule,taux);
    }

    public String getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public int getTaux() {
        return taux;
    }
}
