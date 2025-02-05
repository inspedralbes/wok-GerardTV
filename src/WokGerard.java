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
        ArrayList<Integer> ingredients = new ArrayList<>();
        base = escollirBase();
        if (baseMida[base]){
            //TODO: escollir mida
        }else{
            System.out.println("Aquesta base només pot anar amb la mida gran del Wok.");
            mida = 2;
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
