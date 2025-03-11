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
                    //introduirAliment();
                    break;
                case 2:
                    //introduirTextil();
                    break;
                case 3:
                    //introduirElectronica();
                    break;
                case 0:
                    menuPrincipalControlador();
                    break;
            }
        } while (opcio != 0);
    }
}
