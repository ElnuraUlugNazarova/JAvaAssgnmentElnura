package org.example;

import java.sql.*;
import java.util.ArrayList;

public class BookOperations {

    // Add Book to MySQL Database
    public static void addBook(String bookName, String author, String isbn) {
        String sql = "INSERT INTO books (name, author, isbn) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bookName);
            stmt.setString(2, author);
            stmt.setString(3, isbn);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new book was added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch all books from the database
    public static ArrayList<String> viewBooks() {
        ArrayList<String> booksList = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String isbn = rs.getString("isbn");

                booksList.add("ID: " + id + ", Name: " + name + ", Author: " + author + ", ISBN: " + isbn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booksList;
    }

    // Delete a book by its ID
    public static void deleteBook(int bookId) {
        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A book was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update book details by ID
    public static void updateBook(int bookId, String bookName, String author, String isbn) {
        String sql = "UPDATE books SET name = ?, author = ?, isbn = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bookName);
            stmt.setString(2, author);
            stmt.setString(3, isbn);
            stmt.setInt(4, bookId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("The book was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
