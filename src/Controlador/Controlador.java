package Controlador;

import java.util.*;
import Vista.Vista;
import Model.Model;
import Model.objects.*;

public class Controlador {
    public static Scanner scann = new Scanner(System.in);

    // Llamamos al menu principal desde el main


    /*
     * Mostramos el menu principal y implementamos la logica para escoger las
     * opciones
     */
    public static void menuPrincipalControlador() {
        int opcio;
        Vista.menuPrincipal();
        do {
            opcio = scann.nextInt();
            switch (opcio) {
                case 1:
                    menuGestioMagatzem();
                    break;
                case 2:
                    menuIntroduirProductesControlador();
                    break;
                case 3:
                    passarPerCaixa();
                    break;
                case 4:
                    mostrarCarroCompra();
                    break;
                case 0:
                    System.out.println("Fins aviat!");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuGestioMagatzem() {
        int opcio;
        Vista.menuGestioMagatzem();
        do {
            opcio = scann.nextInt();
            switch (opcio) {
                case 1:
                    llistarPerCaducitat();
                    break;
                case 2:
                    mostrarTiquetsCompra();
                    break;
                case 3:
                    ordenarTextilsPerComposicio();
                    break;
                case 0:
                    menuPrincipalControlador();
                    break;
            }
        } while (opcio != 0);
    }

    public static void llistarPerCaducitat() {
        List<Aliment> aliments = Model.getAliments();
        aliments.sort(Comparator.comparing(Aliment::getDataCaducitat));
        Vista.mostrarAliments(aliments);
    }

    public static void mostrarTiquetsCompra() {
        List<String> tiquets = Model.getTiquetsCompra();
        Vista.mostrarTiquetsCompra(tiquets);
    }

    public static void ordenarTextilsPerComposicio() {
        List<Textil> textils = Model.getTextils();
        textils.sort(Comparator.comparing(Textil::getComposicio));
        Vista.mostrarTextils(textils);
    }

    public static void mostrarCarroCompra() {
        Vista.mostrarCarro(Model.getAliments(), Model.getTextils(), Model.getElectronica());
    }

    /*
     * Si el usuario escoje la opcion 1, se abre el sub-menu
     * y implementamos la logica para escoger las opciones
     */
    public static void menuIntroduirProductesControlador() {
        int opcio;
        Vista.menuIntroduirProducte();
        do {
            opcio = scann.nextInt();
            switch (opcio) {
                case 1:
                    introduirAliment();
                    break;
                case 2:
                    introduirTextil();
                    break;
                case 3:
                    introduirElectronica();
                    break;
                case 0:
                    menuPrincipalControlador();
                    break;
            }
        } while (opcio != 0);
    }

    // Logica y formularios para introducir los productos (Alimentos, Textiles y
    // Electronica)
    public static void introduirAliment() {
        if (Model.getAliments().size() + Model.getTextils().size() + Model.getElectronica().size() >= 100) {
            System.out.println("No es poden afegir més productes. El carret està ple.");
            return;
        }
        scann.nextLine(); // Limpiar linea nueva
        System.out.print("Nom producte: ");
        String nom = scann.nextLine();
        System.out.print("Preu: ");
        double preu = scann.nextDouble();
        System.out.println("Codi de barres: ");
        int codiBarres = scann.nextInt();
        scann.nextLine(); // Limpiar linea nueva
        System.out.print("Data de caducitat (dd/mm/aaaa): ");
        String dataCaducitatStr = scann.nextLine();

        Aliment aliment = new Aliment(nom, preu, codiBarres, dataCaducitatStr);
        if (Model.addAliment(aliment)) {
            System.out.println("Aliment afegit correctament!");
        } else {
            System.out.println("No es poden afegir més productes. El carret està ple.");
        }
    }

    public static void introduirTextil() {
        if (Model.getAliments().size() + Model.getTextils().size() + Model.getElectronica().size() >= 100) {
            System.out.println("No es poden afegir més productes. El carret està ple.");
            return;
        }
        String composicioStr = "";
        scann.nextLine(); // Limpiar linea nueva
        System.out.println("Nom producte: ");
        String nom = scann.nextLine();
        System.out.println("Preu: ");
        double preu = scann.nextDouble();
        int opcio;
        Vista.menuTextilComposicio();
        opcio = scann.nextInt();
        switch (opcio) {
            case 1:
                composicioStr = "Cotó";
                break;
            case 2:
                composicioStr = "Llana";
                break;
            case 3:
                composicioStr = "Poliester";
                break;
            case 4:
                composicioStr = "Altres";
                break;
        }
        System.out.println("Codi de barres: ");
        int codiBarres = scann.nextInt();

        Textil textil = new Textil(nom, preu, composicioStr, codiBarres);
        if (Model.addTextil(textil)) {
            System.out.println("Textil afegit correctament!");
        } else {
            System.out.println("No es poden afegir més productes. El carret està ple.");
        }
    }

    public static void introduirElectronica() {
        if (Model.getAliments().size() + Model.getTextils().size() + Model.getElectronica().size() >= 100) {
            System.out.println("No es poden afegir més productes. El carret està ple.");
            return;
        }
        scann.nextLine(); // Limpiar linea nueva
        System.out.println("Nom producte: ");
        String nom = scann.nextLine();
        System.out.println("Preu: ");
        double preu = scann.nextDouble();
        System.out.println("Garantia (dies): ");
        int diesGarantia = scann.nextInt();
        System.out.println("Codi de barres: ");
        int codiBarres = scann.nextInt();

        Electronica electronica = new Electronica(nom, preu, diesGarantia, codiBarres);
        if (Model.addElectronica(electronica)) {
            System.out.println("Electronica afegida correctament!");
        } else {
            System.out.println("No es poden afegir més productes. El carret està ple.");
        }
    }

    public static void mostrarPreuCarret() {
        double preuTotal = Model.calcularPreuTotal();
        Vista.mostrarPreuCarret(preuTotal);
    }

    public static void passarPerCaixa() {
        double preuTotal = Model.calcularPreuTotal();
        Map<Integer, Integer> carretCompra = new HashMap<>();
        Model.getAliments().forEach(aliment -> carretCompra.put(aliment.getCodiBarres(), 1));
        Model.getTextils().forEach(textil -> carretCompra.put(textil.getCodiBarres(), 1));
        Model.getElectronica().forEach(electronica -> carretCompra.put(electronica.getCodiBarres(), 1));
        Vista.mostrarTiquetCompra(carretCompra, preuTotal);
        Model.buidarCarro();
    }

    public static String buscarProductePerCodiBarres(int codiBarres) {
        return Model.getAliments().stream()
                .filter(aliment -> aliment.getCodiBarres() == codiBarres)
                .map(Aliment::getNom)
                .findFirst()
                .orElse(Model.getTextils().stream()
                        .filter(textil -> textil.getCodiBarres() == codiBarres)
                        .map(Textil::getNom)
                        .findFirst()
                        .orElse(Model.getElectronica().stream()
                                .filter(electronica -> electronica.getCodiBarres() == codiBarres)
                                .map(Electronica::getNom)
                                .findFirst()
                                .orElse("Producte no trobat")));
    }
}
