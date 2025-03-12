package Model;
import Model.Objectes.Aliment;
import Model.Objectes.Electronica;
import Model.Objectes.Textil;
import java.util.*;

public class Model {
    private static List<Aliment> aliments = new ArrayList<>();
    private static List<Textil> textils = new ArrayList<>();
    private static List<Electronica> electronicas = new ArrayList<>();

    public static void addAliment(Aliment aliment){
        aliments.add(aliment);
    }

    public static void addTextil(Textil textil){
        textils.add(textil);
    }

    public static void addElectronica(Electronica electronica){
        electronicas.add(electronica);
    }

    public static List<Aliment> getAliments() {
        return aliments;
    }

    public static List<Electronica> getElectronica() {
        return electronicas;
    }

    public static List<Textil> getTextils() {
        return textils;
    }

    public static double calcularPreuTotal() {
        double preuTotal = 0;
        for (Aliment aliment : aliments) {
            preuTotal += aliment.calcularPreu();
        }
        for (Textil textil : textils) {
            preuTotal += textil.calcularPreu();
        }
        for (Electronica electronica : electronicas) {
            preuTotal += electronica.calcularPreu();
        }
        return preuTotal;
    }

}
