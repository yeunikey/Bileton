package team.bileton.application.gui;

import javax.swing.*;

public class MainGUI extends JFrame implements GUI {
    public MainGUI() {
        initialize();
    }

    @Override
    public void initialize() {
        setTitle("Biletone - Main GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
