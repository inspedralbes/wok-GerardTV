package src;

import src.UtilsGerard.Utils;
import src.dao.WokDAO;
import src.dao.WokDAOCSV;
import src.dao.WokDAOMongoDB;
import src.dao.WokDAOMySQL;
import src.wokmodel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static src.UtilsGerard.Utils.llegirInt;
import static src.UtilsWok.*;

public class WokGerard {
        static WokDAO wokDAO = new WokDAOMongoDB();
    public static void main(String[] args) {
        double preu;
        Wok.setPreuBaseGran(1.00);
        int option;
        do{
            System.out.println("Menu");
            System.out.println("1.-Crear un nou Wok");
            System.out.println("2.-Llistar tots ls Woks");
            System.out.println("3.-Servir Wok");
            System.out.println("0.-Sortir");
            option = llegirInt(scan,"Escull una opció:",0,3);
            switch (option){
                case 1: crearWok();break;
                case 2: llistarWoks();break;
                case 3: servirWok(); break;
                case 0:
                    System.out.println("Adeu!!");
            }
        }while(option != 0);

    }

    private static void servirWok() {
        Wok wok = wokDAO.servirWok();
        if(wok != null){
            System.out.println("Aquí te el seu wok:");
            System.out.println(wok);
            System.out.println();
        }
    }

    private static void llistarWoks() {
        List<Wok> woks =  wokDAO.llegirWoks();
        for (Wok w : woks){
            System.out.println(w);
        }
        System.out.println();
    }

    private static void crearWok() {
        Base base = escollirBase();
        Ingredient[] ingredients = escollirIngredients();
        Salsa salsa = escollirSalsa();
        Wok wok = new Wok(base,ingredients,salsa);
        wokDAO.guardarWok(wok);
        mostrarResumComanda(wok);
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
            System.out.println("2 - Gran (+"+String.format("%.2f€)",Wok.getPreuBaseGran()));
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
        if (mida ==  MidaBase.GRAN ) {
            return new Base(basesDesc[base], mida, basePreus[base] + Wok.getPreuBaseGran());
        }else{
            return new Base(basesDesc[base], mida, basePreus[base]);
        }
    }
}

