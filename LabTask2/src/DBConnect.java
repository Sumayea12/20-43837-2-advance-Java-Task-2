
import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class DBConnect {

    private static final String URL = "jdbc:mysql://localhost:3306/labtask2";
    private static final String USER = "root";
    /*private static final String PASSWORD = ""; */


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load", e);
        }

        return DriverManager.getConnection(URL, USER, "");
    }
}
