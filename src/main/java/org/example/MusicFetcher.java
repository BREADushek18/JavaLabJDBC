package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MusicFetcher {
    private static final String URL = "jdbc:postgresql://localhost:5432/JavaLabJDBC";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void fetchAllMusic() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String selectSQL = "SELECT * FROM study.music;";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + ": " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}