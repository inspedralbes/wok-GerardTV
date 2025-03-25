package src.dao;

import src.database.ConnexioBD;
import src.wokmodel.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        // TODO Auto-generated method stub
        return null;
    }

}
