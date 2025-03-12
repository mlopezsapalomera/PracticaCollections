package Model.Objectes;

public class Electronica {
    private String nom;
    private double preu;
    private int diesGarantia;
    private int codiBarres;

    public Electronica(String nom, double preu, int diesGarantia, int codiBarres) {
        this.nom = nom;
        this.preu = preu;
        this.diesGarantia = diesGarantia;
        this.codiBarres = codiBarres;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    public int getDiesGarantia() {
        return diesGarantia;
    }

    public int getcodiBarres() {
        return codiBarres;
    }

}
