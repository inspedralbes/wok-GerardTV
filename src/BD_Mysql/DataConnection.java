package src.BD_Mysql;

public class DataConnection {
    private static String USR = "gtorrents_wok";
    private static String PWD = "1Password!";
    private static String URL = "jdbc:mysql://daw.inspedralbes.cat:3306/gtorrents_wok";

    public static String getUSR() {
        return USR;
    }

    public static String getPWD() {
        return PWD;
    }

    public static String getURL() {
        return URL;
    }
}
