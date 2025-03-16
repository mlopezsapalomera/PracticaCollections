package Vista;

import java.time.LocalDate;
import java.util.*;
import Model.objects.*;

public class Vista {

    public static void menuPrincipal() {
        System.out.println("------------");
        System.out.println("-- INICI --- ");
        System.out.println("------------");
        System.out.println("1) Introduir Producte");
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

    public static void menuIntroduirProducte() {
        System.out.println("---------------");
        System.out.println("-- PRODUCTE --- ");
        System.out.println("---------------");
        System.out.println("1) Alimentacio");
        System.out.println("2) Textil");
        System.out.println("3) Electronica");
        System.out.println("0) Tornar");
    }

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

    public static void mostrarTiquetCompra(Map<String, Double> productes, double preuTotal) {
        System.out.println("------------");
        System.out.println("-- TIQUET -- ");
        System.out.println("------------");
        System.out.println("Data de la compra: " + LocalDate.now());
        System.out.println("Nom del supermercat: SAPAMERCAT");
        productes.forEach((nomProducte, preuTotalProducte) -> {
            System.out.println("Producte: " + nomProducte + " - Preu total: " + preuTotalProducte + "€");
        });
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