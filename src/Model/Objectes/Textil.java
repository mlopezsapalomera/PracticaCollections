// src/Model/Objectes/Textil.java
package Model.Objectes;

public class Textil {
    private String nom;
    private double preu;
    private int codiBarres;
    private String composicioStr;

    public Textil(String nom, double preu, String composicioStr, int codibarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiBarres = codiBarres;
        this.composicioStr = composicioStr;
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

    public int getCodiBarres() {
        return codiBarres;
    }

    public void setCodiBarres(int codiBarres) {
        this.codiBarres = codiBarres;
    }

    public String getComposicio() {
        return composicioStr;
    }

    public void setComposicio(String composicioStr) {
        this.composicioStr = composicioStr;
    }
}