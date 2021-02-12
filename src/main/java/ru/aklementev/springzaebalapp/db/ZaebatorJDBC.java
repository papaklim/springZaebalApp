package ru.aklementev.springzaebalapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ZaebatorJDBC {

    private static final String DB_URL = "jdbc:h2:file:./zaebaldb";
    private static final String DB_DRIVER = "org.h2.Driver";
    private static Connection connection;
    private final String tableName;

    public ZaebatorJDBC(String tableName) {
        this.tableName = tableName;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void connect() {
        try {
            //Check JDBC Driver
            Class.forName(DB_DRIVER);
            connection = getConnection();
            System.out.println("Connected to DB");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found: " + ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Shit happens " + ex);
            ex.printStackTrace();
        }
    }

    public static void close() throws SQLException {
        connection.close();
        System.out.println("Disconnected from DB");
    }

}
