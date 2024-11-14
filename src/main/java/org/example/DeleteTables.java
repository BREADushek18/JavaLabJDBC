package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteTables {
    private static final String URL = "jdbc:postgresql://localhost:5432/JavaLabJDBC";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void deleteTables() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String dropVisitorsTable = "DROP TABLE IF EXISTS study.visitors;";
            String dropBooksTable = "DROP TABLE IF EXISTS study.books;";
            statement.executeUpdate(dropVisitorsTable);
            statement.executeUpdate(dropBooksTable);

            System.out.println("Таблицы удалены успешно.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}