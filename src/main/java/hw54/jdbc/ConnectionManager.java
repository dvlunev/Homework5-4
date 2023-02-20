package hw54.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static final String URL = "jdbc:postgresql://localhost:5432/skypro";
    public static final String USER = "postgres";
    public static final String PASSWORD = "311090222";

    private ConnectionManager() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
