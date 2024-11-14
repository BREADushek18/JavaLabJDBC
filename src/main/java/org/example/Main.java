package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.initializeDatabase();

        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            System.out.println("Введите номер задания (от 1 до 8): ");
            int taskNumber = scanner.nextInt();
            switch (taskNumber) {
                case 1:
                    MusicFetcher.fetchAllMusic();
                    break;
                case 2:
                    MusicFilter.fetchFilteredMusic();
                    break;
                case 3:
                    AddFavoriteSong.addFavoriteSong();
                    break;
                case 4:
                    CreateBaVTables.createTables();
                    break;
                case 5:
                    SortedBooks.displaySortedBooks();
                    break;
                case 6:
                    Books2000.BooksYounger2000();
                    break;
                case 7:
                    AddPersonalInfo.addPersonalInfo();
                    break;
                case 8:
                    DeleteTables.deleteTables();
                    break;
                default:
                    System.out.println("Неверный номер задания.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
