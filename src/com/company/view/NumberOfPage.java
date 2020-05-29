package com.company.view;

import com.company.controller.MainWindowController;

import javax.swing.*;
import java.awt.*;

public class NumberOfPage {
    private JButton SubmitButton;


    private MainWindowController controller;

    public NumberOfPage(MainWindowController controller) {
        this.controller = controller;
    }

    public void init() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 100, 150);
        frame.setTitle("What page?");


        SubmitButton = new JButton("Submit");
        SubmitButton.setLocation(10, 40);
        SubmitButton.setSize(100, 50);

        JTextField textNum = new JTextField();
        textNum.setSize(100, 20);
        textNum.setLocation(10, 10);


        panel.add(SubmitButton);
        panel.add(textNum);


        SubmitButton.addActionListener(e -> {
            String tempNum = textNum.getText();

            controller.numOfPage(Integer.parseInt(tempNum));

            frame.dispose();
            MainWindow mainWindow = new MainWindow(controller);
            mainWindow.init();

        });


        frame.setVisible(true);
        frame.setContentPane(panel);
    }
}
