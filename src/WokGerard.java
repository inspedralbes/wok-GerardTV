package src;

import src.wokmodel.*;

import java.util.ArrayList;
import java.util.Scanner;

import static src.UtilsGerard.Utils.llegirInt;
import static src.UtilsWok.*;

public class WokGerard {

    public static void main(String[] args) {
        double preu;
        Base base = escollirBase();
        Ingredient[] ingredients = escollirIngredients();
        Salsa salsa = escollirSalsa();
        Wok wok = new Wok(base,ingredients,salsa);
        //TODO: Traslladar a dins de Wok preu = calcularPreu(base, mida, ingredients, salsa);
        //TODO: mostrarResumComanda(wok);
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

    private static Salsa escollirSalsa() {
        System.out.println("Salses disponibles:");
        for (int i = 0; i < salses.length; i++) {
            System.out.println((i + 1) + " - " + salses[i]);
        }
        int salsa = llegirInt(scan, "Escolleix una salsa:", 1, salses.length) - 1;

        return new Salsa(salses[salsa],0 );
    }

    private static Ingredient[] escollirIngredients() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        System.out.println("Ingredients disponibles:");
        for (int i = 0; i < ingredientsDesc.length; i++) {
            System.out.println((i + 1) + " - " + ingredientsDesc[i] + " - " + preusIngredients[i] + "€");
        }
        int opcio;
        do {
            opcio = llegirInt(scan, "Escolleix un ingredient (0 per acabar):", 0, ingredientsDesc.length);
            if (opcio > 0) ingredients.add(new Ingredient(ingredientsDesc[opcio - 1],preusIngredients[opcio - 1] ));
        } while (opcio != 0);
        return  ingredients.toArray(new Ingredient[0]);
    }

    private static String escollirMida(int base) {
        if (baseMida[base]) {
            System.out.println("Tria la mida del Wok:");
            System.out.println("1 - Petita");
            System.out.println("2 - Gran (+1.50€)");
            if( llegirInt(scan, "Escolleix una mida:", 1, 2) ==1){
                return "Petita";
            }
            else{
                return "Gran";
            }
        } else {
            System.out.println("Aquesta base només pot anar amb la mida gran del Wok.");
            return "Gran";
        }
    }

    private static Base escollirBase() {
        System.out.println("Bases disponibles:");
        for (int i = 0; i < basesDesc.length; i++) {
            System.out.println((i + 1) + " - " + basesDesc[i] + " - " + basePreus[i] + "€");
        }
        int base = llegirInt(scan, "Escolleix una base:", 1, basesDesc.length) - 1;
        String mida = escollirMida(base);
        return new Base(basesDesc[base], mida,basePreus[base]);
    }
}

