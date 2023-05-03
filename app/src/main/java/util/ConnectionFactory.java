package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class ConnectionFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/app_task";
    public static final String USER = "root";
    public static final String PASS = "";

    public final static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Error connecting to database ", ex);
        }
    }

    public final static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException("Error closing database connection ", ex);
        }
    }

    public final static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException("Error closing database connection ", ex);
        }
    }

    public final static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException("Error closing database connection ", ex);
        }
    }
}
