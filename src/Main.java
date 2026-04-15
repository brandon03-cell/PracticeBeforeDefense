import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:beforeDefensa.sqlite";

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("gg");
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}