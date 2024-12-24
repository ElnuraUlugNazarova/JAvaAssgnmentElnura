package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LibraryManagementSystem {

    private JTextField txtBookName, txtAuthor, txtISBN, txtDeleteBookId;
    private JTextArea textArea;
    private JButton btnAddBook, btnViewBooks, btnDeleteBook, btnUpdateBook;

    public LibraryManagementSystem() {
        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);  // Center the window

        // Create a panel with GridBagLayout for better control of the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBackground(new Color(238, 238, 238)); // Light gray background

        // Set font size for better visibility
        Font font = new Font("Arial", Font.PLAIN, 16);

        // Book Name
        JLabel lblBookName = new JLabel("Book Name:");
        lblBookName.setFont(font);
        txtBookName = new JTextField(20);
        txtBookName.setFont(font);
        addToPanel(panel, lblBookName, gbc, 0, 0, 1, 1);
        addToPanel(panel, txtBookName, gbc, 1, 0, 2, 1);

        // Author
        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setFont(font);
        txtAuthor = new JTextField(20);
        txtAuthor.setFont(font);
        addToPanel(panel, lblAuthor, gbc, 0, 1, 1, 1);
        addToPanel(panel, txtAuthor, gbc, 1, 1, 2, 1);

        // ISBN
        JLabel lblISBN = new JLabel("ISBN:");
        lblISBN.setFont(font);
        txtISBN = new JTextField(20);
        txtISBN.setFont(font);
        addToPanel(panel, lblISBN, gbc, 0, 2, 1, 1);
        addToPanel(panel, txtISBN, gbc, 1, 2, 2, 1);

        // Buttons with increased font size and more spacing
        btnAddBook = new JButton("Add Book");
        btnAddBook.setFont(new Font("Arial", Font.BOLD, 16));
        btnAddBook.setBackground(new Color(102, 204, 255)); // Light blue background
        btnViewBooks = new JButton("View Books");
        btnViewBooks.setFont(new Font("Arial", Font.BOLD, 16));
        btnViewBooks.setBackground(new Color(102, 204, 255));
        btnDeleteBook = new JButton("Delete Book");
        btnDeleteBook.setFont(new Font("Arial", Font.BOLD, 16));
        btnDeleteBook.setBackground(new Color(255, 102, 102)); // Red background
        btnUpdateBook = new JButton("Update Book");
        btnUpdateBook.setFont(new Font("Arial", Font.BOLD, 16));
        btnUpdateBook.setBackground(new Color(255, 204, 102)); // Yellow background

        // Organize buttons in a row
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(btnAddBook);
        buttonPanel.add(btnViewBooks);
        buttonPanel.add(btnDeleteBook);
        buttonPanel.add(btnUpdateBook);
        addToPanel(panel, buttonPanel, gbc, 0, 3, 3, 1);

        // Text area for displaying books
        textArea = new JTextArea(8, 30);
        textArea.setFont(font);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        addToPanel(panel, scrollPane, gbc, 0, 4, 3, 1);

        // Delete Book ID (for delete and update)
        JLabel lblDeleteBookId = new JLabel("Delete/Update Book ID:");
        lblDeleteBookId.setFont(font);
        txtDeleteBookId = new JTextField(10);
        txtDeleteBookId.setFont(font);
        addToPanel(panel, lblDeleteBookId, gbc, 0, 5, 1, 1);
        addToPanel(panel, txtDeleteBookId, gbc, 1, 5, 2, 1);

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);

        // Add Book ActionListener
        btnAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = txtBookName.getText();
                String author = txtAuthor.getText();
                String isbn = txtISBN.getText();

                if (bookName.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                } else {
                    BookOperations.addBook(bookName, author, isbn);
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                }

                // Clear fields
                txtBookName.setText("");
                txtAuthor.setText("");
                txtISBN.setText("");
            }
        });

        // View Books ActionListener
        btnViewBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the text area before adding new content
                textArea.setText("");

                // Fetch and display books from the database
                ArrayList<String> booksList = BookOperations.viewBooks();
                for (String book : booksList) {
                    textArea.append(book + "\n");
                }
            }
        });

        // Delete Book ActionListener
        btnDeleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int bookId = Integer.parseInt(txtDeleteBookId.getText());
                    BookOperations.deleteBook(bookId);
                    JOptionPane.showMessageDialog(frame, "Book deleted successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid Book ID.");
                }
                txtDeleteBookId.setText("");
            }
        });

        // Update Book ActionListener
        btnUpdateBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int bookId = Integer.parseInt(txtDeleteBookId.getText());
                    String bookName = txtBookName.getText();
                    String author = txtAuthor.getText();
                    String isbn = txtISBN.getText();

                    if (bookName.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                    } else {
                        BookOperations.updateBook(bookId, bookName, author, isbn);
                        JOptionPane.showMessageDialog(frame, "Book updated successfully!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid Book ID.");
                }

                // Clear fields
                txtBookName.setText("");
                txtAuthor.setText("");
                txtISBN.setText("");
                txtDeleteBookId.setText("");
            }
        });
    }

    // Helper method for adding components to the panel with GridBagLayout
    private void addToPanel(JPanel panel, Component component, GridBagConstraints gbc, int x, int y, int width, int height) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
        panel.add(component, gbc);
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}
