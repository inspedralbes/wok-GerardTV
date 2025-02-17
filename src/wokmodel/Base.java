package src.wokmodel;

public class Base extends Producte{
    private String mida;

    public Base(String descripcio,String mida,double preu){
        super(descripcio,preu);
        this.mida = mida;
    }

    public String getMida(){
        return mida;
    }


    @Override
    public String toString(){
        return "Base: " + this.getDescripcio() + " - " + String.format("%.2f€",this.getPreu()) +
                "\nMida: " + this.getMida();
    }

}
