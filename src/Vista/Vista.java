package Vista;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Objectes.Aliment;
import Model.Objectes.Electronica;
import Model.Objectes.Textil;

public class Vista {

    // Menu Principal
    public static void menuPrincipal() {
        System.out.println("------------");
        System.out.println("-- INICI --- ");
        System.out.println("------------");
        System.out.println("1) Introducir Producte");
        System.out.println("2) Passar per caixa");
        System.out.println("3) Mostrar carret de compra");
        System.out.println("0) Sortir");
    }

    public static void menuGestioMagatzem() {
        System.out.println("------------");
        System.out.println("-- MAGATZEM -- ");
        System.out.println("------------");
        System.out.println("1) Llistar per caducitat");
        System.out.println("2) Mostrar tiquets de compra");
        System.out.println("3) Ordenar tèxtils per composició");
        System.out.println("0) Tornar");
    }

    // Sub-Menu a la hora de introducir un producto
    public static void menuIntroduirProducte() {
        System.out.println("---------------");
        System.out.println("-- PRODUCTE --- ");
        System.out.println("---------------");
        System.out.println("1) Alimentacio");
        System.out.println("2) Textil");
        System.out.println("3) Electronica");
        System.out.println("0) Tornar");
    }

    // Menu de Composicones para los productos textiles
    public static void menuTextilComposicio() {
        System.out.println("----------------");
        System.out.println("-- COMPOSICIO -- ");
        System.out.println("----------------");
        System.out.println("1) Cotó");
        System.out.println("2) Llana");
        System.out.println("3) Poliester");
        System.out.println("4) Altres");
        System.out.println("----------------");
    }

    public static void mostrarPreuCarret(double preuTotal) {
        System.out.println("Preu total: " + preuTotal + "€");
    }

    // Modificar el método mostrarTiquetCompra
    public static void mostrarTiquetCompra(List<Aliment> aliments, List<Textil> textils, List<Electronica> electronicas,
            double preuTotal) {
        System.out.println("------------");
        System.out.println("-- TIQUET -- ");
        System.out.println("------------");
        System.out.println("Data de la compra: " + LocalDate.now());
        System.out.println("Nom del supermercat: SAPAMERCAT");
        Map<String, Integer> productes = new HashMap<>();
        for (Aliment aliment : aliments) {
            productes.put(aliment.getNom(), productes.getOrDefault(aliment.getNom(), 0) + 1);
        }
        for (Textil textil : textils) {
            productes.put(textil.getNom(), productes.getOrDefault(textil.getNom(), 0) + 1);
        }
        for (Electronica electronica : electronicas) {
            productes.put(electronica.getNom(), productes.getOrDefault(electronica.getNom(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : productes.entrySet()) {
            System.out.println("Producte: " + entry.getKey() + " - Quantitat: " + entry.getValue());
        }
        System.out.println("Preu total: " + preuTotal + "€");
    }

    public static void mostrarCarro(List<Aliment> aliments, List<Textil> textils, List<Electronica> electronicas) {
        System.out.println("------------");
        System.out.println("-- CARRO -- ");
        System.out.println("------------");
        for (Aliment aliment : aliments) {
            System.out.println("Aliment: " + aliment.getNom() + " - Quantitat: 1");
        }
        for (Textil textil : textils) {
            System.out.println("Textil: " + textil.getNom() + " - Quantitat: 1");
        }
        for (Electronica electronica : electronicas) {
            System.out.println("Electronica: " + electronica.getNom() + " - Quantitat: 1");
        }
    }

    public static void mostrarAliments(List<Aliment> aliments) {
        for (Aliment aliment : aliments) {
            System.out.println("Aliment: " + aliment.getNom() + " - Data de caducitat: " + aliment.getDataCaducitat());
        }
    }

    public static void mostrarTiquetsCompra(List<String> tiquets) {
        for (String tiquet : tiquets) {
            System.out.println(tiquet);
        }
    }

    public static void mostrarTextils(List<Textil> textils) {
        for (Textil textil : textils) {
            System.out.println("Textil: " + textil.getNom() + " - Composició: " + textil.getComposicio());
        }
    }
}