package Vista;

public class Vista {
    public static void menuPrincipal() {
        System.out.println("------------");
        System.out.println("-- INICI --- ");
        System.out.println("------------");
        System.out.println("1) Introducir Producte");
        System.out.println("2) Passar per caixa");
        System.out.println("3) Mostrar carret de compra");
        System.out.println("0) Sortir");
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
}