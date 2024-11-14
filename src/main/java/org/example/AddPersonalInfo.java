package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddPersonalInfo {
    private static final String URL = "jdbc:postgresql://localhost:5432/JavaLabJDBC";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void addPersonalInfo() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String insertVisitor = "INSERT INTO study.visitors (name, surname, " +
                    "phone, subscribed) VALUES ('Dmitriy', 'Pshenichny', " +
                    "'800-555-3535', true) ON CONFLICT DO NOTHING;";
            statement.executeUpdate(insertVisitor);

            String insertBook1 = "INSERT INTO study.books (name, author, " +
                    "publishing_year, isbn, publisher) VALUES " +
                    "('Преступление и наказание', 'Достоевский Федор Михайлович', " +
                    "2024, '9483023859', 'МИФ') ON CONFLICT (isbn) DO NOTHING;";
            String insertBook2 = "INSERT INTO study.books (name, author, " +
                    "publishing_year, isbn, publisher) VALUES " +
                    "('Волшебник Изумрудного города', 'Волков Александр Мелентьевич'," +
                    " 2011, '673020058', 'РООССА') ON CONFLICT (isbn) DO NOTHING;";
            statement.executeUpdate(insertBook1);
            statement.executeUpdate(insertBook2);

            System.out.println("Информация добавлена успешно.");

            String selectVisitor = "SELECT * FROM study.visitors WHERE name = " +
                    "'Dmitriy' AND surname = 'Pshenichny';";
            ResultSet visitorResultSet = statement.executeQuery(selectVisitor);
            if (visitorResultSet.next()) {
                System.out.println("Информация о посетителе:");
                System.out.println("Имя: " + visitorResultSet.getString("name"));
                System.out.println("Фамилия: " + visitorResultSet.getString("surname"));
                System.out.println("Телефон: " + visitorResultSet.getString("phone"));
                System.out.println("Подписан: " + visitorResultSet.getBoolean("subscribed"));
            }

            // Вывод информации о любимых книгах
            String selectBooks = "SELECT * FROM study.books WHERE author = " +
                    "'Достоевский Федор Михайлович' OR author = 'Волков Александр Мелентьевич';";
            ResultSet booksResultSet = statement.executeQuery(selectBooks);
            System.out.println("Любимые книги:");
            while (booksResultSet.next()) {
                System.out.println("Название: " + booksResultSet.getString("name"));
                System.out.println("Автор: " + booksResultSet.getString("author"));
                System.out.println("Год издания: " + booksResultSet.getInt("publishing_year"));
                System.out.println("ISBN: " + booksResultSet.getString("isbn"));
                System.out.println("Издательство: " + booksResultSet.getString("publisher"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
