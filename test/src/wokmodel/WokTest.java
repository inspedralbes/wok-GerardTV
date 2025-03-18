package src.wokmodel;


import static org.junit.jupiter.api.Assertions.assertEquals;

class WokTest {

    @org.junit.jupiter.api.Test
    void testCalcularPreu() {
        Base base = new Base("",null,5.0);
        Ingredient[] ingredients = {new Ingredient("",2.0),new Ingredient("",1.5)};
        Salsa salsa = new Salsa("",1.0);
        Wok wok = new Wok(base,ingredients,salsa);
        double preuEsperat = (5.0+2.0+1.5+1.0);
        assertEquals(preuEsperat,wok.getPreu(),0.1,"");
    }
}