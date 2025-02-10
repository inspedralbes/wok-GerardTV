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
    public static void main(String[] args) {
        int base,mida,salsa;
        double preu;
        ArrayList<Integer> ingredients;
        base = escollirBase();
        mida = escollirMida(base);
        ingredients = escollirIngredients();
        salsa = escollirSalsa();
        preu = calcularPreu(base,mida,ingredients,salsa);
        mostrarResumComanda(base,mida,ingredients,salsa,preu);
    }

    private static void mostrarResumComanda(int base, int mida, ArrayList<Integer> ingredients, int salsa, double preu) {
    }

    private static double calcularPreu(int base, int mida, ArrayList<Integer> ingredients, int salsa) {
        //TODO:calcular preu del wok
        return -1;
    }

    private static int escollirSalsa() {
        //TODO: Escollir la salsa
        return -1;
    }

    private static ArrayList<Integer> escollirIngredients() {
        return null;
    }

    private static int escollirMida(int base) {
        if (baseMida[base]){
            //TODO: escollir mida
            return -1;
        }else{
            System.out.println("Aquesta base només pot anar amb la mida gran del Wok.");
            return 2;
        }
    }

    /**
     * Funció per demanar el tipus de base de la comanda
     * @return el codi de la base escollida
     */
    private static int escollirBase() {
        System.out.println("Bases disponibles:");
        for (int i = 0; i < basesDesc.length; i++) {
            System.out.println( (i+1) +" - "+basesDesc[i] + " - " + basePreus[i] );
        }
        return llegirInt(scan,"Escolleix una base:",1,basesDesc.length)-1;
    }
}
