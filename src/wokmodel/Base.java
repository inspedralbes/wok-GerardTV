package src.wokmodel;

public class Base extends Producte{
    private MidaBase mida;

    public Base(String descripcio,MidaBase mida,double preu){
        super(descripcio,preu);
        this.mida = mida;
    }

    public MidaBase getMida(){
        return mida;
    }


    @Override
    public String toString(){
        return "Base: " + this.getDescripcio() + " - " + String.format("%.2f€",this.getPreu()) +
                "\nMida: " + this.getMida();
    }

}
