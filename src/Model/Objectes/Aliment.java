package Model.Objectes;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class Aliment {
    private String nom;
    private double preu;
    private int codiBarres;
    private LocalDate dataCaducitat;

    public Aliment(String nom, double preu,int codiBarres,String dataCaducitatStr){
        this.nom = nom;
        this.preu = preu;
        this.codiBarres = codiBarres;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataCaducitat = LocalDate.parse(dataCaducitatStr, formatter);
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

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(LocalDate dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    public double calcularPreu() {
        LocalDate dataActual = LocalDate.now();
        long diesFinsCaducitat = ChronoUnit.DAYS.between(dataActual, dataCaducitat);
        return preu - preu * (1.0 / (diesFinsCaducitat + 1)) + (preu * 0.1);
    }
}

