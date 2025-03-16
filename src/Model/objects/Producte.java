package Model.objects;

public class Producte {
    protected String nom;
    protected double preu;
    protected int codiBarres;

    public Producte(String nom, double preu, int codiBarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiBarres = codiBarres;
    }

    public String getNom() {
        return nom;
    }


    public double getPreu() {
        return preu;
    }


    public int getCodiBarres() {
        return codiBarres;
    }


    public double calcularPreu() {
        return preu;
    }
}