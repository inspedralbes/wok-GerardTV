package src.dao;

import src.wokmodel.Wok;

import java.util.List;

public class WokDAOMongoDB implements WokDAO{
    @Override
    public void guardarWok(Wok wok) {
        //TODO: Implementar la funcionalitat de guardar un wok a MongoDB
    }

    @Override
    public List<Wok> llegirWoks() {
        //TODO: Implementar la funcionalitat de llegir woks de MongoDB
        return List.of();
    }

    @Override
    public Wok servirWok() {
        //TODO: Implementar la funcionalitat de servir un wok de MongoDB, es a dir eliminar-lo de la base de dades
        return null;
    }
}
