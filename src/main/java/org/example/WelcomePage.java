package org.example;

import org.example.LoginPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {

    public WelcomePage() {
        // Set the title of the window
        setTitle("Welcome Page");

        // Set the layout to null to manually position components
        setLayout(null);

        // Set window size and behavior
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the label for "Welcome Library" at the top-right
        JLabel welcomeLabel = new JLabel("Welcome Library");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setBounds(420, 20, 160, 30); // Positioned at top-right
        add(welcomeLabel);

        // Create the label for "Created by Diyorbek Tuxtapulatov" at the bottom-right
        JLabel createdByLabel = new JLabel("Created by Ulugnazarova Elnura");
        createdByLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        createdByLabel.setBounds(380, 320, 220, 30); // Positioned at bottom-right
        add(createdByLabel);

        // Create the login button at the center
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        loginButton.setBounds(250, 150, 100, 40); // Positioned at center
        add(loginButton);

        // Action listener for the login button (to navigate to the registration page)
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the registration page
                new LoginPage();
                setVisible(false);  // Hide current window (optional)
            }
        });

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the welcome page when the application starts
        new WelcomePage();
    }
}
