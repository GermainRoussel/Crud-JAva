import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/crudjava";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection connexion = null;
        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Établir la connexion à la base de données
            connexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion établie avec succès !");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC non trouvé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Échec de la connexion à la base de données !");
            e.printStackTrace();
        }
        return connexion;
    }
}
