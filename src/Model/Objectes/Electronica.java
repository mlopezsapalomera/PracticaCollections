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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public int getDiesGarantia() {
        return diesGarantia;
    }

    public void setDiesGarantia(int diesGarantia) {
        this.diesGarantia = diesGarantia;
    }

    public int getCodiBarres() {
        return codiBarres;
    }

    public void setCodiBarres(int codiBarres) {
        this.codiBarres = codiBarres;
    }

    public double calcularPreu() {
        return preu + preu * (diesGarantia / 365.0) * 0.1;
    }

}
