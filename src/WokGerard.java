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
        //mostrarResumComanda(wok);
        System.out.println(wok);
    }

    private static void mostrarResumComanda(Wok wok) {
        System.out.println("\nResum de la comanda:");
        System.out.println("Base: " + wok.getBase().getDescripcio() + " - " + wok.getBase().getPreu() + "€");
        System.out.println("Mida: " + wok.getBase().getMida());
        System.out.println("Ingredients: ");
        for (Ingredient ing : wok.getIngredients()) {
            System.out.println(" - " + ing.getDescripcio() + " - " + ing.getPreu()+ "€");
        }
        System.out.println("Salsa: " + wok.getSalsa().getDescripcio() + " - " + wok.getSalsa().getPreu()+ "€");
        System.out.println("Preu total: " + String.format("%.2f", wok.getPreu()) + "€");
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

    private static MidaBase escollirMida(int base) {
        if (baseMida[base]) {
            System.out.println("Tria la mida del Wok:");
            System.out.println("1 - Petita");
            System.out.println("2 - Gran (+1.50€)");
            if( llegirInt(scan, "Escolleix una mida:", 1, 2) ==1){
                return MidaBase.PETITA;
            }
            else{
                return MidaBase.GRAN;
            }
        } else {
            System.out.println("Aquesta base només pot anar amb la mida gran del Wok.");
            return MidaBase.GRAN;
        }
    }

    private static Base escollirBase() {
        System.out.println("Bases disponibles:");
        for (int i = 0; i < basesDesc.length; i++) {
            System.out.println((i + 1) + " - " + basesDesc[i] + " - " + basePreus[i] + "€");
        }
        int base = llegirInt(scan, "Escolleix una base:", 1, basesDesc.length) - 1;
        MidaBase mida = escollirMida(base);
        return new Base(basesDesc[base], mida,basePreus[base]);
    }
}

