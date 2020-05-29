package com.company.view;

import com.company.controller.MainWindowController;

import javax.swing.*;
import java.awt.*;


public class DownloadChoose extends JFrame {


    private JButton firstButton, secondButton, thirdButton;


    private MainWindowController controller;

    public DownloadChoose(MainWindowController controller) {
        this.controller = controller;
    }

    public void init() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 300, 110);
        frame.setTitle("what download?");


        firstButton = new JButton("file 1");
        firstButton.setLocation(20, 10);
        firstButton.setSize(70, 50);

        secondButton = new JButton("file 2");
        secondButton.setLocation(110, 10);
        secondButton.setSize(70, 50);

        thirdButton = new JButton("file 3");
        thirdButton.setLocation(200, 10);
        thirdButton.setSize(70, 50);


        panel.add(firstButton);
        panel.add(secondButton);
        panel.add(thirdButton);


        firstButton.addActionListener(e -> {
            controller.fileChose(1);
            frame.dispose();
            MainWindow mainWindow = new MainWindow(controller);
                mainWindow.init();
        });

        secondButton.addActionListener(e -> {
            controller.fileChose(2);
            frame.dispose();
            MainWindow mainWindow = new MainWindow(controller);
                mainWindow.init();
        });

        thirdButton.addActionListener(e -> {
            controller.fileChose(3);
            frame.dispose();
            MainWindow mainWindow = new MainWindow(controller);
                mainWindow.init();
        });


        frame.setVisible(true);
        frame.setContentPane(panel);
    }
}


