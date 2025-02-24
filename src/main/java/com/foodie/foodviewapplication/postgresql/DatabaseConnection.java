package com.foodie.foodviewapplication.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/dbFoodView?currentSchema=foodview";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión establecida exitosamente.");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("Error al establecer la conexión: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada exitosamente.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}