package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Books2000 {
    private static final String URL = "jdbc:postgresql://localhost:5432/JavaLabJDBC";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void BooksYounger2000() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM study.books WHERE publishing_year >= 2000;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Book: " + resultSet.getString("name") + ", Year: " + resultSet.getInt("publishing_year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}