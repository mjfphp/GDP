package com.djz.classes;

public  class Article {
    private String id;
    private String ref;
    private String nom;
    private String des;
    private double prix;
    private double poids;
    private String um;

    public Article(String id, String ref, String nom, String des, Double prix, Double poids, String um) {
        this.id = id;
        this.ref = ref;
        this.nom = nom;
        this.des = des;
        this.prix = prix;
        this.poids = poids;
        this.um = um;
    }

    public Article(String ref, String nom, String des, double prix, double poids, String um){
        this(null,ref,nom,des,prix,poids,um);
    }

    public String getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public String getNom() {
        return nom;
    }

    public String getDes() {
        return des;
    }

    public double getPrix() {
        return prix;
    }

    public double getPoids() {
        return poids;
    }

    public String getUm() {
        return um;
    }
}
