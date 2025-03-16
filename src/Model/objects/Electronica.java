package Model.objects;

public class Electronica extends Producte {
    private int diesGarantia;

    public Electronica(String nom, double preu, int diesGarantia, int codiBarres) {
        super(nom, preu, codiBarres);
        this.diesGarantia = diesGarantia;
    }

    @Override
    public double calcularPreu() {
        return preu + preu * (diesGarantia / 365.0) * 0.1;
    }
}