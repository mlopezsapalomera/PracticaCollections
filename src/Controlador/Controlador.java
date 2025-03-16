package Controlador;

import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.*;
import Vista.Vista;
import Model.Model;
import Model.objects.*;
import Model.Exceptions.*;

public class Controlador {
    public static Scanner scann = new Scanner(System.in);

    public static void menuPrincipalControlador() {
        int opcio;
        do {
            Vista.menuPrincipal();
            opcio = scann.nextInt();
            try {
                switch (opcio) {
                    case 1:
                        menuIntroduirProductesControlador();
                        break;
                    case 2:
                        passarPerCaixa();
                        break;
                    case 3:
                        mostrarCarroCompra();
                        break;
                    case 0:
                        System.out.println("Fins aviat!");
                        break;
                    default:
                        throw new EnumFailException("Opció no vàlida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no vàlida.");
                scann.next(); // Limpiar el scanner
            } catch (EnumFailException e) {
                System.out.println(e.getMessage());
            }
        } while (opcio != 0);
    }

    public static void menuGestioMagatzem() {
        int opcio;
        do {
            Vista.menuGestioMagatzem();
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

    public static void menuIntroduirProductesControlador() {
        int opcio;
        do {
            Vista.menuIntroduirProducte();
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

    public static void introduirAliment() {
        try {
            if (Model.getAliments().size() + Model.getTextils().size() + Model.getElectronica().size() >= 100) {
                throw new LimitProductesException("No es poden afegir més productes. El carret està ple.");
            }
            scann.nextLine(); // Limpiar linea nueva
            System.out.print("Nom producte: ");
            String nom = scann.nextLine();
            if (nom.length() > 50) {
                throw new LimitCaracteresException("El nom del producte supera el límit de caràcters permès.");
            }
            System.out.print("Preu: ");
            double preu = scann.nextDouble();
            if (preu < 0) {
                throw new NegatiuException("El preu no pot ser negatiu.");
            }
            System.out.print("Codi de barres: ");
            int codiBarres = scann.nextInt();
            scann.nextLine(); // Limpiar linea nueva
            System.out.print("Data de caducitat (dd/MM/yyyy): ");
            String dataCaducitatStr = scann.nextLine();

            try {
                Aliment aliment = new Aliment(nom, preu, codiBarres, dataCaducitatStr);
                if (Model.addAliment(aliment)) {
                    System.out.println("Aliment afegit correctament!");
                } else {
                    throw new LimitProductesException("No es poden afegir més productes. El carret està ple.");
                }
            } catch (DateTimeParseException e) {
                throw new DataCaducitatException("Format de data incorrecte. Si us plau, introdueix la data en format dd/MM/yyyy.");
            }
        } catch (LimitProductesException | LimitCaracteresException | NegatiuException | DataCaducitatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void introduirTextil() {
        try {
            if (Model.getAliments().size() + Model.getTextils().size() + Model.getElectronica().size() >= 100) {
                throw new LimitProductesException("No es poden afegir més productes. El carret està ple.");
            }
            String composicioStr = "";
            scann.nextLine(); // Limpiar linea nueva
            System.out.print("Nom producte: ");
            String nom = scann.nextLine();
            if (nom.length() > 50) {
                throw new LimitCaracteresException("El nom del producte supera el límit de caràcters permès.");
            }
            System.out.print("Preu: ");
            double preu = scann.nextDouble();
            if (preu < 0) {
                throw new NegatiuException("El preu no pot ser negatiu.");
            }
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
            System.out.print("Codi de barres: ");
            int codiBarres = scann.nextInt();

            Textil textil = new Textil(nom, preu, composicioStr, codiBarres);
            if (Model.addTextil(textil)) {
                System.out.println("Textil afegit correctament!");
            } else {
                throw new LimitProductesException("No es poden afegir més productes. El carret està ple.");
            }
        } catch (LimitProductesException | LimitCaracteresException | NegatiuException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void introduirElectronica() {
        try {
            if (Model.getAliments().size() + Model.getTextils().size() + Model.getElectronica().size() >= 100) {
                throw new LimitProductesException("No es poden afegir més productes. El carret està ple.");
            }
            scann.nextLine(); // Limpiar linea nueva
            System.out.print("Nom producte: ");
            String nom = scann.nextLine();
            if (nom.length() > 50) {
                throw new LimitCaracteresException("El nom del producte supera el límit de caràcters permès.");
            }
            System.out.print("Preu: ");
            double preu = scann.nextDouble();
            if (preu < 0) {
                throw new NegatiuException("El preu no pot ser negatiu.");
            }
            System.out.print("Garantia (dies): ");
            int diesGarantia = scann.nextInt();
            System.out.print("Codi de barres: ");
            int codiBarres = scann.nextInt();

            Electronica electronica = new Electronica(nom, preu, diesGarantia, codiBarres);
            if (Model.addElectronica(electronica)) {
                System.out.println("Electronica afegida correctament!");
            } else {
                throw new LimitProductesException("No es poden afegir més productes. El carret està ple.");
            }
        } catch (LimitProductesException | LimitCaracteresException | NegatiuException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void passarPerCaixa() {
        double preuTotal = Model.calcularPreuTotal();
        Map<Integer, Integer> carretCompra = Model.getCarretCompra();
        Map<String, Double> productes = new HashMap<>();

        carretCompra.forEach((codiBarres, quantitat) -> {
            String nomProducte = buscarProductePerCodiBarres(codiBarres);
            double preuUnitari = buscarPreuPerCodiBarres(codiBarres);
            productes.put(nomProducte, preuUnitari * quantitat);
        });

        Vista.mostrarTiquetCompra(productes, preuTotal);
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

    public static double buscarPreuPerCodiBarres(int codiBarres) {
        return Model.getAliments().stream()
                .filter(aliment -> aliment.getCodiBarres() == codiBarres)
                .map(Aliment::getPreu)
                .findFirst()
                .orElse(Model.getTextils().stream()
                        .filter(textil -> textil.getCodiBarres() == codiBarres)
                        .map(Textil::getPreu)
                        .findFirst()
                        .orElse(Model.getElectronica().stream()
                                .filter(electronica -> electronica.getCodiBarres() == codiBarres)
                                .map(Electronica::getPreu)
                                .findFirst()
                                .orElse(0.0)));
    }

    public static void llegirFitxer(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fitxer no trobat.");
        } catch (IOException e) {
            System.out.println("Error: Problema llegint el fitxer.");
        }
    }
}