package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddFavoriteSong {
    private static final String URL = "jdbc:postgresql://localhost:5432/JavaLabJDBC";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void addFavoriteSong() {
        String insertQuery = "INSERT INTO study.music (id, name) VALUES (23, 'I Don''t Wanna Be Me')";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            int rowsAffected = statement.executeUpdate(insertQuery);
            System.out.println("Number of rows inserted: " + rowsAffected);

            // Вывод всех песен
            displayAllSongs(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayAllSongs(Statement statement) throws SQLException {
        String selectQuery = "SELECT * FROM study.music";
        ResultSet resultSet = statement.executeQuery(selectQuery);
        System.out.println("Current songs in the database:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("ID: " + id + ", Name: " + name);
        }
    }
}
