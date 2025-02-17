package src.wokmodel;

import java.util.ArrayList;

public class Wok {
    private Base base;
    private Ingredient[] ingredients;
    private Salsa salsa;
    private double preu;


    public Wok(Base base,Ingredient[] ingredients, Salsa salsa){
        this.base = base;
        this.ingredients = ingredients;
        this.salsa = salsa;
        this.preu = calcularPreu();
    }

    public double getPreu(){
        return this.preu;
    }

    private double calcularPreu(){
        double preu = base.getPreu();
        for (Ingredient ing : this.ingredients) {
            preu += ing.getPreu();
        }
        preu += salsa.getPreu();
        return preu;
    }





}
