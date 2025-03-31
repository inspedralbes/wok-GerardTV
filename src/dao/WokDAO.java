package src.dao;

import src.wokmodel.Wok;
import java.util.List;

public interface WokDAO {

    /**
     * Guarda un wok al repositori
     * @param wok
     */
    void guardarWok(Wok wok);

    /**
     * Retorna tots els woks
     * @return tots els woks
     */
    List<Wok> llegirWoks();

    /**
     * retorna i elimina el wok més antic
     * @return el wok més antic
     */
     Wok servirWok();
}
