package src.wokmodel;

public class Wok {
    private Base base;
    private Ingredient[] ingredeints;
    private Salsa salsa;
    private double preu;


    public Wok(Base base,Ingredient[] ingredients, Salsa salsa){
        this.base = base;
        this.ingredeints = ingredients;
        this.salsa = salsa;
        this.preu = calcularPreu();
    }

    //TODO: geters necessaris

    private double calcularPreu(){

        //TODO: calular per preu del wok
        return -1;
    }




}
