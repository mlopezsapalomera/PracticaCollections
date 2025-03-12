import java.util.*;
import Vista.Vista;
import Model.Model;
import Model.Objectes.Aliment;
import Model.Objectes.Textil;
import Model.Objectes.Electronica;

public class Controlador {
    public static Scanner scann = new Scanner(System.in);

    // Llamamos al menu principal desde el main
    public static void main(String[] args) {
        menuPrincipalControlador();
    }

    /* Mostramos el menu principal y implementamos la logica para escoger las opciones */
    public static void menuPrincipalControlador() {
        int opcio;
        Vista.menuPrincipal();
        do {
            opcio = scann.nextInt();
            switch (opcio) {
                case 1:
                    menuIntroduirProductesControlador();
                    break;
                case 2:
                    //pasarPerCaixa();
                    break;
                case 3:
                    mostrarPreuCarret();
                    break;
                case 0:
                    System.out.println("Fins aviat!");
                    break;
            }
        } while (opcio != 0);
    }

    /* Si el usuario escoje la opcion 1, se abre el sub-menu
    y implementamos la logica para escoger las opciones */
    public static void menuIntroduirProductesControlador(){
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

    // Logica y formularios para introducir los productos (Alimentos, Textiles y Electronica)
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

        Textil textil = new Textil (nom, preu, composicioStr, codiBarres);
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

}
