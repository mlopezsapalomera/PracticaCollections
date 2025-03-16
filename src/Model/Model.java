package Model;
import java.util.*;
import Model.objects.Aliment;
import Model.objects.Electronica;
import Model.objects.Textil;

public class Model {
    private static final int MAX_PRODUCTS = 100;
    private static List<Aliment> aliments = new ArrayList<>();
    private static List<Textil> textils = new ArrayList<>();
    private static List<Electronica> electronicas = new ArrayList<>();
    private static List<String> tiquetsCompra = new ArrayList<>();
    // Añadir un Map para gestionar el carrito de compras
    private static Map<Integer, Integer> carretCompra = new HashMap<>();

    public static boolean addAliment(Aliment aliment) {
        if (aliments.size() + textils.size() + electronicas.size() < MAX_PRODUCTS) {
            aliments.add(aliment);
            return true;
        }
        return false;
    }

    public static boolean addTextil(Textil textil) {
        if (aliments.size() + textils.size() + electronicas.size() < MAX_PRODUCTS) {
            textils.add(textil);
            return true;
        }
        return false;
    }

    public static boolean addElectronica(Electronica electronica) {
        if (aliments.size() + textils.size() + electronicas.size() < MAX_PRODUCTS) {
            electronicas.add(electronica);
            return true;
        }
        return false;
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

    public static void buidarCarro() {
        aliments.clear();
        textils.clear();
        electronicas.clear();
    }

    public static List<String> getTiquetsCompra() {
        return tiquetsCompra;
    }

    public static Map<Integer, Integer> getCarretCompra() {
        return carretCompra;
    }
}
