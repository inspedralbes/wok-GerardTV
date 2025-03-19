package src.dao;

import src.wokmodel.Ingredient;
import src.wokmodel.Wok;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
        csv.append(wok.getSalsa().getDescripcio()).append(",");
        csv.append(wok.getSalsa().getPreu()).append(",");
        return csv.toString();
    }

    @Override
    public List<Wok> llegirWoks() {
        return List.of();
    }
}
