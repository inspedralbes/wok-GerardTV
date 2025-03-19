package src.dao;

import src.wokmodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WokDAOCSV implements WokDAO{
    private static String nomFitxer = "woks.csv";
    @Override
    public void guardarWok(Wok wok) {
        try {
            FileWriter myWriter = new FileWriter(nomFitxer,true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(wokToCSV(wok));
            bw.newLine();
            bw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String wokToCSV(Wok wok) {
        StringBuilder csv = new StringBuilder();
        csv.append(wok.getBase().getDescripcio()).append(",");
        csv.append(wok.getBase().getPreu()).append(",");
        csv.append(wok.getBase().getMida()).append(",");
        for(Ingredient i : wok.getIngredients()){
            csv.append(i.getDescripcio()).append(":");
            csv.append(i.getPreu()).append(";");
        }
        csv.append(",");
        csv.append(wok.getSalsa().getDescripcio()).append(",");
        csv.append(wok.getSalsa().getPreu()).append(",");
        return csv.toString();
    }

    @Override
    public List<Wok> llegirWoks() {
        List<Wok> woks = new ArrayList<>();
        try {
            File myObj = new File(nomFitxer);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                woks.add(wokFromCSV(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return woks;
    }

    private Wok wokFromCSV(String data) {
        String[] camps = data.split(",");
        try {
            Base base = new Base(camps[0], MidaBase.valueOf(camps[2]),Double.parseDouble(camps[1]));
            String[] ingredientsdata = camps[3].split(";");
            List<Ingredient> ingredients = new ArrayList<>();
            for (String ing: ingredientsdata){
                if(!ing.isEmpty()){
                    String[] parts = ing.split(":");
                    ingredients.add(new Ingredient(parts[0],Double.parseDouble(parts[1])));
                }
            }
            Salsa salsa  = new Salsa(camps[4],Double.parseDouble(camps[5]));
            return new Wok(base,ingredients.toArray(new Ingredient[0]),salsa);
        }catch (Exception e){
            System.out.println("Error en el proces de convertir un wok");
        }
        return null;
    }
}
