
import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class DB {

    public static List<registeredUser> getAllUsers() throws SQLException {
        List<registeredUser> users = new ArrayList<>();
        try (Connection connection = DBConnect.getConnection()) {
            String sql = "SELECT name, email,password FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    registeredUser registereduser = new registeredUser(resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("password"));
                    users.add(registereduser);
                }
            }
        }
        return users;
    }

    public static void createUser(registeredUser registereduser) throws SQLException {
        try (Connection connection = DBConnect.getConnection()) {
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, registereduser.getFullName());
                preparedStatement.setString(2, registereduser.getEmail());
                preparedStatement.setString(3, registereduser.getPassword());
                preparedStatement.executeUpdate();
            }
        }
    }
}