package org.example;

import javax.swing.*;
//Here is my Main
public class Main {
//I want to add Welcome Page to see application and I enter This code
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new WelcomePage().setVisible(true);
            }
        });

    }
}