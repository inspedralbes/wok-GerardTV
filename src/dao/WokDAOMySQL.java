package src.dao;

import src.BD_Mysql.ConnexioBD;
import src.wokmodel.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WokDAOMySQL implements WokDAO{
    private static Connection conn;
    public WokDAOMySQL(){
       conn  = ConnexioBD.getInstance();
    }

    @Override
    public void guardarWok(Wok wok) {
        try {
            Connection con = ConnexioBD.getInstance();
            String query = "INSERT INTO Wok ( basedesc, preubase, midabase, ingredients, salsadesc, preusalsa) " +
                    "VALUES ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement =  con.prepareStatement(query);
            statement.setString(1, wok.getBase().getDescripcio());
            statement.setDouble(2, wok.getBase().getPreu());
            statement.setString(3, wok.getBase().getMida().toString());
            statement.setString(4, ingredientsToString(wok.getIngredients()));
            statement.setString(5, wok.getSalsa().getDescripcio());
            statement.setDouble(6, wok.getSalsa().getPreu());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String ingredientsToString(Ingredient[] ingredients) {
        StringBuilder sb = new StringBuilder();
        for (Ingredient i : ingredients){
            sb.append(i.getDescripcio()).append(":").append(i.getPreu()).append(";");
        }
        return sb.toString();
    }

    @Override
    public List<Wok> llegirWoks() {
        List<Wok> woks = new ArrayList<>();
        try{
            Connection con = ConnexioBD.getInstance();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Wok");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Base base = new Base(rs.getString("basedesc"),
                        MidaBase.valueOf(rs.getString("midabase")),
                        rs.getDouble("preubase"));
                List<Ingredient> ingredients = new ArrayList<>();
                for (String ing: rs.getString("ingredients").split(";")){
                    if(!ing.isEmpty()){
                        String[] parts = ing.split(":");
                        ingredients.add(new Ingredient(parts[0],Double.parseDouble(parts[1])));
                    }
                }
                Salsa salsa = new Salsa(rs.getString("salsadesc"),rs.getDouble("preusalsa"));
                woks.add(new Wok(base,ingredients.toArray(new Ingredient[0]),salsa));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return woks;
    }

    @Override
    public Wok servirWok() {
        Wok wok = null;
        try{
            Connection con = ConnexioBD.getInstance();
            String query = "SELECT * FROM Wok ORDER BY id ASC LIMIT 1";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Base base = new Base(rs.getString("basedesc"),
                        MidaBase.valueOf(rs.getString("midabase")),
                        rs.getDouble("preubase"));
                List<Ingredient> ingredients = new ArrayList<>();
                for (String ing : rs.getString("ingredients").split(";")) {
                    if (!ing.isEmpty()) {
                        String[] parts = ing.split(":");
                        ingredients.add(new Ingredient(parts[0], Double.parseDouble(parts[1])));
                    }
                }
                Salsa salsa = new Salsa(rs.getString("salsadesc"), rs.getDouble("preusalsa"));
                wok = new Wok(base, ingredients.toArray(new Ingredient[0]), salsa);
                //eliminem el wok
                PreparedStatement delStmt = con.prepareStatement("DELETE FROM Wok WHERE ID = ?");
                delStmt.setInt(1,rs.getInt("ID"));
                delStmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wok;
    }

}
