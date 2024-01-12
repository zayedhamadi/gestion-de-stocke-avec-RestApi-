package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    private static final String url = "jdbc:mysql://localhost:5306/bd_stockp";

    private static Connection connexion = null;

    public static Connection getConnexion() {
        if (connexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String utilisateur = "root";
                String motDePasse = "";
                connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
                System.err.println("te5dm cnx .");
              
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("fama 8alta fil cnx : " + e.getMessage());
            }
        }
        return connexion;
    }
}
