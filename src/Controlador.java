import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import Vista.Vista;

public class Controlador {
    public static Scanner scann = new Scanner(System.in);
    public static void main(String[] args) {
        menuPrincipalControlador();
    }

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
                    //mostrarCarret();
                    break;
                case 0:
                    System.out.println("Fins aviat!");
                    break;
            }
        } while (opcio != 0);
    }

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

    public static void introduirAliment() {
        System.out.print("Nom producte: ");
        String nom = scann.nextLine();
        System.out.print("Preu: ");
        double preu = scann.nextDouble();
        System.out.println("Codi de barres: ");
        int codiBarres;
        System.out.print("Data de caducitat (dd/mm/aaaa): ");
        String dataCaducitatStr = scann.nextLine();
    }

    public static void introduirTextil() {
        System.out.println("Nom producte: ");
        String nom = scann.nextLine();
        System.out.println("Preu: ");
        double preu = scann.nextDouble();
        int opcio;
        String composicioStr;
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
    }

    public static void introduirElectronica() {

    }
}
