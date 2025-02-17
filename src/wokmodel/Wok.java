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

    public Base getBase(){
        return this.base;
    }

    public Ingredient[] getIngredients(){
        return this.ingredients;
    }

    public Salsa getSalsa(){
        return this.salsa;
    }

    private double calcularPreu(){
        double preu = base.getPreu();
        for (Ingredient ing : this.ingredients) {
            preu += ing.getPreu();
        }
        preu += salsa.getPreu();
        return preu;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder(this.getBase().toString());
        result.append("\n");
        for(Ingredient i : this.getIngredients()){
            result.append(i.toString()).append("\n");
        }
        result.append(this.salsa.toString()).append("\n");
        result.append(String.format("Preu Total: %.2f€",this.getPreu()));
        return result.toString();
    }



}
