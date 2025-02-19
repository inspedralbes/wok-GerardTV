package src;

import src.wokmodel.*;

public class TestWok {
    public static void main(String[] args) {
        Base base = new Base("Fideus", MidaBase.GRAN,1.00);
        Ingredient[] ings = new Ingredient[0];
        Salsa salsa = new Salsa("Pistatxo",0.0);
        System.out.println(Wok.contadorWoks);
        Wok wok1 = new Wok(base,ings,salsa);
        Wok wok2 = new Wok(base,ings,salsa);
        Wok.contadorWoks = 1000;
        Wok wok3 = new Wok(base,ings,salsa);
        System.out.println(Wok.contadorWoks);
    }
}
