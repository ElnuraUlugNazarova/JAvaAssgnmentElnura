package org.example;

import org.example.LibraryManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    public LoginPage() {
        // Set the title of the window
        setTitle("Login");

        // Set the layout to null for manual positioning of components
        setLayout(null);

        // Set window size and behavior
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 30, 100, 30);  // Positioning the label
        add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 30, 150, 30); // Positioning the field
        add(usernameField);

        // Create password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 80, 100, 30);  // Positioning the label
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 80, 150, 30); // Positioning the field
        add(passwordField);

        // Create the login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 130, 100, 40); // Positioning the button
        add(loginButton);

        // Predefined username and password for validation
        String validUsername = "admin";
        String validPassword = "password123";

        // Action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the username and password entered by the user
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check if the entered username and password match the predefined ones
                if (username.equals(validUsername) && password.equals(validPassword)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    // Open Library Management System
                    new LibraryManagementSystem();
                    setVisible(false);  // Hide the login page
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
                }
            }
        });

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the LoginPage
        new LoginPage();
    }
}
