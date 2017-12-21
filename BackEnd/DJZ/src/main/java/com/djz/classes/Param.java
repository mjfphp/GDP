package com.djz.classes;

public class Param {
    private final String id;
    private  int dm; // divers matieres
    private  int dh; // divers heures
    private  int ao; // Amortissement outillage
    private  int fg; // frais generaux
    private int it; // impots et taxes
    private  int be; // Benefice
    private  int tfa; // divers transport et frais attache

    public Param(String id, int dm, int dh, int ao, int fg, int it, int be, int tfa) {
        this.id = id;
        this.dm = dm;
        this.dh = dh;
        this.ao = ao;
        this.fg = fg;
        this.it = it;
        this.be = be;
        this.tfa = tfa;
    }

    public Param( int dm, int dh, int ao, int fg, int it, int be, int tfa){
        this(null,dm,dh,ao,fg,it,be,tfa);
    }

    public String getId() {
        return id;
    }

    public int getDm() {
        return dm;
    }

    public int getDh() {
        return dh;
    }

    public int getAo() {
        return ao;
    }

    public int getFg() {
        return fg;
    }

    public int getIt() {
        return it;
    }

    public int getBe() {
        return be;
    }

    public int getTfa() {
        return tfa;
    }
}
