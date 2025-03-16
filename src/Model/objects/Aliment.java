package Model.objects;
import java.time.*;
import java.time.format.*;

public class Aliment extends Producte implements Comparable<Aliment> {
    private LocalDate dataCaducitat;

    public Aliment(String nom, double preu, int codiBarres, String dataCaducitatStr) {
        super(nom, preu, codiBarres);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataCaducitat = LocalDate.parse(dataCaducitatStr, formatter);
    }

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    @Override
    public int compareTo(Aliment other) {
        return this.dataCaducitat.compareTo(other.dataCaducitat);
    }
}