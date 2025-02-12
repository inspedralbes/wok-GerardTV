package src;

import java.util.ArrayList;
import java.util.Scanner;

import static src.UtilsGerard.Utils.llegirInt;

public class WokGerard {
    static Scanner scan = new Scanner(System.in);
    static String[] basesDesc = {"Fideus Cruixents", "Tallarines d'arròs",
            "Fideus d'arròs","Fins d'arròs","Arròs Gesami","Arròs Integral","Verdures Variades","Udon","croquetes"};
    static double[] basePreus = {4.10,4.10,4.10,4.10,4.10,4.10,4.10,5.10,6.5};
    static boolean[] baseMida = {true,true,true,true,true,true,true,false,false};
    static String[] salses = {"Soja", "Ostres", "Agredolça", "Teriyaki", "Picant"};
    static double[] preusIngredients = {1.50, 2.00, 1.80, 2.50, 3.00, 2.20, 1.70, 2.80, 1.60};
    static String[] ingredientsDesc = {"Pollastre", "Vedella", "Gambes", "Tofu", "Ou", "Xampinyons", "Ceba", "Pebrot", "Pastanaga"};

    public static void main(String[] args) {
        int base, mida, salsa;
        double preu;
        ArrayList<Integer> ingredients;
        base = escollirBase();
        mida = escollirMida(base);
        ingredients = escollirIngredients();
        salsa = escollirSalsa();
        preu = calcularPreu(base, mida, ingredients, salsa);
        mostrarResumComanda(base, mida, ingredients, salsa, preu);
    }

    private static void mostrarResumComanda(int base, int mida, ArrayList<Integer> ingredients, int salsa, double preu) {
        System.out.println("\nResum de la comanda:");
        System.out.println("Base: " + basesDesc[base] + " - " + basePreus[base] + "€");
        System.out.println("Mida: " + (mida == 1 ? "Petita" : "Gran (+1.50€)"));
        System.out.println("Ingredients: ");
        for (int ing : ingredients) {
            System.out.println(" - " + ingredientsDesc[ing] + " - " + preusIngredients[ing] + "€");
        }
        System.out.println("Salsa: " + salses[salsa]);
        System.out.println("Preu total: " + String.format("%.2f", preu) + "€");
    }

    private static double calcularPreu(int base, int mida, ArrayList<Integer> ingredients, int salsa) {
        double preu = basePreus[base];
        if (mida == 2) preu += 1.50;
        for (int ing : ingredients) {
            preu += preusIngredients[ing];
        }
        return preu;
    }

    private static int escollirSalsa() {
        System.out.println("Salses disponibles:");
        for (int i = 0; i < salses.length; i++) {
            System.out.println((i + 1) + " - " + salses[i]);
        }
        return llegirInt(scan, "Escolleix una salsa:", 1, salses.length) - 1;
    }

    private static ArrayList<Integer> escollirIngredients() {
        ArrayList<Integer> ingredients = new ArrayList<>();
        System.out.println("Ingredients disponibles:");
        for (int i = 0; i < ingredientsDesc.length; i++) {
            System.out.println((i + 1) + " - " + ingredientsDesc[i] + " - " + preusIngredients[i] + "€");
        }
        int opcio;
        do {
            opcio = llegirInt(scan, "Escolleix un ingredient (0 per acabar):", 0, ingredientsDesc.length);
            if (opcio > 0) ingredients.add(opcio - 1);
        } while (opcio != 0);
        return ingredients;
    }

    private static int escollirMida(int base) {
        if (baseMida[base]) {
            System.out.println("Tria la mida del Wok:");
            System.out.println("1 - Petita");
            System.out.println("2 - Gran (+1.50€)");
            return llegirInt(scan, "Escolleix una mida:", 1, 2);
        } else {
            System.out.println("Aquesta base només pot anar amb la mida gran del Wok.");
            return 2;
        }
    }

    private static int escollirBase() {
        System.out.println("Bases disponibles:");
        for (int i = 0; i < basesDesc.length; i++) {
            System.out.println((i + 1) + " - " + basesDesc[i] + " - " + basePreus[i] + "€");
        }
        return llegirInt(scan, "Escolleix una base:", 1, basesDesc.length) - 1;
    }
}

