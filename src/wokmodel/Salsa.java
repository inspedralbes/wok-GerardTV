package src.wokmodel;

public class Salsa extends Producte {

    public Salsa(String descripcio,double preu){
        super(descripcio,preu);
    }

    @Override
    public String toString(){
        return "Salsa: " + this.getDescripcio() + " - " + String.format("%.2f€",this.getPreu());
    }

}
