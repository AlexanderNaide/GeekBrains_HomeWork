package ru.gb.HomeWorks.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWorkApp {
    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;

    public static void main(String[] args) {
        new ExampleWindow();
    }

    public static class ExampleWindow extends JFrame{

        private int counter;

        public ExampleWindow(){
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setTitle("My GUI example");
            JButton button = new JButton("BUTTON");
            JButton button2 = new JButton("BUTTON2");
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.add(button, BorderLayout.NORTH);
            panel.add(button2, BorderLayout.SOUTH);
            add(panel, BorderLayout.SOUTH);

            JMenuBar bar = new JMenuBar();
            JMenu fileMenu = new JMenu("File");
            JMenu editMenu = new JMenu("Edit");
            JMenu helpMenu = new JMenu("Help");
            JMenuItem createItem = new JMenuItem("Create");
            JMenuItem exitItem = new JMenuItem("Exit");


            bar.add(fileMenu);
            bar.add(editMenu);
            bar.add(helpMenu);

            fileMenu.add(createItem);
            fileMenu.add(exitItem);

            add(bar, BorderLayout.NORTH);

            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(1);
                }
            });

            JLabel label = new JLabel("Press the button");
            label.setFont(new Font("Times new Roman", Font.BOLD, 50));
            add(label);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    counter++;
                    label.setText("COUNTER: " + counter) ;
                }
            });

            button2.addActionListener((e) -> {
                counter--;
                label.setText("COUNTER: " + counter) ;
            });



            setVisible(true);
        }
    }
}
