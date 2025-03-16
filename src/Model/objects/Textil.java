package Model.objects;

public class Textil extends Producte {
    private String composicioStr;

    public Textil(String nom, double preu, String composicioStr, int codiBarres) {
        super(nom, preu, codiBarres);
        this.composicioStr = composicioStr;
    }

    public String getComposicio() {
        return composicioStr;
    }

}