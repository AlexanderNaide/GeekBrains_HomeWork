package ru.gb.HomeWorks.lesson8;

import javax.swing.*;
import java.awt.*;

public class HomeWorkApp {
    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;

    public static void main(String[] args) {
        new ExampleWindow();
    }

    public static class ExampleWindow extends JFrame{

        public ExampleWindow(){
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setTitle("My GUI example");
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            JButton button = new JButton("BUTTON");
            panel.add(button, BorderLayout.NORTH);
            JButton button2 = new JButton("BUTTON2");
            panel.add(button2, BorderLayout.SOUTH);
            add(panel, BorderLayout.SOUTH);

            JMenuBar bar = new JMenuBar();
            JMenu fileMenu = new JMenu("File");
            JMenuItem createItem = new JMenuItem("Create");
            JMenuItem exitItem = new JMenuItem("Exit");
            JMenu editMenu = new JMenu("Edit");
            JMenu helpMenu = new JMenu("Help");

            bar.add(fileMenu);
            bar.add(editMenu);
            bar.add(helpMenu);

            add(bar, BorderLayout.NORTH);

            JLabel label = new JLabel("Press the button");
            label.setFont(new Font("Times new Roman", Font.BOLD, 12));
            add(label);



            setVisible(true);
        }
    }
}
