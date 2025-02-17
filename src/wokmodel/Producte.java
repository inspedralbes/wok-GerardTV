package src.wokmodel;

abstract public class Producte {
    private String descripcio;
    private double preu;

    Producte(String descripcio, double preu){
        this.descripcio = descripcio;
        this.preu = preu;
    }

    public String getDescripcio(){
        return this.descripcio;
    }

    public double getPreu(){
        return this.preu;
    }

}
