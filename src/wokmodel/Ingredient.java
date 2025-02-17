package src.wokmodel;

public class Ingredient extends Producte {

    public Ingredient(String descripcio,double preu){
        super(descripcio,preu);
    }

    @Override
    public String toString(){
        return "Ingredient: " + this.getDescripcio() + " - " + String.format("%.2f€",this.getPreu());
    }

}
