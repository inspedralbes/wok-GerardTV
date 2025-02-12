package src.wokmodel;

public class Base {
    private String descripcio;
    private String mida;
    private double preu;

    public Base(String descripcio,String mida,double preu){
        this.descripcio = descripcio;
        this.mida = mida;
        this.preu = preu;
    }

    public String getDescripcio(){
        return descripcio;
    }

    public String getMida(){
        return mida;
    }

    public double getPreu(){
        return preu;
    }
}
