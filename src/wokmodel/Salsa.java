package src.wokmodel;

public class Salsa {
    private String descripcio;
    private double preu;

    public Salsa(String descripcio,double preu){
        this.descripcio = descripcio;
        this.preu = preu;
    }

    public String getDescripcio(){
        return descripcio;
    }

    public double getPreu(){
        return preu;
    }
}
